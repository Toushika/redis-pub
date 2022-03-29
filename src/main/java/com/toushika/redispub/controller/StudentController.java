package com.toushika.redispub.controller;

import com.toushika.redispub.dto.Student;
import com.toushika.redispub.service.StudentProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentProducer studentProducer;

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody Student student) {
        System.out.println("student = " + student);
        studentProducer.sendMessage(student);
        return new ResponseEntity<>("Message sent successfully", HttpStatus.OK);
    }
}

