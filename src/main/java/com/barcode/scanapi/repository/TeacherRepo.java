package com.barcode.scanapi.repository;

import com.barcode.scanapi.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepo extends JpaRepository<Teacher, String> {
}
