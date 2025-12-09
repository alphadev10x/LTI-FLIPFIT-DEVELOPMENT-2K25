import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GymCenter } from '../models/gym-center';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  private baseUrl = 'http://localhost:8083/center';

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', '*');

  constructor(private httpClient: HttpClient) {
  }

  getCenters(): Observable<any[]> {
    return this.httpClient.get<GymCenter[]>(`${this.baseUrl}/getAllCenters`);
  }
  
  getCentersByOwnerId(id: number){
    return this.httpClient.get<GymCenter[]>(`${this.baseUrl}/getCenterByOwnerId/${id}`);
  }

  addCenter(center: any): Observable<any> {
    return this.httpClient.post(`${this.baseUrl}/registerCenter`, center);
  }

  addSlot(slot: any): Observable<any> {
    return this.httpClient.post('http://localhost:8087/scheduler/addSlot', slot);
  }

  getSchedule(): Observable<any> {
    return this.httpClient.get('http://localhost:8087/scheduler/getScheduleDetails');
  }

}