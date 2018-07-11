import {DataService} from '../data.service';
import {DeviceComponent} from '../device/device.component';
import {StylesCompileDependency} from '@angular/compiler';
import {Component, OnInit, Injectable} from '@angular/core';

@Component({
  selector: 'app-devices-list',
  templateUrl: './devices-list.component.html',
  styleUrls: ['./devices-list.component.css']
})

export class DevicesListComponent implements OnInit {

  devices: Array<any>;
  openInputTemplate = false;
  uid = '';
  vendor = '';
  date = '';
  status = '';
  gateway_id = '';

  constructor(private deviceComponent: DeviceComponent) {}

  ngOnInit() {
    // this.getAll();
  }

  sleep(ms) {
    return new Promise(r => setTimeout(r, ms));
  }

  getAll(id) {

    this.deviceComponent.getAll(id).subscribe(data => {
      this.devices = data;
      console.log(this.devices);
    });

  }


  async onDelete(device, index) {
    //deletes the element from DB -> calling BE
    this.deviceComponent.deleteDevice(device.uid);
    await this.sleep(100);
    this.getAll(device.gateway_id);
  }


  onClickCreate() {
    this.openInputTemplate = true;
  }

  async onClickSave() {

    console.log("klsdjfklsdfj");
    console.log('axaxaxaxax ' + this.uid + "  " + this.status);

    let device = {uid: this.uid, vendor: this.vendor, creation_date: this.date, status: this.status, gateway_id: this.gateway_id};
    this.deviceComponent.saveDevice(device);
    await this.sleep(100);
    this.getAll(this.gateway_id);
    this.openInputTemplate = false;

  }
}
