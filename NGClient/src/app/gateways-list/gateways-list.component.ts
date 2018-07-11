import {AppComponent} from '../app.component';
import {AppModule} from '../app.module';
import {DataService} from '../data.service';
import {DeviceComponent} from '../device/device.component';

import {GatewayComponent} from '../gateway/gateway.component';
import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {DevicesListComponent} from '../devices-list/devices-list.component';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-gateways-list',
  templateUrl: './gateways-list.component.html',
  styleUrls: ['./gateways-list.component.css']
})
export class GatewaysListComponent implements OnInit {
  [x: string]: any;

  gateways: Array<any>;
  openInputTemplate = false;
  showDevices = false;
  id = '';
  name = '';
  ipv4 = '';
  errorMesageGW = '';
  res = '';

  constructor(private gatewayComponent: GatewayComponent, private data: DataService) {}

  ngOnInit() {

    this.getAllData();
  }

  sleep(ms) {
    return new Promise(r => setTimeout(r, ms));
  }

  getAllData() {
    this.gatewayComponent.getAll().subscribe(data => {
      this.gateways = data;
      console.log(data);
    });
  }


  async onDelete(gateway, index) {
    //deletes the element from DB -> calling BE
    this.gatewayComponent.deleteDevice(gateway.id);
    await this.sleep(100);
    this.getAllData();

  }

  onClickCreate() {
    this.openInputTemplate = true;
  }

  async onClickSave() {

    console.log("klsdjfklsdfj");
    console.log('axaxaxaxax ' + " " + this.name + " " + this.ipv4);

    let gateway = {name: this.name, ipv4: this.ipv4};
    this.gatewayComponent.saveGateway(gateway).subscribe(

      error => console.log('error', error.error),
      error => this.errorMesageGW = error.error,

    );
    if (this.errorMessageGW != '') {
      this.showErrorMsgFading();
    }
    console.log("Click on save method");
    await this.sleep(100);
    this.getAllData();
    this.openInputTemplate = false;

  }

  async showErrorMsgFading() {
    await this.sleep(3000);
    this.errorMesageGW = '';
  }

  @Output() devicesClicked = new EventEmitter();

  onClickDevices(gateway) {
    this.showDevices = true;
    console.log("ID: " + gateway.id);

    this.devicesClicked.emit({value: gateway.id});

    //let deviceList = new DevicesListComponent(new DeviceComponent()));
    // this.data.getAll(gateway.id);
    //  this.devicesListComponent.getAll(gateway.id);
  }


  onClickReturn() {
    this.showDevices = false;
  }

}
