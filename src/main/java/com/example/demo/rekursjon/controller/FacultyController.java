package com.example.demo.rekursjon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.rekursjon.service.FacultyService.*;

@RestController
public class FacultyController {

    @GetMapping("/faculty")
    public long faculty(int number) {
        return fac(number);
    }
}
