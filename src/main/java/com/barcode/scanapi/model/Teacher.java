package com.barcode.scanapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher {
    @Column(name = "teacher_id")
    @Id
    @NotNull
    private String id;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public double getPay() {
//        return pay;
//    }
//
//    public void setPay(double pay) {
//        this.pay = pay;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNbr() {
//        return phoneNbr;
//    }
//
//    public void setPhoneNbr(String phoneNbr) {
//        this.phoneNbr = phoneNbr;
//    }

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "hourly_pay")
    private double pay;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name="phone_nbr")
    @Size(min=10, max=10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNbr;

    public Teacher(String id) {
        this.id=id;
    }

//    public Teacher(){}


}
