package com.barcode.scanapi.controller;

import com.barcode.scanapi.model.Teacher;
import com.barcode.scanapi.model.TeacherSignInResponseVO;
import com.barcode.scanapi.service.TeacherSignInService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value="/teach_api/v1")
public class TeachSignInController {
    private final TeacherSignInService teacherSignInService;

    @Autowired
    public TeachSignInController(TeacherSignInService teacherSignInService) {
        this.teacherSignInService=teacherSignInService;
    }

    @GetMapping("/signin")
    public TeacherSignInResponseVO signin(@RequestParam @Valid String barcode) {
        Teacher teacher=teacherSignInService.signin(barcode);
        if(teacher==null) {
            return TeacherSignInResponseVO.builder().barcode(barcode).teacherName("Unknown").status("error").build();
        }
        return TeacherSignInResponseVO.builder().teacherName(teacher.getFirstName()+" "+teacher.getLastName()).barcode(barcode).status("Signed In").build();
    }
}
