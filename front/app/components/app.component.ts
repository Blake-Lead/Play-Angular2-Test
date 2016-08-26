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
/*
@Component({
    selector: 'app',
    template: `
    <div class="wrapper">
         <div id="main-menu">
             <div id = "title">
                <h3>The Tool Box</h3>
            </div>
            <ul id="left-menu">
                <li class="item"><a class="item-link active" [routerLink]="['/wiki/browse']">WIKI</a></li>
                <li class="item"><a class="item-link active" [routerLink]="['/ipbase']">IPBASE</a></li>
                <li class="item"><a class="item-link active" [routerLink]="['/registry']">REGISTRY</a></li>
             </ul>
         </div>
         <div id="content">
             <router-outlet></router-outlet>
         </div>
         <div id="right-menu">
                <div id="ss-menu-connexion"><img class="profile" src="app/views/images/profile.png"></i></div>
                <div id="ss-menu-theme">Thème</div>
         </div>
     </div>
    `
})*/
export class AppComponent {}