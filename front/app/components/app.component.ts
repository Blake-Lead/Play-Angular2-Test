import {Component}            from '@angular/core';

import {HomeComponent}        from './home.component';



@Component({
    selector: 'app',
    template: `
    <div class="row topnav">
        <div class = "col-md-12">
            <div class="panel header">
                The ToolBox
            </div>
        </div> 
    </div>

    <div class="sidenav">
        <nav class="sidebar col-md-1">
            <ul class="list-group group-left">
                <a [routerLink]="['home']" class="list-group-item">
                    <i class="fa fa-home"></i>&nbsp;HOME
                </a>
                <a class="list-group-item collapse panel-header" data-toggle="collapse" href="#id1">
                    <span><i class="fa fa-newspaper-o"></i>&nbsp;WIKI</span>
                
                    <div id="id1" class="panel-collapse collapse">
                        <ul class="list-group submenu">
                            <li>
                                <a class="submenu" [routerLink]="['/wiki/edit/0']" href><span>Nouvel Article</span></a>
                            </li>
                            <li>
                                <a class="submenu" [routerLink]="['/wiki/browse']" href><span>Voir Articles</span></a>
                            </li>
                        </ul>
                   </div>
                </a>

                <a [routerLink]="['/ipbase']" class="list-group-item">
                    <i class="fa fa-link"></i>&nbsp;IPBASE
                </a>
                <a [routerLink]="['/registry']" class="list-group-item">
                    <i class="fa fa-envira"></i>&nbsp;REGISTRY
                </a>
                   
            </ul>
        </nav>
    </div>
    <div class="col-md-11">
    <router-outlet></router-outlet>
    </div>`
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