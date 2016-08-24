import {NgModule}               from '@angular/core';
import {BrowserModule}          from '@angular/platform-browser';
import {FormsModule}            from '@angular/forms';
import {HttpModule}             from '@angular/http';

import {routing}                from './app.routes';

import {AppComponent}           from './components/app.component';
import {WikiBrowseComponent}    from './components/wiki-browse.component';
import {WikiViewComponent}      from './components/wiki-view.component';
import {WikiEditComponent}      from './components/wiki-edit.component';
import {IpBaseComponent}        from './components/ipbase.component';
import {RegistryComponent}      from './components/registry.component';

import {WikiService}            from './services/wiki.service';
import {MarkedService}          from './services/marked.service';
import {IpBaseService}          from './services/ipbase.service';
import { MODAL_DIRECTIVES }     from 'ng2-bs3-modal/ng2-bs3-modal';

@NgModule({
    imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
    ],

    declarations: [
    AppComponent,
    WikiBrowseComponent,
    WikiViewComponent,
    WikiEditComponent,
    IpBaseComponent,
    RegistryComponent,
    MODAL_DIRECTIVES
    ],

    providers: [
    WikiService,
    MarkedService,
    IpBaseService
    ],

    bootstrap: [AppComponent]
})
export class AppModule {}