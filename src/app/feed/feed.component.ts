import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from '../user';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  user: User;
  currentUser: boolean;
  constructor(private router: Router, public authService: AuthService, private nav: NavbarService) {
    this.nav.show();
  }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('token'));
  }

  logout(): void {
    alert('logout successful');
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}
