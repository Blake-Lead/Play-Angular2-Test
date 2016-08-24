import {Injectable} from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable }     from 'rxjs/Rx';

import {Article} from '../models/article';
import {Category} from '../models/category';

@Injectable()
export class WikiService {

    constructor(private http: Http) {}

    private articlesUrl = 'http://localhost:9000/articles';
    private categoriesUrl = 'http://localhost:9000/categories';

    getArticles(): Observable<Article[]> {
        return this.http.get(this.articlesUrl)
        .map(resp => resp.json())
        .catch(err => Observable.throw(err.message));
    }
    getArticle(id: number): Observable<Article> {
        return this.http.get(this.articlesUrl + '/' + id)
        .map(resp => resp.json())
        .catch(err => Observable.throw(err.message));
    }
    createArticle(article: Article) {
        return this.http.post(this.articlesUrl, article)
        .map(resp => resp.json())
        .catch(err => err.message);
    }
    updateArticle(article: Article) {
        return this.http.put(this.articlesUrl, article)
        .map(resp => resp.json())
        .catch(err => err.message);
    }
    deleteArticle(id: number) {
        return this.http.delete(this.articlesUrl + '/' + id)
        .map(resp => resp.json())
        .catch(err => err.message);
    }

    getCategories(): Observable<Category[]> {
        return this.http.get(this.categoriesUrl)
        .map(resp => resp.json())
        .catch(err => Observable.throw(err.message));
    }
    getCategory(id: number): Observable<Category> {
        return this.http.get(this.categoriesUrl + '/' + id)
        .map(resp => resp.json())
        .catch(err => Observable.throw(err.message));
    }
    createCategory(category: Category) {
        return this.http.post(this.categoriesUrl, category)
        .map(resp => resp.json())
        .catch(err => err.message);
    }
    updateCategory(category: Category) {
        return this.http.put(this.categoriesUrl, category)
        .map(resp => resp.json())
        .catch(err => err.message);
    }
    deleteCategory(id: number) {
        return this.http.delete(this.categoriesUrl + '/' + id)
        .map(resp => resp.json())
        .catch(err => err.message);
    }
}