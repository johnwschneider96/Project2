import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { user } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  email:string;
  password:string;
  img:string;
  firstName:string;
  lastName:string;
  phoneNumber:string;

  API_URL = 'http://localhost:9005/Project2';

  constructor(private http : HttpClient) { }

  ngOnInit() {
  }

  submitNewUser(){
    this.img = "n";
    let new_user = new user(this.email,this.password,this.img,this.firstName,this.lastName,this.phoneNumber);

    this.http.post(this.API_URL+'/insertuser', JSON.stringify(new_user)).subscribe(
      data => {
        console.log(data);
        console.log(new_user);
      },
      error => {
        console.log('Error Occured:' + error);
      }
    );
  }

}
