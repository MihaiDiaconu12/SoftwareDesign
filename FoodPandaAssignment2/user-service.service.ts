import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const API_URL4 = 'http://localhost:8080/api2/set-up';
const API_URL5 = 'http://localhost:8080/api2/checkcredentials';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http:HttpClient) { }

  register(username: string, email: string, password: string): Observable<any> {
    return this.http.post(API_URL4, {username, email, password}, httpOptions);
  }

  
  checkCredentials(data:any):Observable<any>{
    return this.http.post(API_URL5,data,httpOptions);
  }
}
