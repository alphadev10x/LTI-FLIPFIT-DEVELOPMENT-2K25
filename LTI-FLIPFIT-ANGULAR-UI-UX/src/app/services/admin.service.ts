import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GymCenter } from '../models/gym-center';
import { GymOwner } from '../models/gym-owner';
import { response } from 'express';



@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = 'http://localhost:8081/admin';

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', '*');

  constructor(private httpClient: HttpClient) {
  }

  getPendingOwners(): Observable<any[]> {
    return this.httpClient.get<GymOwner[]>(`${this.baseUrl}/viewPendingOwnerRequests`);
  }

  getPendingCenters(): Observable<any[]> {
    return this.httpClient.get<GymCenter[]>(`${this.baseUrl}/viewPendingCenterRequests`);
  }

  approveGymCenter(id: number) {
    return this.httpClient.put(`${this.baseUrl}/approveGymCenter/${id}`, null, { headers: this.headers, responseType:"text" })
  }

  approveGymOwner(id: number) {
    return this.httpClient.put(`${this.baseUrl}/approveGymOwner/${id}`, null, { headers: this.headers, responseType:"text" })
  }

  getCenters(): Observable<any[]> {
    return this.httpClient.get<GymCenter[]>(`http://localhost:8083/center/getAllCenters`);
  }

  getOwners(): Observable<any[]> {
    return this.httpClient.get<GymCenter[]>(`http://localhost:8085/owner/getAllGymOwners`);
  }
}
