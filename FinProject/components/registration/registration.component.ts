import { Component, OnInit } from '@angular/core';
import {RegistrationService} from 'src/app/service/registration.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {


  constructor(private registrationService: RegistrationService) { }

  errorMessage='';
  isClientLoggedIn=false;
  isRestaurantListHere=false;
  isRestaurantHere=false;

  name?:string;
  email?:string;
  password?:string;

  ngOnInit(): void {
  }

  registerClient():void{
    const data={
      name: this.name,
      email: this.email,
      password: this.password,
      status: "universal",
    }
    this.registrationService.register(data).subscribe(
      {
        
        next: data=>{
          console.log(data);
          this.isClientLoggedIn=true;
        },
        error:err=>{
          console.log(err);
          this.errorMessage=err.error.message;
        }
      }
    )
  }
}
