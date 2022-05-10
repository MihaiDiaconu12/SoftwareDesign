package com.example.spersamergi.order;

import com.example.spersamergi.foodPackage.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<Order,Integer> {
}
