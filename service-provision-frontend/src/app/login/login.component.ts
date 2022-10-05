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
      this.router.navigate(['/home'])
    }, errorResponse => {
      this.errors = errorResponse.error.errors;
    })
  }

  register() {
    this.router.navigate(['/register']);
  }

}
