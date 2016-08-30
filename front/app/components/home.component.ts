import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'home',
    templateUrl: 'app/views/home.html'
})
export class HomeComponent {

    constructor(private router: Router) {}

    gotoWikiBrowse() { this.router.navigate(['wiki/browse']); }

    gotoWikiEdit() { this.router.navigate(['wiki/edit/0']); }

    gotoIpBase() { this.router.navigate(['ipbase']); }

    gotoRegistry() { this.router.navigate(['registry']); }

}
