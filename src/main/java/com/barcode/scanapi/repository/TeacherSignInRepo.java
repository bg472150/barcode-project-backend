package com.barcode.scanapi.repository;


import com.barcode.scanapi.model.TeacherSignIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TeacherSignInRepo extends JpaRepository<TeacherSignIn, Integer> {
//    @Query("select ts from sign_in ts where ts.barCode=:barcode and ts.date=:date")
//    List<TeacherSignIn> findbyBarcodeAndDate(@Param("barcode") String barcode, @Param("date") String date);
@Query("select count(u) from TeacherSignIn u where u.barCode = ?1 and u.date=?2")
long findByBarcodeAndDate(String barcode, String date);
}
