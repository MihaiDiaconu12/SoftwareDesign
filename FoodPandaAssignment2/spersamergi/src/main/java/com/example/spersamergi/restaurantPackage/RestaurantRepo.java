package com.example.spersamergi.restaurantPackage;

import com.example.spersamergi.foodPackage.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends CrudRepository<Restaurant,Integer> {

}
