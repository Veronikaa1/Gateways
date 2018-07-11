import {DeviceComponent} from './device/device.component';
import {DevicesListComponent} from './devices-list/devices-list.component';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  [x: string]: any;

  constructor(private http: HttpClient) {}

  sleep(ms) {
    return new Promise(r => setTimeout(r, ms));
  }

//  getAll(id) {
//
//    console.log("ID here: " + id);
//    let dcomp = new DevicesListComponent(new DeviceComponent(this.http));
//    dcomp.onClickGetData(id);
//
//  }
  
}
