import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl: string = environment.URL;
  urlToken: string = this.baseUrl + environment.urlToken;
  clientId: string = environment.clientId;
  clientSecret: string = environment.clientSecret;
  jwtHelper: JwtHelperService = new JwtHelperService();

  constructor(private http: HttpClient) { }

  public logout() {
    localStorage.removeItem('access_token');
  }

  public getUserAuthenticated() {
    const token = this.getToken();
    if (token) {
      const userName = this.jwtHelper.decodeToken(token).user_name;
      return userName;
    }
    return null;
  }

  public getToken() {
    const tokenString = localStorage.getItem('access_token');
    if (tokenString) {
      const token = JSON.parse(tokenString).access_token;
      return token;
    }
    return null;
  }

  public isAuthenticated(): boolean {
    const token = this.getToken();
    if (token) {
      const expired = !(this.jwtHelper.isTokenExpired(token));
      return expired;
    }
    return false;
  }

  public login(username: string, password: string): Observable<any> {
    const params = new HttpParams()
      .set('username', username)
      .set('password', password)
      .set('grant_type', 'password')

    const headers = {
      'Authorization': 'Basic ' + btoa(`${this.clientId}:${this.clientSecret}`),
      'Content-Type': 'application/x-www-form-urlencoded'
    }

    return this.http.post(this.urlToken, params.toString(), { headers } );
  }
}
