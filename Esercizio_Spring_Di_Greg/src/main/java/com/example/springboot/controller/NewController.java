package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {

    @GetMapping("/info")
    public ResponseEntity<String> getInfo(){
        return ResponseEntity.ok("info");
    }
}
