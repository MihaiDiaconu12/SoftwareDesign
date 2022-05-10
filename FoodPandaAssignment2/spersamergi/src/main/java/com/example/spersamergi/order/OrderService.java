package com.example.spersamergi.order;

import com.example.spersamergi.foodPackage.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    OrderRepo orderRepo;
    public Order addOrder(Order order){
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders(){
        return (List<Order>) orderRepo.findAll();
    }
}
