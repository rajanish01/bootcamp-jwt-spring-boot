package com.bootcamp.jwt.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    @GetMapping
    public ResponseEntity sayHi(){
        return ResponseEntity.accepted().body("Hello Rajanish !");
    }

}
