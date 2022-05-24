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

    /**
     * This is the method that adds a restaurant to the database. It searches in the database if the restaurant is
     * already there and if not, the new restaurant will be added.
     * @param restaurantDTO it is the structure that contains the strings given as input for the restaurant
     * @return A string if the restaurant is already in the database and a restaurant if it has been successfully added
     */
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

    /**
     * It is exactly what it says. It gets a list of all the restaurants in the database and returns it.
     * @return it returns a list of all the restaurants. Used both by the administrator and the client.
     */
    @PostMapping("/getAllRestaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        List<Restaurant> restaurants;
        restaurants=restaurantService.getAllRestaurants();
        return new ResponseEntity<List<Restaurant>>(restaurants,HttpStatus.CREATED);
    }


}
