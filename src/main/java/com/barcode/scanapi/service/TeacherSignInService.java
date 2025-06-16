package com.barcode.scanapi.service;

import com.barcode.scanapi.model.Teacher;
import com.barcode.scanapi.model.Scan;
import com.barcode.scanapi.repository.TeacherRepo;
import com.barcode.scanapi.repository.ScanRepo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class TeacherSignInService {
    private final ScanRepo scanRepo;
    private final TeacherRepo teacherRepo;

    public TeacherSignInService(
            ScanRepo scanRepo,
            TeacherRepo teacherRepo) {
        this.scanRepo = scanRepo;
        this.teacherRepo=teacherRepo;
    }

    @Transactional
    public Teacher signin(String barcode) {
        Instant now=Instant.now();
        String formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault()).format(now);

        boolean alreadySignedIn = scanRepo.findByBarcodeAndDate(barcode, formattedDate) > 0L;
        if(!alreadySignedIn) {
            Scan scan = Scan.builder().barCode(barcode).date(formattedDate).build();
            try {
                scanRepo.save(scan);
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
