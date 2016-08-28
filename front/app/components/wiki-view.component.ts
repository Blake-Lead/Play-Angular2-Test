import {Component, OnInit} from '@angular/core';
import {WikiService} from '../services/wiki.service';
import {MarkedService} from '../services/marked.service';
import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
import {Article} from '../models/article';
import {Category} from '../models/category';

@Component({
    selector: 'wiki-view',
    templateUrl: 'app/views/wiki-view.html',
    styleUrls: ['app/styles/style.css']

})
export class WikiViewComponent implements OnInit {

    article: Article;
    articleMd: string;

    constructor(private wikiService: WikiService, private markedService: MarkedService, private route: ActivatedRoute, private router: Router) {
        this.article = new Article();
        this.articleMd = '';
    }

    ngOnInit() {
        this.route.params.subscribe(params => this.getArticle(params['id']));
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

    deleteArticle() {
        this.wikiService.deleteArticle(this.article.id).subscribe(resp => console.log(resp), error => console.log(error));
    }

    editArticle() {
        let link = ['wiki/edit', this.article.id];
        this.router.navigate(link);
    }

    goBack() {
        window.history.back();
    }
}