import { Injectable } from '@angular/core';
import * as firebase from 'firebase';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  logout(): void {
    localStorage.setItem('isLoggedIn', 'false');
    localStorage.removeItem('token');
  }

  async resetPassword(email: string) {
    const auth = firebase.auth();
    // auth.confirmPasswordReset('1234', 'password');
    return auth.sendPasswordResetEmail(email).then(() => console.log('email sent')).catch((error: any) => console.log(error));
  }
}
