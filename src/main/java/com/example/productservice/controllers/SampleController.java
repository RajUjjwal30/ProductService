package com.example.productservice.controllers;

import org.springframework.web.bind.annotation.RestController;

//this class will be hosting a set of http APIs
@RestController
public class SampleController {
    public String sayHello(){
        return "Hello EveryOne !";
    }
}
