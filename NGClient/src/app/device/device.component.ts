import {Component, OnInit} from '@angular/core';
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RequestOptions} from '@angular/http';
import {Observable} from 'rxjs';


@Component({
  selector: 'app-device',
  templateUrl: './device.component.html',
  styleUrls: ['./device.component.css']
})
export class DeviceComponent implements OnInit {
  [x: string]: any;

  uid = '';

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
  }

  getAll(id): Observable<any> {

    console.log("aaaaaaand here " + id)
    return this.http.get('//localhost:8080/devices?id=' + id);
  }

  deleteDevice(uid): void {
    console.log('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ' + uid);
    this.http.get('//localhost:8080/devices/delete?uid=' + uid).subscribe();
  }


  saveDevice(device): void {

    console.log('bbbbbbbbbbbb ' + device.uid + "  " + device.status);
    this.http.post('//localhost:8080/devices/add', device).subscribe();

  }


}