package com.barcode.scanapi.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;


public class TeacherTest {
    private Teacher teacher=new Teacher("1");

    @Test
    public void returnSuccess_whenGetterReturnMatchSeter() {
        teacher.getId();
        teacher.setFirstName("a");
        Assertions.assertEquals(teacher.getFirstName(), "a");
        teacher.setPhoneNbr("123");
    }
}
