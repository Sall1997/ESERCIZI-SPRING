package com.example.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomController {

    @GetMapping("/random")
    public ResponseEntity<String>isOk(){
        boolean isOk = new Random().nextBoolean();

        if(isOk){
            return ResponseEntity.ok("200 - OK");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 - Incorrect request");
        }
    }
}
