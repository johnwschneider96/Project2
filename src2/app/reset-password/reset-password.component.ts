import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {

  authService: AuthService;

  constructor() { }

  ngOnInit() {
  }

  resetPassword(email: string) {
    this.authService.resetPassword(email);
  }

}
