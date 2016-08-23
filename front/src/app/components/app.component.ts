import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {WikiBrowseComponent} from './wiki-browse.component';
import {WikiViewComponent} from './wiki-view.component';
import {WikiEditComponent} from './wiki-edit.component';

@Component({
    selector: 'my-app',
    templateUrl: 'app/views/home.html'
})
export class AppComponent {

    constructor(private router: Router) {}

    gotoWiki() { this.router.navigate(['wiki/browse']); }

    gotoIpBase() { this.router.navigate(['ipbase']); }

    gotoRegistry() { this.router.navigate(['registry']); }
}