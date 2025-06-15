package com.barcode.scanapi.service;

import com.barcode.scanapi.model.Teacher;
import com.barcode.scanapi.model.TeacherSignIn;
import com.barcode.scanapi.repository.TeacherRepo;
import com.barcode.scanapi.repository.TeacherSignInRepo;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class TeacherSignInService {
    private final TeacherSignInRepo teacherSignInRepo;
    private final TeacherRepo teacherRepo;

    public TeacherSignInService(
            TeacherSignInRepo teacherSignInRepo,
            TeacherRepo teacherRepo) {
        this.teacherSignInRepo=teacherSignInRepo;
        this.teacherRepo=teacherRepo;
    }

    @Transactional
    public Teacher signin(String barcode) {
        Instant now=Instant.now();
        String formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault()).format(now);

        boolean alreadySignedIn = teacherSignInRepo.findByBarcodeAndDate(barcode, formattedDate) > 0L;
        if(!alreadySignedIn) {
            TeacherSignIn teacherSignIn=TeacherSignIn.builder().barCode(barcode).date(formattedDate).build();
            try {
                teacherSignInRepo.save(teacherSignIn);
                log.info("signed in teacher with id {}", barcode);
            }
            catch(Exception e) {
                log.error("signin exception", e);
                return null;
            }

        }
        return teacherRepo.getReferenceById(barcode);
    }
}
