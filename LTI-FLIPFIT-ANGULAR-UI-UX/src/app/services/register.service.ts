import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

interface GymCustomer {
  userId: Number;
  firstName: String;
  lastName: String;
  phoneNumber: String;
  gender: String;
}

interface GymAdmin {
  userId: number;
  firstName: string;
  lastName: string;
  phoneNumber: string;
  roleId: number;
}
 
interface GymOwner {
  userId: number;
  businessName: string;
  cardNumber: string;
  GSTIN: string;
  PANCard: string;
  isApproved: boolean;
  firstName: string;
  lastName: string;
}
 
@Injectable({
  providedIn: 'root'
})
export class RegisterService {
 
 headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', '*');
  httpClient: HttpClient;
 
  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }
 
  register(registerDto: any) {
    return this.httpClient.post<GymCustomer>(`http://localhost:8084/customer/registerCustomer`, JSON.stringify(registerDto) , { headers: this.headers});
  }

    /** ✅ New admin registration with typed response and URL */
  registerAdmin(registerDto: any) {
    return this.httpClient.post<GymAdmin>(`http://localhost:8081/admin/registerAdmin`, JSON.stringify(registerDto), { headers: this.headers });
  }
 
  /** ✅ Owner Registration */
  registerOwner(registerDto: any) {
    return this.httpClient.post<GymOwner>(`http://localhost:8085/owner/registerOwner`, JSON.stringify(registerDto), { headers: this.headers });
  }

}