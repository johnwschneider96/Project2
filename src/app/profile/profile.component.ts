import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { NavbarService } from '../navbar.service';
import { User } from '../user';
import { HttpClient } from '@angular/common/http';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: User;
  myUserData: any;
  profileUser: User;
  myresponse: any;
  filename = 'filename';
  submitted = false;
  profileForm: FormGroup;

  constructor(
    public authService: AuthService,
    private nav: NavbarService,
    private http: HttpClient,
    private formBuilder: FormBuilder
    ) {
      this.nav.show();
     }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('token'));
    this.getuserstorys(this.user.email);
    this.getuserbyemail(this.user.email);
    console.log(JSON.stringify(this.myUserData));
    // this.profileUser = JSON.parse(JSON.stringify(this.myUserData));
    // console.log(this.profileUser.email);
    // console.log(this.profileUser.email);
   // if (this.user.email === this.profileUser.email) {
   //   localStorage.setItem('token', JSON.stringify(this.profileUser));
   // }
    this.profileForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      phoneNumber: ['', Validators.required]
    });
  }

  async getuserbyemail(email: string) {
    this.http.get('http://localhost:9005/P2FB_Application/' + email + '/userbyemail').subscribe(
      mydata => {
        console.log(mydata);
        this.myUserData = mydata;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

  getuserstorys(email: string) {
    this.http.get('http://localhost:9005/P2FB_Application/' + email + '/userstorys').subscribe(
      data => {
        this.myresponse = data;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

  updateuser(theUser: User) {
    this.http.put('http://localhost:9005/P2FB_Application/updateuser', JSON.stringify(theUser)).subscribe(
      data => {
        alert('User successfully updated');
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

  onSubmit() {
    this.submitted = true;
    // if (this.profileForm.invalid) {
    //  return;
    // }
    const theUser = new User(
      this.user.email,
      this.profileForm.get('password').value,
      this.filename,
      this.profileForm.get('firstName').value,
      this.profileForm.get('lastName').value,
      this.profileForm.get('phoneNumber').value
    );
    this.updateuser(theUser);
  }
}
