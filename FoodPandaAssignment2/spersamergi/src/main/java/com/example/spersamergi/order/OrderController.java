package com.example.spersamergi.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequestMapping("/api8")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<?> enterOrder(@RequestBody orderDTO orderDTO){
        Order newOrder=new Order(orderDTO.username,Integer.parseInt(orderDTO.idRestaurant),
                Integer.parseInt(orderDTO.idFood1),Integer.parseInt(orderDTO.idFood2),orderDTO.status);
        orderService.addOrder(newOrder);
        return new ResponseEntity<Order>(newOrder, HttpStatus.CREATED);
    }

    @PostMapping("/allOrders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<List<Order>>(orders,HttpStatus.CREATED);
    }
}
