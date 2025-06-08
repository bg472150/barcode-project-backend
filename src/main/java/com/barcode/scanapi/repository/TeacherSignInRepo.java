package com.barcode.scanapi.repository;


import com.barcode.scanapi.model.TeacherSignIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherSignInRepo extends JpaRepository<TeacherSignIn, Long> {
    @Query(value = "select count(*) from sign_in where teacher_id=? and sing_in_date=?")
    long find(String barcode, String date);
}
