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
