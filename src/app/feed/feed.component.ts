import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from '../user';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  user: User;
  constructor(private router: Router, public authService: AuthService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('token'));
  }

  logout(): void {
    alert('logout successful');
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}
