import { Component, OnInit } from '@angular/core';
import { FoodserviceService } from 'src/app/service/foodservice.service';
import { RestaurantserviceService } from 'src/app/service/restaurantservice.service';
import {Food} from 'src/app/models/food.model';
import {PriceDTO} from 'src/app/models/price-dto.model';
import {Restaurant} from 'src/app/models/restaurant.model';
@Component({
  selector: 'app-adminactivities',
  templateUrl: './adminactivities.component.html',
  styleUrls: ['./adminactivities.component.css']
})
export class AdminactivitiesComponent implements OnInit {

  rest: Restaurant={
    restaurantName:'',
    restaurantPassword:'',
    idFood1:'',
    idFood2:'',
    idFood3:'',
    idFood4:'',
    idFood5:'',
  }

  form: Food={
    name:'',
    description:'',
    price:'',
    category:'',
  };

  newdta: PriceDTO={
    price:'',
  };


  dataList:any;
  dataFilteredList:any;

  errorMessage = '';
  isSuccessful = false;
  isListHere=false;
  isFilteredListHere=false;
  isRestaurantAdded=false;
  constructor(private foodService:FoodserviceService,
    private restaurantService:RestaurantserviceService) { }

  ngOnInit(): void {
  }



  onButtonFilter():void{
    this.isFilteredListHere=true;
    
      const dataX={price: this.newdta.price};
      console.log(dataX);
      this.foodService.getFilteredFood(dataX).subscribe(
        data=>{
          console.warn(data);
          this.dataFilteredList=data;
        }
      )
  }

  onButtonFoods():void{
    this.isListHere=true;
    this.foodService.getAllFood().subscribe(
      
      data=>{
      console.warn(data);
      this.dataList=data;
      }
    )
  }

  addRestaurant():void{
    const data ={
      restaurantName: this.rest.restaurantName,
      restaurantPassword: this.rest.restaurantPassword,
      idFood1: this.rest.idFood1,
      idFood2: this.rest.idFood2,
      idFood3: this.rest.idFood3,
      idFood4: this.rest.idFood4,
      idFood5: this.rest.idFood5,
    };
    this.restaurantService.enterRestaurant(data).subscribe({
      next: data=>{
        console.log(data);
        this.isRestaurantAdded=true;
      },
      error:err=>{
        console.log(err);
        this.errorMessage=err.error.message;
        this.isRestaurantAdded=false;
      }
    })
  }

  onSubmit():void{
    console.log("Macar ai ajuns aici");
    const data = {
      name: this.form.name,
      description: this.form.description,
      price: this.form.price,
      category: this.form.category,
    };
    this.foodService.enterFood(data).subscribe({
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
