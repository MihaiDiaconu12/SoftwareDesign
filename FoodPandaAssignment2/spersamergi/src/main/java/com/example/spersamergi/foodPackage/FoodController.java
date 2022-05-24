package com.example.spersamergi.foodPackage;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequestMapping("/api4")
public class FoodController {
    @Autowired
    FoodService foodService;


    public List<Food> getAllFoodList(){
        List<Food> foods;
        foods=foodService.getAllFoods();
        return foods;
    }

    /**
     * This is the method that registers a food item in the database.
     * @param foodDTO the structure that holds the input that will be later processed into food
     * @return If there is no other food with the same name, an object Food and if not, a String
     */
    @PostMapping("/addFood")
    public ResponseEntity<?> enterFood(@RequestBody foodDTO foodDTO){

        Food newFood = new Food(foodDTO.name,foodDTO.description,Float.parseFloat(foodDTO.price),foodDTO.category);
        List<Food> foods=foodService.getAllFoods();

        boolean found=false;
        for(Food i: foods){
            if(i.getName().equals(newFood.getName())){
                found=true;
                break;
            }
        }
        if(found){
            return new ResponseEntity<String>("This is it", HttpStatus.OK);
        }
        foodService.addFood(newFood);
        return new ResponseEntity<Food>(newFood,HttpStatus.CREATED);
    }

    /**
     * The method that will get all the food in the database
     * @return a list with all the foods
     */
    @PostMapping("/getAllFoods")
    public ResponseEntity<List<Food>> getAllFood(){
        List<Food> foods;
        foods=foodService.getAllFoods();
        return new ResponseEntity<List<Food>>(foods,HttpStatus.CREATED);
    }

    /**
     * It is the method that filters the foods by the maximal price.
     * @param priceDTO the structure that holds the price
     * @return a list with all the foods that pass this filter
     */
    @PostMapping("/filterPrice")
    public ResponseEntity<List<Food>> getFilteredFood(@RequestBody priceDTO priceDTO){
        Float priceComp=Float.parseFloat(priceDTO.price);
        System.out.println(priceComp);
        List<Food> foods;
        foods=foodService.getAllFoods();
        List<Food> foods1 = new ArrayList<>();
        for (Food i: foods) {
            if(i.getPrice()<=priceComp){
                foods1.add(i);
            }
        }
        for (Food i:
             foods1) {
            System.out.println(i.toString());

        }

        return new ResponseEntity<List<Food>>(foods1,HttpStatus.CREATED);
    }
}
