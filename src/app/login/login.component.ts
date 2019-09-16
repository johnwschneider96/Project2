import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  myresponse: any;
  loginForm: FormGroup;
  message: string;
  returnUrl: string;

  constructor(private http: HttpClient, private router: Router, private fb: FormBuilder, public authService: AuthService) {}

  ngOnInit() {
    this.loginForm = this.fb.group ({
      email: ['', Validators.required],
      password: ['', Validators.required]
     });
    this.returnUrl = '/profile';
    this.authService.logout();
  }

  get f() { return this.loginForm.controls; }

  getuserbyemail() {
    this.http.get('http://localhost:9005/P2FB_Application/' + this.f.email.value + '/userbyemail').subscribe(
      data => {
        this.myresponse = data;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    } else {
      this.getuserbyemail();
      if (this.f.email.value === this.myresponse.email && this.f.password.value === this.myresponse.password) {
        alert('Login Successful');
        localStorage.setItem('isLoggedIn', 'true');
        localStorage.setItem('token', this.f.email.value);
        this.router.navigate([this.returnUrl]);
      } else {
        this.message = 'Please check your email and password';
      }
    }
  }
}
