package com.example.spersamergi.foodPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodRepo foodRepo;

    public Food addFood(Food food){
        return foodRepo.save(food);
    }

    public List<Food> getAllFoods(){
        return (List<Food>) foodRepo.findAll();
    }
}
