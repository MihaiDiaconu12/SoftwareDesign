package com.example.spersamergi.restaurantPackage;

import javax.persistence.*;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false,updatable = false)
    private Integer id;
    @Column
    private String restaurantName;
    @Column
    private String restaurantPassword;
    @Column
    private Integer idFood1;
    @Column
    private Integer idFood2;
    @Column
    private Integer idFood3;
    @Column
    private Integer idFood4;
    @Column
    private Integer idFood5;

    public Restaurant(String restaurantName, String restaurantPassword, Integer idFood1, Integer idFood2,
                      Integer idFood3, Integer idFood4, Integer idFood5) {
        this.restaurantName = restaurantName;
        this.restaurantPassword = restaurantPassword;
        this.idFood1 = idFood1;
        this.idFood2 = idFood2;
        this.idFood3 = idFood3;
        this.idFood4 = idFood4;
        this.idFood5 = idFood5;
    }

    public Restaurant(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantPassword() {
        return restaurantPassword;
    }

    public void setRestaurantPassword(String restaurantPassword) {
        this.restaurantPassword = restaurantPassword;
    }

    public Integer getIdFood1() {
        return idFood1;
    }

    public void setIdFood1(Integer idFood1) {
        this.idFood1 = idFood1;
    }

    public Integer getIdFood2() {
        return idFood2;
    }

    public void setIdFood2(Integer idFood2) {
        this.idFood2 = idFood2;
    }

    public Integer getIdFood3() {
        return idFood3;
    }

    public void setIdFood3(Integer idFood3) {
        this.idFood3 = idFood3;
    }

    public Integer getIdFood4() {
        return idFood4;
    }

    public void setIdFood4(Integer idFood4) {
        this.idFood4 = idFood4;
    }

    public Integer getIdFood5() {
        return idFood5;
    }

    public void setIdFood5(Integer idFood5) {
        this.idFood5 = idFood5;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantPassword='" + restaurantPassword + '\'' +
                ", idFood1=" + idFood1 +
                ", idFood2=" + idFood2 +
                ", idFood3=" + idFood3 +
                ", idFood4=" + idFood4 +
                ", idFood5=" + idFood5 +
                '}';
    }
}
