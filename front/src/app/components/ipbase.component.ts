import {Component, OnInit} from '@angular/core';
import {Modal} from 'angular2-modal/plugins/bootstrap';
import {Address} from '../models/address';
import {Group} from '../models/group';
import {IpBaseService} from '../services/ipbase.service';

@Component({
    selector: 'ipbase',
    templateUrl: 'app/views/ipbase.html'
})
export class IpBaseComponent implements OnInit {

    addresses: Address[];
    groups: Group[];

    constructor(private ipBaseService: IpBaseService) {
        this.addresses = new Array<Address>();
        this.groups = new Array<Group>();
    }

    ngOnInit() {
        this.ipBaseService.getAddresses().subscribe(add => this.addresses = add, error => console.log(error));
        this.ipBaseService.getGroups().subscribe(groups => this.groups = groups, error => console.log(error));
    }

    getGroupName(id: number): string {
        if (this.groups.length > 0) {
            return this.groups.find(group => group.id == id).name;
        }
    }

    openModal() {
        console.log('modal');
    }
}