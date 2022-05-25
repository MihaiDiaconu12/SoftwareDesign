import { Component, OnInit } from '@angular/core';
import {UserServiceService} from 'src/app/service/user-service.service';
import {Credentials} from 'src/app/models/credentials.model';
import { RestaurantserviceService } from 'src/app/service/restaurantservice.service';
import {Restaurant} from 'src/app/models/restaurant.model';
import {FoodserviceService} from 'src/app/service/foodservice.service';
import {OrderserviceService} from 'src/app/service/orderservice.service';
import {Order} from 'src/app/models/order.model';
import {RegistrationService} from 'src/app/service/registration.service';
@Component({
  selector: 'app-clientpage',
  templateUrl: './clientpage.component.html',
  styleUrls: ['./clientpage.component.css']
})
export class ClientpageComponent implements OnInit {

  name?:string;
  password?:string;

  constructor(private registrationService: RegistrationService) { }

  errorMessage='';

  dataDocumentaries:any;


  isClientLoggedIn=false;

  ngOnInit(): void {
    
  }

  loginClient():void{
    const data={name: this.name,
    password: this.password,};
    console.log(data);
    this.registrationService.loginUser(data).subscribe(
      {
        next: data=>{
          console.log(data);
          this.isClientLoggedIn=true;
          this.dataDocumentaries=data;
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
