package com.galvanize.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")

public class SpringMath {

    @GetMapping("/math/calculate")
    //we want to calculate x and y with what operation is passed in the URL
    //ex: /math/calculate?operation=add&x=4&y=6 should render the string 4 + 6 = 10
    //for every parameter requested you need @RequestParam
    //required
    public String calculatedPath(@RequestParam(required = false) String operation, @RequestParam int x, @RequestParam int y){
        //return operation
        switch (operation){
            case "multiply":
                return String.format("%s * %s = %s", x, y, x*y);
            case "subtract":
                return String.format("%s - %s = %s", x, y, x-y);
            case "divide":
                return String.format("%s / %s = %s", x, y, x/y);
            default:
                return String.format("%s + %s = %s", x, y, x+y);
        }



    }
}
