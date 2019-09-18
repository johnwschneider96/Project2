import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'project2';
  currentUser: string;

  constructor(
    private router: Router,
    private authService: AuthService
) {
    this.currentUser = localStorage.getItem('token');
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}
