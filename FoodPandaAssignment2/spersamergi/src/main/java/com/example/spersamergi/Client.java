package com.example.spersamergi;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Integer id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;

    public Client(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Client(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
