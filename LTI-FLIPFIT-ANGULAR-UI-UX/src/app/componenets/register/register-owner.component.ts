
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RegisterService } from '../../services/register.service';

interface RegisterOwner {
  userId?: number;       // optional if backend generates it
  businessName: string;
  cardNumber: string;
  GSTIN: string;
  PANCard: string;
  isApproved: boolean;   // you may default to false unless admin approves
  firstName: string;
  lastName: string;
}

interface OwnerResponse {
  userId: number;
  businessName: string;
  cardNumber: string;
  GSTIN: string;
  PANCard: string;
  isApproved: boolean;
  firstName: string;
  lastName: string;
  status?: string;
  message?: string;
}

@Component({
  selector: 'app-register-owner',
  templateUrl: './register-owner.component.html',
  // Using singular to match your current component style (though Angular typically uses `styleUrls`)
  styleUrl: './register-owner.component.css'
})
export class RegisterOwnerComponent implements OnInit {
  ngOnInit(): void {}

  // Initial form model
  owner: RegisterOwner = {
    businessName: '',
    cardNumber: '',
    GSTIN: '',
    PANCard: '',
    isApproved: false,
    firstName: '',
    lastName: ''
  };

  registerError = false;

  // Reference the form from the template
  @ViewChild('registerOwnerForm') registerOwnerForm!: NgForm;

  constructor(private _httpService: RegisterService) {}

  onRegisterOwner() {
    this.registerError = false; // Reset error message on new attempt

    if (this.registerOwnerForm.valid) {
      const {
        businessName,
        cardNumber,
        GSTIN,
        PANCard,
        isApproved,
        firstName,
        lastName
      } = this.registerOwnerForm.value;

      console.log(
        'Owner register attempt with data:',
        businessName,
        cardNumber,
        GSTIN,
        PANCard,
        isApproved,
        firstName,
        lastName
      );

      this._httpService.registerOwner(this.owner).subscribe({
        next: (response: OwnerResponse) => {
          console.log('Response from owner Register:', response);

          if (response) {
            console.log('Owner Register Successful! ' + response.firstName);
            // TODO: navigate to success page or show a toast/snackbar
          } else {
            this.registerError = true;
          }
        },
        error: (err) => {
          console.error('Owner Register API Error:', err);
          this.registerError = true;
        },
        complete: () => {
          console.log('Owner Register request complete.');
        }
      });
    } else {
      console.log('Owner form is invalid according to Angular validation.');
      // Optionally mark controls as touched to show validation errors
      Object.values(this.registerOwnerForm.controls).forEach(control =>
        control.markAsTouched()
      );
    }

    console.log('After calling owner service (but before it returns)');
  }
}
