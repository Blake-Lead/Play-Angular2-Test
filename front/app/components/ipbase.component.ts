import {Component, OnInit, ChangeDetectorRef} from '@angular/core';
import {ModalResult}                          from 'ng2-bs3-modal/ng2-bs3-modal';
import {IpBaseService}                        from '../services/ipbase.service';
import {Address}                              from '../models/address';
import {Group}                                from '../models/group';

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

    constructor(private ref: ChangeDetectorRef, private ipBaseService: IpBaseService) {
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
            this.ipBaseService.getAddresses().subscribe(add => this.addresses = add, error => console.log(error));
            this.address = new Address;
        }, err => console.log(err));
    }

    onCloseDeleteModal(result: ModalResult) {
        this.ipBaseService.deleteAddress(this.idToDelete)
        .subscribe(res => {
            this.addresses.splice(this.addresses.indexOf(this.addresses.find(add => add.id === this.idToDelete)), 1);
            this.ipBaseService.getAddresses().subscribe(add => this.addresses = add, error => console.log(error));
        }, err => console.log(err));
        this.idToDelete = -1;
    }

    onCloseAddGroupModal(result: ModalResult) {
        this.ipBaseService.createGroup(this.group)
        .subscribe(res => {
            this.ipBaseService.getGroups().subscribe(groups => this.groups = groups, error => console.log(error));
            this.group = new Group;
        }, err => console.log(err));
    }

    addressIsValid(a: Address) {
        return (a.ip != null && a.ip.length < 16 &&
            a.description != null && a.description.length < 100 &&
            a.port != null);
    }

    groupIsValid(g: Group) {
        return (g.name != null && g.name.length < 41 &&
            g.description != null && g.description.length < 100);
    }

}