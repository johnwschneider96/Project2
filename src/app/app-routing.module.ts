import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { FeedComponent } from './feed/feed.component';
import { AuthGuard } from './auth.guard';
import { ResetPasswordComponent } from './reset-password/reset-password.component';


const routes: Routes = [

  {path: 'profile', component: ProfileComponent, canActivate : [AuthGuard] },
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'feed', component: FeedComponent, canActivate : [AuthGuard]},
  {path: 'reset-password', component: ResetPasswordComponent},
  {path: '**', redirectTo: 'feed' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
