package com.example.spersamergi.foodPackage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends CrudRepository<Food,Integer> {
}
