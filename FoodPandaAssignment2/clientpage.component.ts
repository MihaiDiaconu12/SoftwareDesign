import { Component, OnInit } from '@angular/core';
import {UserServiceService} from 'src/app/service/user-service.service';
import {Credentials} from 'src/app/models/credentials.model';
import { RestaurantserviceService } from 'src/app/service/restaurantservice.service';
import {Restaurant} from 'src/app/models/restaurant.model';
import {FoodserviceService} from 'src/app/service/foodservice.service';
import {OrderserviceService} from 'src/app/service/orderservice.service';
import {Order} from 'src/app/models/order.model';
@Component({
  selector: 'app-clientpage',
  templateUrl: './clientpage.component.html',
  styleUrls: ['./clientpage.component.css']
})
export class ClientpageComponent implements OnInit {

  credentials: Credentials={
    username:'',
    password:'',
  }

  ord: Order={
    username:'',
    idRestaurant:'',
    idFood1:'',
    idFood2:'',
    status:"pending",
  }
  constructor(private userService:UserServiceService,
            private restaurantService:RestaurantserviceService,
            private foodService:FoodserviceService,
            private orderService:OrderserviceService) { }

  errorMessage='';
  currentUsername?: string;

  dataRestaurantList:any;
  dataRestaurantFoods:any;
  currentIndex='';

  isClientLoggedIn=false;
  isRestaurantListHere=false;
  isRestaurantHere=false;

  ngOnInit(): void {
    
  }

  placeOrder():void{
      const data={
        username: this.currentUsername,
        idRestaurant: this.currentIndex,
        idFood1: this.ord.idFood1,
        idFood2: this.ord.idFood2,
        status: "pending",
      }

      this.orderService.enterOrder(data).subscribe(
        {
          next: data=>{
            console.log(data);
          },
          error:err=>{
            console.log(err);
            this.errorMessage=err.error.message;
          }
        }
      )
  }

  chooseRestaurant():void{
    this.isRestaurantHere=true;
    console.log(this.currentIndex);
    this.foodService.getAllFood().subscribe(
      data=>{
        this.dataRestaurantFoods=data;
      }
    )
  }

  showAllRestaurants():void{
    this.isRestaurantListHere=true;
    this.restaurantService.getAllRestaurants().subscribe(
      data=>{
        console.warn(data);
        this.dataRestaurantList=data;
      }
    )
  }

  loginClient():void{
    const data={username: this.credentials.username,
    password: this.credentials.password,};
    this.currentUsername= this.credentials.username;
    this.userService.checkCredentials(data).subscribe(
      {
        next: data=>{
          console.log(data);
          console.log(this.currentUsername);
          this.isClientLoggedIn=true;
        },
        error:err=>{
          console.log(err);
          this.isClientLoggedIn=false;
          this.errorMessage=err.error.message;
        }
      }
    )
  }
}
