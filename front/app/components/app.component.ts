import {Component}            from '@angular/core';

import {WikiBrowseComponent}  from './wiki-browse.component';
import {WikiViewComponent}    from './wiki-view.component';
import {WikiEditComponent}    from './wiki-edit.component';

@Component({
    selector: 'app',
    template: `
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li><a [routerLink]="['/wiki/browse']">WIKI</a></li>
                <li><a [routerLink]="['/ipbase']">IPBASE</a></li>
                <li><a [routerLink]="['/registry']">REGISTRY</a></li>
            </ul>
        </div>
    </nav>
    <router-outlet></router-outlet>`
})
export class AppComponent {}