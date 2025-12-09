import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GymCenter } from '../models/gym-center';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', '*');
  httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  getCustomer(id: number) {
    return this.httpClient.get(`http://localhost:8084/customer/getCustomer/${id}`, { headers: this.headers });
  }

  getBookings(id: any) {
    let userid!: number;
    userid = Number(id);
    return this.httpClient.get(`http://localhost:8088/booking/bookingsByUserId/${userid}`, { headers: this.headers });
  }

  bookSlot(bookingDto: any) {
    return this.httpClient.post(`http://localhost:8088/booking/bookSlot`, JSON.stringify(bookingDto), { headers: this.headers })
  }
  getCenters(): Observable<any[]> {
    return this.httpClient.get<GymCenter[]>(`http://localhost:8083/center/getAllCenters`);
  }

  getSlotsByCenterId(id: any) {
    return this.httpClient.get<any[]>(`http://localhost:8087/scheduler/getSlotsByCenterId/${id}`, { headers: this.headers });
  }
}
