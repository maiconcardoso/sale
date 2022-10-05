import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../register/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseURL: string = environment.URL + "/users"

  constructor(private http: HttpClient) { }

  public save(user: User): Observable<User> {
    return this.http.post<User>(this.baseURL, user);
  }
}
