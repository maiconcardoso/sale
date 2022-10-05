import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from './user.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  // samePassword: string;
  // messageError: boolean;
  user: User;
  errors: string[] = [];

  constructor(private router: Router, private userService: UserService) {
    this.user = new User();
   }

  ngOnInit(): void {
  }

  onSubimit(){
    this.userService.save(this.user).subscribe(response => {
      this.user = response;
      this.router.navigate(['/login'])
    }, errorResponse => {
      this.errors = errorResponse.error.errors;
    })
  }

}
