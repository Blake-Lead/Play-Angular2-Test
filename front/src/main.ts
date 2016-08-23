import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';

platformBrowserDynamic().bootstrapModule(AppModule);

/*
import {bootstrap} from '@angular/platform-browser-dynamic';
import { HTTP_PROVIDERS } from '@angular/http';
import {appRouterProviders} from './app/app.routes';
import {AppComponent} from './app/components/app.component';

// Specify root level component and inject main submodules
bootstrap(AppComponent, [appRouterProviders, HTTP_PROVIDERS]);
*/