import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';
import { Router } from '@angular/router';
import { NavbarService } from '../navbar.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthGuard } from '../auth.guard';
// import * as AWS from 'aws-sdk';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  filename: string;

  constructor(
    private http: HttpClient,
    private router: Router,
    public nav: NavbarService,
    private formBuilder: FormBuilder,
    private authGuard: AuthGuard,
    ) {
      if (this.authGuard.isLoggedIn()) {
        this.router.navigate(['/feed']);
      }
  }

  ngOnInit() {
    this.nav.hide();
    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      phoneNumber: ['', Validators.required]
    });
  }

  get f() { return this.registerForm.controls; }

  submitNewUser(theUser: User) {
    this.http.post('http://localhost:9005/P2FB_Application/insertuser', JSON.stringify(theUser)).subscribe(
      data => {
        alert('Registration Successful');
      },
      error => {
        console.log('Error Occured:' + error);
        alert('Regstration failed');
      }
    );
  }

  async uploadFile(event: any) {
    const file = event.target.files[0];
    this.filename = file.name;
    // window.test = event.target;

    const urlResponse = await fetch('http://localhost:9005/P2FB_Application/s3/' + file.name, { method: 'POST', });
    const signedUrl = await urlResponse.text();

    const s3Response = await fetch(signedUrl, { method: 'POST', body: file });
  }

  /*fileEvent(fileInput: any) {
    const AWSService = AWS;
    const region = 'us-east-2';
    const bucketName = 'p2sq-imageurls';
    const IdentityPoolId = '<insert your identity pool id>';
    const file = fileInput.target.files[0];
  // Configures the AWS service and initial authorization
    AWSService.config.update({ region, credentials: new AWSService.CognitoIdentityCredentials({ IdentityPoolId })});

  // adds the S3 service, make sure the api version and bucket are correct
    const s3 = new AWSService.S3({apiVersion: '2006-03-01', params: { Bucket: bucketName}});

  // I store this in a variable for retrieval later
    this.filename = file.name;
    s3.upload({ Key: file.name, Bucket: bucketName, Body: file, ACL: 'public-read'}, function(err: any, data: any) {
     if (err) {
       console.log(err, 'there was an error uploading your file');
     }
   });
  }*/

  async getFile(event: any) {
    const input = (document.getElementById('get-file-input') as HTMLInputElement);

    const urlResponse = await fetch('http://localhost:9005/P2FB_Application/s3/' + input.value, {
      method: 'GET'
    });
    const signedUrl = await urlResponse.text();

    const image = (document.getElementById('file-img') as HTMLInputElement);
    image.src = signedUrl;
  }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    const theUser = new User(
      this.registerForm.get('email').value,
      this.registerForm.get('password').value,
      this.filename,
      this.registerForm.get('firstName').value,
      this.registerForm.get('lastName').value,
      this.registerForm.get('phoneNumber').value
    );
    this.submitNewUser(theUser);
    this.router.navigate(['/login']);
  }

}
