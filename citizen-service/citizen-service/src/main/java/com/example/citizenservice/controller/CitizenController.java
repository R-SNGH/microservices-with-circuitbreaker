package com.example.citizenservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @RequestMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }



}
