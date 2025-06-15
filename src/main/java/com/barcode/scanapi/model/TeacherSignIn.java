package com.barcode.scanapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name="scan")
@Entity
@Builder
public class TeacherSignIn {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "teacher_id")
    @NotNull
    private String barCode;


//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getBarCode() {
//        return barCode;
//    }
//
//    public void setBarCode(String barCode) {
//        this.barCode = barCode;
//    }

    @Column(name="date")
    private String date;
}
