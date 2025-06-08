package com.barcode.scanapi.controller;

import com.barcode.scanapi.model.Teacher;
import com.barcode.scanapi.model.TeacherSignInResponseVO;
import com.barcode.scanapi.service.TeacherSignInService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(value="/teach_api/v1")
public class TeachSignInController {
    private final TeacherSignInService teacherSignInService;

    @Autowired
    public TeachSignInController(TeacherSignInService teacherSignInService) {
        this.teacherSignInService=teacherSignInService;
    }

    @PostMapping("/signin")
    public TeacherSignInResponseVO singin(@RequestParam @Valid String barcode) {
        Teacher teacher=teacherSignInService.signin(barcode);
        if(teacher==null) {
            return TeacherSignInResponseVO.builder().barcode(barcode).teacherName("Unknow").status("error").build();
        }
        return TeacherSignInResponseVO.builder().teacherName(teacher.getFirstName()+" "+teacher.getLastName()).barcode(barcode).status("Singed In").build();
    }
}
