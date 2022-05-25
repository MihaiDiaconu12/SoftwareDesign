import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const API_URL4 = 'http://localhost:8080/user/add';
const API_URL5 = 'http://localhost:8080/user/getAllUsers';
const API_URL6 = 'http://localhost:8080/user/login';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http:HttpClient) { }

  register(data:any): Observable<any> {
    return this.http.post(API_URL4, data, httpOptions);
  }

  getAllUsers():Observable<any>{
    return this.http.post(API_URL5,httpOptions);
  }
  
  loginUser(data:any):Observable<any>{
    return this.http.post(API_URL6,data,httpOptions);
  }
}
