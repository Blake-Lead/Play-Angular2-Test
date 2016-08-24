import {Component, OnInit}                   from '@angular/core';

import {ModalResult}                         from 'ng2-bs3-modal/ng2-bs3-modal';

import {IpBaseService}                       from '../services/ipbase.service';

import {Address}                             from '../models/address';
import {Group}                               from '../models/group';

@Component({
    selector: 'ipbase',
    templateUrl: 'app/views/ipbase.html'
})
export class IpBaseComponent implements OnInit {

    addresses: Address[];
    groups: Group[];
    address: Address;
    group: Group;
    idToDelete: number;

    constructor(private ipBaseService: IpBaseService) {
        this.addresses = new Array<Address>();
        this.groups = new Array<Group>();
        this.address = new Address;
        this.group = new Group;
        this.idToDelete = -1;
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

    onCloseAddModal(result: ModalResult) {
        this.ipBaseService.createAddress(this.address)
        .subscribe(res => {
            if (res === 'true') {
                this.address = new Address;
                window.location.reload();
            }
        }, err => console.log(err));
    }

    onCloseDeleteModal(result: ModalResult) {
        this.ipBaseService.deleteAddress(this.idToDelete)
        .subscribe(res => {
            if (res === 'true') {
                this.addresses.splice(this.addresses.indexOf(this.addresses.find(add => add.id === this.idToDelete)), 1);
                window.location.reload();
            }
        }, err => console.log(err));
        this.idToDelete = -1;
    }

    onCloseAddGroupModal(result: ModalResult) {
        this.ipBaseService.createGroup(this.group)
        .subscribe(res => {
            if (res === 'true') {
                this.group = new Group;
                window.location.reload();
            }
        }, err => console.log(err));
    }

}