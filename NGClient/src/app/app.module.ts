import {BrowserModule} from '@angular/platform-browser';
import {NgModule, Injectable} from '@angular/core';

import {AppComponent} from './app.component';
import {DeviceComponent} from './device/device.component';
import {HttpClientModule} from '@angular/common/http';
import {DevicesListComponent} from './devices-list/devices-list.component';
import {GatewayComponent} from './gateway/gateway.component';
import {GatewaysListComponent} from './gateways-list/gateways-list.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    DeviceComponent,
    DevicesListComponent,
    GatewayComponent,
    GatewaysListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [DeviceComponent, GatewayComponent, DevicesListComponent],
  bootstrap: [AppComponent]
})

export class AppModule {

}
