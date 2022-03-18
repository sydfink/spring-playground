package com.galvanize.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello from Spring!";
    }

    @GetMapping("/cats")
    public String getCats(){
        return "All the cats";
    }

    @GetMapping("/math/pi")
    public String getPi(){
        return "3.141592653589793";
    }
}
