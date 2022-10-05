import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Client } from '../clients/clients';
import { Labor } from '../labor/labor';
import { LaborProvision } from '../labor/labor-list/labor-provision';

@Injectable({
  providedIn: 'root'
})
export class LaborService {

  baseURL: string = environment.URL + "/api/labors"

  constructor(private http: HttpClient) { }

  public save(labor: Labor) : Observable<Labor> {
    return this.http.post<Labor>(`${this.baseURL}`, labor);
  }

  public searchLaborByClientName(name: string, month: number) : Observable<LaborProvision[]> {
    let httpParams = new HttpParams().set('name', name).set('month', month ? month.toString() : '' );
    const url = `${this.baseURL}?${httpParams}`
    console.log(url)
    return this.http.get<LaborProvision[]>(url);
  }
}
