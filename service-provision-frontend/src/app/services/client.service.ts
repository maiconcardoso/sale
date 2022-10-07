import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Client } from '../clients/clients';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  baseUrl: string = environment.URL + "/api/clients";

  constructor( private http: HttpClient ) { }

  save( client: Client ): Observable<Client>{
    const tokenString = localStorage.getItem('access_token');
    //@ts-ignore
    const token = JSON.parse(tokenString);
    const headers = {
      'Authorization' : 'Bearer ' + token.access_token
    }
    return this.http.post<Client>(`${this.baseUrl}`, client, { headers });
  }

  findAll() : Observable<Client[]> {
    const tokenString = localStorage.getItem('access_token');
    //@ts-ignore
    const token = JSON.parse(tokenString);
    const headers = {
      'Authorization' : 'Bearer ' + token.access_token
    }
    return this.http.get<Client[]>(this.baseUrl, { headers });
  }

  findById(id: number) : Observable<Client> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Client>(url);
  }

  update(client: Client) : Observable<Client> {
    const url = `${this.baseUrl}/${client.id}`;
    return this.http.put<Client>(url, client);
  }
  delete(client: Client) : Observable<Client> {
    const url = `${this.baseUrl}/${client.id}`;
    return this.http.delete<Client>(url);
  }
}
