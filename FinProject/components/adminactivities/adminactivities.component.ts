import { Component, OnInit } from '@angular/core';
import { FoodserviceService } from 'src/app/service/foodservice.service';
import { RestaurantserviceService } from 'src/app/service/restaurantservice.service';
import {Food} from 'src/app/models/food.model';
import {PriceDTO} from 'src/app/models/price-dto.model';
import {Restaurant} from 'src/app/models/restaurant.model';
import {DocumentaryService} from 'src/app/service/documentary.service';
import {RegistrationService} from 'src/app/service/registration.service';
@Component({
  selector: 'app-adminactivities',
  templateUrl: './adminactivities.component.html',
  styleUrls: ['./adminactivities.component.css']
})
export class AdminactivitiesComponent implements OnInit {

  


  dataList:any;
  dataUsers:any; 

  name?:string;
  url?:string;
  description?:string;
  category?:string;
  status?:string;

  idDoc?:string;

  errorMessage = '';
  isSuccessful = false;
  isListHere=false;
  areUsersHere=false;
  
  constructor(private documentaryService:DocumentaryService,
    private registrationService:RegistrationService) { }

  ngOnInit(): void {
  }

  onButtonUsers():void{
    this.areUsersHere=true;
    this.registrationService.getAllUsers().subscribe(
      data=>{
        console.log("Macar ai ajuns aici");
        console.warn(data);
        this.dataUsers=data;}
    )
  }

  setDocumentaryUniversal():void{
    const data={
      idDoc: this.idDoc,
    }
    console.log(data);
    this.documentaryService.updateDocumentary(data).subscribe(
      data=>{
        console.log("Macar ai ajuns aici");
        console.warn(data);
        }
    )
  }

  onButtonDocumentaries():void{
    
    this.isListHere=true;
    this.documentaryService.getAllDocumentaries().subscribe(
      
      data=>{
      console.log("Macar ai ajuns aici");
      console.warn(data);
      this.dataList=data;
      }
    )
  }



  onSubmit():void{
    
    const data = {
      name: this.name,
      url: this.url,
      description: this.description,
      category: this.category,
      status: this.status,
    };
    this.documentaryService.addDocumentary(data).subscribe({
      next: data=>{
        console.log(data);
        this.isSuccessful=true;
      },
      error:err=>{
        console.log(err);
        this.errorMessage = err.error.message;
        this.isSuccessful=false;
      }
    });
  }

}
