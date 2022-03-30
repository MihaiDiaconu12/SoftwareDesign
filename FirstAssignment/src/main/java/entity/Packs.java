package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="packs")

public class Packs {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String destination;

    @Column
    private String price;

    @Column
    private String maxpersons;

    @Column
    private String currentpersons;

    @Column
    private String day1;

    @Column
    private String month1;

    @Column
    private String day2;

    @Column
    private String month2;

    public Packs(){}

    public Packs(String id, String name, String destination, String price,
                 String maxpersons, String currentpersons, String day1,
                 String month1, String day2, String month2){
        this.id=id;
        this.name=name;
        this.destination=destination;
        this.price=price;
        this.maxpersons=maxpersons;
        this.currentpersons=currentpersons;
        this.day1=day1;
        this.month1=month1;
        this.day2=day2;
        this.month2=month2;
    }

    @Override
    public String toString() {
        return "Packs{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", destination='" + destination + '\'' +
                ", price='" + price + '\'' +
                ", maxpersons='" + maxpersons + '\'' +
                ", currentpersons='" + currentpersons + '\'' +
                ", day1='" + day1 + '\'' +
                ", month1='" + month1 + '\'' +
                ", day2='" + day2 + '\'' +
                ", month2='" + month2 + '\'' +
                '}';
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDestination() {return destination;}
    public void setDestination(String destination) {this.destination = destination;}
    public String getPrice() {return price;}
    public void setPrice(String price) {this.price = price;}
    public String getMaxpersons() {return maxpersons;}
    public void setMaxpersons(String maxpersons) {this.maxpersons = maxpersons;}
    public String getCurrentpersons() {return currentpersons;}
    public void setCurrentpersons(String currentpersons) {this.currentpersons = currentpersons;}
    public String getDay1() {return day1;}
    public void setDay1(String day1) {this.day1 = day1;}
    public String getMonth1() {return month1;}
    public void setMonth1(String month1) {this.month1 = month1;}
    public String getDay2() {return day2;}
    public void setDay2(String day2) {this.day2 = day2;}
    public String getMonth2() {return month2;}
    public void setMonth2(String month2) {this.month2 = month2;}
}
