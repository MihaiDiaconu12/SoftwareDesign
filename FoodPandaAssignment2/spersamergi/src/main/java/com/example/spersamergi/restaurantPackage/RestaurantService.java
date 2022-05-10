package com.example.spersamergi.restaurantPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;

    public Restaurant addRestaurant(Restaurant restaurant){
        return restaurantRepo.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants(){
        return (List<Restaurant>) restaurantRepo.findAll();
    }
}
