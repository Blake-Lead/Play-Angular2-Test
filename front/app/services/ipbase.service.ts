import {Injectable} from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable }     from 'rxjs/Rx';

import {Address} from '../models/address';
import {Group} from '../models/group';

@Injectable()
export class IpBaseService {

    constructor(private http: Http) {}

    private addressesUrl = 'http://localhost:9001/addresses';
    private groupsUrl = 'http://localhost:9001/groups';

    getAddresses(): Observable<Address[]> {
        return this.http.get(this.addressesUrl)
        .map(resp => resp.json())
        .catch(err => Observable.throw(err.message));
    }
    getAddress(id: number): Observable<Address> {
        return this.http.get(this.addressesUrl + '/' + id)
        .map(resp => resp.json())
        .catch(err => Observable.throw(err.message));
    }
    createAddress(address: Address) {
        return this.http.post(this.addressesUrl, address)
        .map(resp => resp.json())
        .catch(err => err.message);
    }
    updateAddress(address: Address) {
        return this.http.put(this.addressesUrl, address)
        .map(resp => resp.json())
        .catch(err => err.message);
    }
    deleteAddress(id: number) {
        return this.http.delete(this.addressesUrl + '/' + id)
        .map(resp => resp.json())
        .catch(err => err.message);
    }

    getGroups(): Observable<Group[]> {
        return this.http.get(this.groupsUrl)
        .map(resp => resp.json())
        .catch(err => Observable.throw(err.message));
    }
    getGroup(id: number): Observable<Group> {
        return this.http.get(this.groupsUrl + '/' + id)
        .map(resp => resp.json())
        .catch(err => Observable.throw(err.message));
    }
    createGroup(group: Group) {
        return this.http.post(this.groupsUrl, group)
        .map(resp => resp.json())
        .catch(err => err.message);
    }
    updateGroup(group: Group) {
        return this.http.put(this.groupsUrl, group)
        .map(resp => resp.json())
        .catch(err => err.message);
    }
    deleteGroup(id: number) {
        return this.http.delete(this.groupsUrl + '/' + id)
        .map(resp => resp.json())
        .catch(err => err.message);
    }
}