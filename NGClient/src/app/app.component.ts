import {DevicesListComponent} from './devices-list/devices-list.component';
import {Component, ViewChild} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
 
  template: `<div>
      <app-gateways-list (devicesClicked)="onClickDevice($event)"></app-gateways-list>
      <
    </div>`
})
export class AppComponent {

  @ViewChild(DevicesListComponent) devicesListComponent: DevicesListComponent;

  showGateways = false;
  showDevices = false;

  onClickGateways() {
    this.showGateways = true;
    this.showDevices = false;
  }


  onClickDevice(value: any) {
     console.log("kkkkkkkkkkkkkkkkkkkkkkkkkkk " + this.devicesListComponent + ", " + value);
    this.devicesListComponent.getAll(value);
  }


}