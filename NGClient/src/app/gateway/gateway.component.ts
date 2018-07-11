import {Injectable, Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RequestOptions, ResponseOptions} from '@angular/http';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-gateway',
  templateUrl: './gateway.component.html',
  styleUrls: ['./gateway.component.css']
})
export class GatewayComponent implements OnInit {
  [x: string]: any;

  constructor(private http: HttpClient) {
  }
  result = '';
  errorMessage = '';
  ngOnInit() {
  }


  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/gateways/all', {headers: {'Cache-Control': 'no-cache'}});
  }

  deleteDevice(id): void {
    console.log('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ' + id);
    this.http.get('//localhost:8080/gateways/delete?id=' + id, {headers: {'Cache-Control': 'no-cache'}}).subscribe();
  }

  saveGateway(gateway): Observable<any> {

    console.log('saved: ' + gateway.id + "  " + gateway.name);
    return this.http.post('//localhost:8080/gateways/add', gateway);
  }
}

