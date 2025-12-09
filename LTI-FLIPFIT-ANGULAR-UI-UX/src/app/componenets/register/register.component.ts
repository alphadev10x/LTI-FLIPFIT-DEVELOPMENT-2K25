import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RegisterService } from '../../services/register.service';

interface Register {
  email: String;
  password: String;
  firstName: String;
  lastName: String;
  phoneNumber: String;
  gender: String;
  role: String;
}

interface RegisterOwner {
  userId?: number;       // optional if backend generates it
  businessName: string;
  cardNumber: string;
  gstin: string;
  pancard: string;
  isApproved: boolean;   // you may default to false unless admin approves
  firstName: string;
  lastName: string;
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {
  ngOnInit(): void {
  }

  register: Register = {
    email: "",
    password: "",
    firstName: "",
    lastName: "",
    phoneNumber: "",
    gender: "",
    role: "",
  };

  owner: RegisterOwner = {
    businessName: '',
    cardNumber: '',
    gstin: '',
    pancard: '',
    isApproved: false,
    firstName: '',
    lastName: ''
  };

  registerError = false;

  // Reference the form from the template
  @ViewChild('registerForm') registerForm!: NgForm;

  constructor(private _httpService: RegisterService) {
  }

  onRegister() {
    this.registerError = false; // Reset error message on new attempt

    if (this.registerForm.valid) {
      console.log(this.registerForm.value);
      // Get the clean values from the component properties or form value
      if(this.registerForm.value.role === "Owner") {
        this._httpService.registerOwner(this.registerForm.value).subscribe({
          next: (res) => {
            console.log(`Response from customer Register: ${res}`);
            // Assuming 'response' contains a token or a success status
            if (res) { // && response.success
              console.log("Register Successful!" + res.firstName);
            } else {
              this.registerError = true; // Handle specific API-level failure (e.g., bad credentials)
            }
          },
          error: (err) => {
            console.error('Register API Error:', err);
            this.registerError = true; // Handle network or server errors
          },
          complete: () => {
            console.log('Register request complete.');
          }
        }); 
      } else if(this.registerForm.value.role === "Customer") {
        this._httpService.register(this.registerForm.value).subscribe({
          next: (res) => {
          console.log(`Response from customer Register: ${res}`);
          // Assuming 'response' contains a token or a success status
          if (res) { // && response.success
            console.log("Register Successful!" + res.firstName);
          } else {
            this.registerError = true; // Handle specific API-level failure (e.g., bad credentials)
          }
        },
        error: (err) => {
            console.error('Register API Error:', err);
            this.registerError = true; // Handle network or server errors
          },
          complete: () => {
            console.log('Register request complete.');
          }
        });
      } else if(this.registerForm.value.role === "Admin"){
        this._httpService.registerAdmin(this.registerForm.value).subscribe({
          next: (res) => {
          console.log(`Response from customer Register: ${res}`);
          // Assuming 'response' contains a token or a success status
          if (res) { // && response.success
            console.log("Register Successful!" + res.firstName);
          } else {
            this.registerError = true; // Handle specific API-level failure (e.g., bad credentials)
          }
        },
        error: (err) => {
            console.error('Register API Error:', err);
            this.registerError = true; // Handle network or server errors
          },
          complete: () => {
            console.log('Register request complete.');
          }
        });
      }
    }
  }
}