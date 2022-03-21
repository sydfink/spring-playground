package com.galvanize.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    //accessing query parameters
    @GetMapping("/cats")
                          //(@RequestParam(value = "sort") String stringName)
    public String getAllCats(@RequestParam String sort){
        return String.format("%s is the sort", sort);
                          //("%s is the sort", stringName)
    }

    @GetMapping("/dogs")
                                            //required parameter
    public String getSortedDogs(@RequestParam String sort){
                                    //return has to be the same as the method parameter
        return String.format("%s is the sort", sort);
    }

    @GetMapping("/cattle")
    //ask for entire query string as a map
    public String getAllQStringFromCattle(@RequestParam Map queryString){
         return queryString.toString();
        //will print out q string on page just like "Hello from Spring!" on localhost:8080
    }

    @GetMapping("/cows")
    //ask for specific pieces of query string as a map
    //created CowSort class to use as a storage for fields
    public String getQStringFromCows(CowSort cows){
        return cows.toString();
        //will print out q string on page just like "Hello from Spring!" on localhost:8080
    }

    //find specific name of horse
    //path variable = variable inside the path
    @GetMapping("/horses/{name}") //referencing the id/name inside the path
                                                //same as inside curly brackets
    public String getHorsesByName(@PathVariable String name){
                                                //name comes from URL path
        return String.format("The name of the horse is %s", name);
    }




}
