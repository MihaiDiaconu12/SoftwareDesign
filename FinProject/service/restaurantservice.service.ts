import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const API_URL4 = 'http://localhost:8080/api6/addRestaurant';
const API_URL5 = 'http://localhost:8080/api6/getAllRestaurants';
const API_URL6 = 'http://localhost:8080/api6/chooseRestaurant';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class RestaurantserviceService {

  constructor(private http:HttpClient) { }

  enterRestaurant(data:any): Observable<any> {
    return this.http.post(API_URL4, data, httpOptions);
  }
  getAllRestaurants(): Observable<any>{
    return this.http.post(API_URL5,httpOptions);
  }
  chooseRestaurant(data:string):Observable<any>{
    return this.http.post(API_URL6,data,httpOptions);
  }
}
