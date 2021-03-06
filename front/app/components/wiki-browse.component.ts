import {Component, OnInit, ChangeDetectorRef } from '@angular/core';
import {ModalResult}                           from 'ng2-bs3-modal/ng2-bs3-modal';
import {WikiService}                           from '../services/wiki.service';
import {MarkedService}                         from '../services/marked.service';
import {Router}                                from '@angular/router';
import {Article}                               from '../models/article';
import {Category}                              from '../models/category';

@Component({
    selector: 'wiki',
    templateUrl: 'app/views/wiki-browse.html'
})
export class WikiBrowseComponent implements OnInit {

    articles: Article[];
    categories: Category[];
    category: Category;
    idToDelete: number;

    constructor(private ref: ChangeDetectorRef, private wikiService: WikiService, private markedService: MarkedService, private router: Router) {
        this.articles = new Array<Article>();
        this.categories = new Array<Category>();
        this.category = new Category;
    }

    ngOnInit() {
        this.wikiService.getArticles().subscribe(articles => this.articles = articles, error => console.log(error));
        this.wikiService.getCategories().subscribe(categories => this.categories = categories, error => console.log(error));
    }

    getArticlesByCategory(id: number) {
        return this.articles.filter(art => art.categoryId === id);
    }

    parseMarkdown(src: string) {
        return this.markedService.parse(src)
    }

    gotoArticle(id: number) {
        let link = ['wiki/view', id];
        this.router.navigate(link);
    }

    createArticle() {
        let link = ['wiki/edit', 0];
        this.router.navigate(link);
    }

    editArticle(id: number) {
        let link = ['wiki/edit', id];
        this.router.navigate(link);
    }

    deleteArticle(id: number) {
        this.wikiService.deleteArticle(id)
        .subscribe(resp => {
            console.log(resp);
            this.wikiService.getArticles()
            .subscribe(articles => {
                this.articles = articles;
                this.ref.detectChanges();
            },
            error => console.log(error));
        },
        error => console.log(error));
    }

    onCloseAddCategoryModal(result: ModalResult) {
        this.wikiService.createCategory(this.category)
        .subscribe(res => {
            this.wikiService.getCategories().subscribe(categories => this.categories = categories, error => console.log(error));
            this.category = new Category;
        }, err => console.log(err));
    }

    onCloseDeleteArticleModal(result: ModalResult) {
        this.deleteArticle(this.idToDelete);
    }

    categoryIsValid(c: Category) {
        return (c.tag != null && c.tag.length < 41 &&
            c.description != null && c.description.length < 100);
    }
}