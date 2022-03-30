package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class Users {
    @Id
    private String id;

    @Column (unique=true, nullable=false)
    private String username;

    @Column (unique=true, nullable=false)
    private String email;

    @Column
    private String password;

    @Column
    private String vacation1;

    @Column
    private String vacation2;

    @Column
    private String vacation3;

    public Users(){}

    public Users(String id, String username, String email, String password,
                 String vacation1, String vacation2, String vacation3){
        this.id = id;
        this.username=username;
        this.email=email;
        this.password=password;
        this.vacation1=vacation1;
        this.vacation2=vacation2;
        this.vacation3=vacation3;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", vacation1='" + vacation1 + '\'' +
                ", vacation2='" + vacation2 + '\'' +
                ", vacation3='" + vacation3 + '\'' +
                '}';
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getVacation1() {return vacation1;}
    public void setVacation1(String vacation1) {this.vacation1 = vacation1;}
    public String getVacation2() {return vacation2;}
    public void setVacation2(String vacation2) {this.vacation2 = vacation2;}
    public String getVacation3() {return vacation3;}
    public void setVacation3(String vacation3) {this.vacation3 = vacation3;}
}
