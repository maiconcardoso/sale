import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username: string;
  password: string;
  samePassword: string;
  passwordError: boolean;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onSubimit(){
    if (this.password != this.samePassword) {
      this.passwordError = true;
    } else {
      console.log(`user: ${this.username}, password: ${this.password}`)
      this.passwordError = false;
      this.router.navigate(['/login'])
    }
  }

}
