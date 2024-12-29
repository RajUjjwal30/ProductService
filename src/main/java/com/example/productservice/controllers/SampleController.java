package com.example.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this class will be hosting a set of http APIs
@RestController
@RequestMapping("/say")
public class SampleController {

    //something in {} considered as variable not path
    @GetMapping("/hello/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,@PathVariable("times") int times){

        String output = "";
        for(int i = 0; i < times; i++){
            output += "Hello " + name + " " ;
        }
        return output;
    }

    @GetMapping("/bye")
    public String sayBye(){
        return "Bye EveryOne";
    }
}
