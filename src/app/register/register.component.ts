import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent {

  email: string;
  password: string;
  filename: string;
  firstname: string;
  lastname: string;
  phonenumber: string;

  constructor(private http: HttpClient, private router: Router) { }

  submitNewUser() {
    this.filename = '';
    const theUser = new User(this.email, this.password, this.filename, this.firstname, this.lastname, this.phonenumber);

    this.http.post('http://localhost:9005/P2FB_Application/insertuser', JSON.stringify(theUser)).subscribe(
      data => {
        console.log(data);
        console.log(theUser);
      },
      error => {
        console.log('Error Occured:' + error);
        alert('Regstration failed');
      }
    );
    alert('Registration Successful');
    this.router.navigate(['/login']);
  }

}
