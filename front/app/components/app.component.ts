import {Component}            from '@angular/core';

import {WikiBrowseComponent}  from './wiki-browse.component';
import {WikiViewComponent}    from './wiki-view.component';
import {WikiEditComponent}    from './wiki-edit.component';

@Component({
    selector: 'app',
    template: `
    <div class="row">
        <div class = "col-md-12">
            <div class="panel">
                The ToolBox
            </div>
        </div> 
    </div>

    <nav class="sidebar col-md-2">
        <ul class="list-group">
            
                <a [routerLink]="['home']" class="list-group-item">
                    <i class="fa fa-fw fa-dashboard"></i>HOME
                </a>
                <a class="list-group-item collapse panel-header" data-toggle="collapse" href="#id1">
                    <span><i class="fa fa-plus"></i>WIKI</span>
                
                    <div id="id1" class="panel-collapse collapse">
                        <ul class="list-group">
                            <li>
                                <a [routerLink]="['/wiki/edit/0']" href><span>Nouvel Article</span></a>
                            </li>
                            <li>
                                <a [routerLink]="['/wiki/browse']" href><span>Voir Articles</span></a>
                            </li>
                        </ul>
                   </div>
                </a>

                <a [routerLink]="['/ipbase']" class="list-group-item">
                    <i class="fa fa-fw fa-bar-chart-o"></i> IPBASE
                </a>
                <a [routerLink]="['/registry']" class="list-group-item">
                    <i class="fa fa-fw fa-table"></i> REGISTRY
                </a>
               
            </ul>
    </nav>
    <router-outlet></router-outlet>`
})
export class AppComponent {}