import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const API_URL4 = 'http://localhost:8080/api4/addFood';
const API_URL5 = 'http://localhost:8080/api4/getAllFoods'; 
const API_URL6 = 'http://localhost:8080/api4/filterPrice'; 
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class FoodserviceService {

  constructor(private http:HttpClient) { }
  enterFood(data:any): Observable<any> {
    return this.http.post(API_URL4, data, httpOptions);
  }

  getAllFood(){
    
    return this.http.post(API_URL5,httpOptions);
  }

  getFilteredFood(data:any): Observable<any> {
    return this.http.post(API_URL6,data,httpOptions);
  }
}
