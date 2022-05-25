import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const API_URL4 = 'http://localhost:8080/api8/addOrder';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class OrderserviceService {

  constructor(private http:HttpClient) { }
  enterOrder(data:any):Observable<any>{
    return this.http.post(API_URL4,data,httpOptions);
  }
}
