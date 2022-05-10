package com.example.spersamergi.order;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false,updatable=false)
    private Integer id;
    @Column
    private String name;
    @Column
    private String status;
    @Column
    private Integer restaurant;
    @Column
    private Integer food1;
    @Column
    private Integer food2;



    public Order(String username, Integer restaurant, Integer food1, Integer food2, String status) {
        this.name = username;
        this.restaurant = restaurant;
        this.food1 = food1;
        this.food2 = food2;
        this.status = status;
    }

    public Order(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public Integer getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Integer restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getFood1() {
        return food1;
    }

    public void setFood1(Integer food1) {
        this.food1 = food1;
    }

    public Integer getFood2() {
        return food2;
    }

    public void setFood2(Integer food2) {
        this.food2 = food2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", restaurant=" + restaurant +
                ", food1=" + food1 +
                ", food2=" + food2 +
                ", status='" + status + '\'' +
                '}';
    }
}
