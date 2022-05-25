import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const API_URL4 = 'http://localhost:8080/documentary/add';
const API_URL5 = 'http://localhost:8080/documentary/getAllDocumentaries';
const API_URL6 = 'http://localhost:8080/documentary/updateDoc';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class DocumentaryService {

  constructor(private http:HttpClient) { }

  addDocumentary(data:any): Observable<any> {
    return this.http.post(API_URL4, data, httpOptions);
  }

  getAllDocumentaries():Observable<any>{
    return this.http.post(API_URL5,httpOptions);
  }

  updateDocumentary(data:any):Observable<any>{
    return this.http.post(API_URL6,data,httpOptions);
  }
}
