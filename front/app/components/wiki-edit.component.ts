import {Component, OnInit} from '@angular/core';
import {WikiService} from '../services/wiki.service';
import {MarkedService} from '../services/marked.service';
import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
import {Article} from '../models/article';
import {Category} from '../models/category';

@Component({
    selector: 'wiki-edit',
    templateUrl: 'app/views/wiki-edit.html',
    styleUrls: ['app/styles/style.css']

})
export class WikiEditComponent implements OnInit {

    article: Article;
    articleMd: string;
    categories: Category[];

    constructor(private wikiService: WikiService, private markedService: MarkedService, private route: ActivatedRoute, private router: Router) {
        this.categories = new Array<Category>();
        this.article = new Article();
        this.article.id = 0;
        this.articleMd = '';
    }

    ngOnInit() {
        this.wikiService.getCategories().subscribe(categories => this.categories = categories, error => console.log(error));
        this.route.params.subscribe(params => {
            if (+params['id'] !== 0) {
                this.getArticle(params['id']);
            }
        });
    }

    getArticle(id: number) {
        this.wikiService.getArticle(id)
        .subscribe(
            article => {
                this.article = article;
                this.articleMd = this.markedService.parse(article.body);
            },
            error => console.log(error));
    }

    parseMarkdown(text: string) {
        this.articleMd = this.markedService.parse(text);
    }

    saveArticle() {
        console.log(this.article);
        if (this.article.title == null || this.article.author == null || this.article.body == null || this.article.categoryId == null) {
            console.log('Cannot save article : some fields are empty');
            return;
        }
        if (this.article.id === 0) {
            this.wikiService.createArticle(this.article).subscribe(resp => console.log(resp), error => console.log(error));
        }
        else {
            this.wikiService.updateArticle(this.article).subscribe(resp => console.log(resp), error => console.log(error));
        }
        this.gotoWikiBrowse();
    }

    gotoWikiBrowse() {
        let link = ['wiki/browse'];
        this.router.navigate(link);
    }

    goBack() {
        window.history.back();
    }
}