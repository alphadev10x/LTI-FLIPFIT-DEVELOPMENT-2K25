import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', '*');
  httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  login(loginDto: any) {
    return this.httpClient.post(`http://localhost:8086/user/login`, JSON.stringify(loginDto) , { headers: this.headers, responseType: "text"});
  }

  getUserDetails(email: String) {
    return this.httpClient.get<User>(`http://localhost:8086/user/getUserDetailsByEmail/${email}`, { headers: this.headers});
  }

}
