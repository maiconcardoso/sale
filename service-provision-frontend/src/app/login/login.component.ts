import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string;
  password: string;
  loginError: boolean;
  errors: string[] = [];

  constructor(private router: Router, private auth: AuthService) { }

  onSubimit(){
    this.auth.login(this.username, this.password).subscribe(response => {
      const access_token = JSON.stringify(response);
      localStorage.setItem('access_token', access_token);
      this.router.navigate(['/home'])
    }, errorResponse => {
      this.errors = errorResponse.error.errors;
    })
  }

  register() {
    this.router.navigate(['/register']);
  }

}
