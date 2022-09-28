import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Labor } from '../labor/labor';

@Injectable({
  providedIn: 'root'
})
export class LaborService {

  baseURL: string = environment.URL + "/labors"

  constructor(private http: HttpClient) { }

  public save(labor: Labor) : Observable<Labor> {
    return this.http.post<Labor>(`${this.baseURL}`, labor);
  }
}
