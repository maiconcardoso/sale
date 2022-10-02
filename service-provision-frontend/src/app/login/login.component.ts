import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string;
  password: string;
  loginError: boolean;

  constructor(private router: Router) { }

  onSubimit(){
    console.log(`user: ${this.username}, password: ${this.password}`)
  }

  register() {
    this.router.navigate(['/register']);
  }

}
