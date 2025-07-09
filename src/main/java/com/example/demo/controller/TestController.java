package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping; // if using @GetMapping


@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/demo")
    public String demo() {
        return "Hello Demo";
    }
}