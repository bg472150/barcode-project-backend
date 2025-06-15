package com.barcode.scanapi.controller;

import com.barcode.scanapi.model.Teacher;
import com.barcode.scanapi.model.ScanResponseVO;
import com.barcode.scanapi.service.TeacherSignInService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/teach_api/v1")
public class TeachSignInController {
    private final TeacherSignInService teacherSignInService;

    @Autowired
    public TeachSignInController(TeacherSignInService teacherSignInService) {
        this.teacherSignInService=teacherSignInService;
    }

    @GetMapping("/signin")
    public ScanResponseVO signin(@RequestParam @Valid String barcode) {
        Teacher teacher=teacherSignInService.signin(barcode);
        if(teacher==null) {
            return ScanResponseVO.builder().barcode(barcode).teacherName("Unknown").status("error").build();
        }
        return ScanResponseVO.builder().teacherName(teacher.getFirstName()+" "+teacher.getLastName()).barcode(barcode).status("Signed In").build();
    }
}
