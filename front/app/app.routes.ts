
import {Routes, RouterModule}    from '@angular/router';
import {AppComponent}            from './components/app.component';
import {WikiBrowseComponent}     from './components/wiki-browse.component';
import {WikiEditComponent}       from './components/wiki-edit.component';
import {WikiViewComponent}       from './components/wiki-view.component';
import {IpBaseComponent}         from './components/ipbase.component';
import {RegistryComponent}       from './components/registry.component';

const routes: Routes = [
{
    path: 'wiki/browse',
    component: WikiBrowseComponent
},
{
    path: 'wiki/edit/:id',
    component: WikiEditComponent
},
{
    path: 'wiki/view/:id',
    component: WikiViewComponent
},
{
    path: 'ipbase',
    component: IpBaseComponent
},
{
    path: 'registry',
    component: RegistryComponent
},
{
    path: '**',
    redirectTo: '',
    pathMatch: 'full'
}
];

export const routing = RouterModule.forRoot(routes);
