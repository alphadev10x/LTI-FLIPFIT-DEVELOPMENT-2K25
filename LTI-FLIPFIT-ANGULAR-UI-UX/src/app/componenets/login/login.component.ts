import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, NgForm, Validators } from '@angular/forms';
import { LoginService } from '../../services/login.service';
import { Login } from '../../models/login';
import { Router } from '@angular/router';
import { User } from '../../models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  ngOnInit(): void {
  }

  credentials: Login = { email: "", password: "" };

  loginError = false;

  user!: User;

  // Reference the form from the template
  @ViewChild('loginForm') loginForm!: NgForm;

  constructor(private _httpService: LoginService, private router: Router) {
  }

  onLogin() {
    this.loginError = false; // Reset error message on new attempt

    if (this.loginForm.valid) {
      // Get the clean values from the component properties or form value
      const { email, password } = this.loginForm.value;
      console.log('Login attempt with data:', email, password);

      // Call the service with the data payload (email and password)
      this._httpService.login(this.credentials).subscribe({
        next: (response) => {
          console.log(`Response from user login:`, response);
          // Assuming 'response' contains a token or a success status
          if (response) { // && response.success
            // ✅ TODO: Handle successful login (e.g., store token, navigate)
            console.log("Login Successful!");
            this.getUserDetails(email);
          } else {
            this.loginError = true; // Handle specific API-level failure (e.g., bad credentials)
          }
        },
        error: (err) => {
          console.error('Login API Error:', err);
          this.loginError = true; // Handle network or server errors
        },
        complete: () => {
          console.log('Login request complete.');
        }
      });

    } else {
      // This part runs if HTML5/Angular validation fails before API call
      console.log('Form is invalid according to Angular validation.');
      // You might want to touch controls here to show validation errors
    }
    // This console log now accurately reflects what happens immediately after calling the service
    console.log("After calling service (but before it returns)");
  }

  getUserDetails(email: String) {
    this._httpService.getUserDetails(email).subscribe(res => {
      this.user = res;
      switch (this.user.roleId) {
        case 1:
          localStorage.setItem("userId", `${this.user.userId}`);
          this.router.navigate(['/admin']);
          break
        case 2:
          localStorage.setItem("userId", `${this.user.userId}`);
          this.router.navigate(['/customer']);
          break
        case 3:
          localStorage.setItem("userId", `${this.user.userId}`);
          this.router.navigate(['/owner']);
          break
        default:
          this.router.navigate(["/login"]);
          break
      }
    })
  }

}