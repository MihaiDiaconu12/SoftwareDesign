package com.example.spersamergi.restaurantPackage;


import com.example.spersamergi.foodPackage.Food;
import com.example.spersamergi.foodPackage.FoodController;
import com.example.spersamergi.foodPackage.FoodRepo;
import com.example.spersamergi.foodPackage.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequestMapping("/api6")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/addRestaurant")
    public ResponseEntity<?> enterRestaurant(@RequestBody restaurantDTO restaurantDTO){
        Restaurant newRestaurant=new Restaurant(restaurantDTO.restaurantName,restaurantDTO.restaurantPassword,
                Integer.parseInt(restaurantDTO.idFood1),Integer.parseInt(restaurantDTO.idFood2),
                Integer.parseInt(restaurantDTO.idFood3),Integer.parseInt(restaurantDTO.idFood4),
                Integer.parseInt(restaurantDTO.idFood5));
        List<Restaurant> restaurants=restaurantService.getAllRestaurants();

        boolean found=false;
        for(Restaurant i: restaurants){
            if(i.getRestaurantName().equals(newRestaurant.getRestaurantName())){
                found=true;
                break;
            }
        }
        if(found){
            return new ResponseEntity<String>("This is it", HttpStatus.OK);
        }
        restaurantService.addRestaurant(newRestaurant);
        return new ResponseEntity<Restaurant>(newRestaurant,HttpStatus.CREATED);
    }

    @PostMapping("/getAllRestaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        List<Restaurant> restaurants;
        restaurants=restaurantService.getAllRestaurants();
        return new ResponseEntity<List<Restaurant>>(restaurants,HttpStatus.CREATED);
    }


}
