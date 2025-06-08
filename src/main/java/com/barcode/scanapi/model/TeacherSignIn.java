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
@Table(name="sign_in")
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

    @Column(name="sign_in_date")
    private String date;
}
