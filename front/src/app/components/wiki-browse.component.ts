import {Component, OnInit} from '@angular/core';
import {WikiService} from '../services/wiki.service';
import {MarkedService} from '../services/marked.service';
import {Router} from '@angular/router';
import {Article} from '../models/article';
import {Category} from '../models/category';

@Component({
    selector: 'wiki',
    templateUrl: 'app/views/wiki-browse.html'
})
export class WikiBrowseComponent implements OnInit {

    articles: Article[];
    categories: Category[];

    constructor(private wikiService: WikiService, private markedService: MarkedService, private router: Router) {
        this.articles = new Array<Article>();
        this.categories = new Array<Category>();
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
            location.reload();
        },
        error => console.log(error));
    }
}