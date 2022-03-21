package com.galvanize.demo;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class) //dictate which controller you are testing

public class helloControllerTest {

    @Autowired //does = new mvc for you
    MockMvc mvc; //create initialized variable without creating new SpringBoot

    @Test
    public void testPiPage() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");

        this.mvc.perform(request)
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void testCatPage() throws Exception{
        RequestBuilder reqCats = MockMvcRequestBuilders.get("/cats");

        this.mvc.perform(reqCats)
                .andExpect(content().string("All the cats"));
    }

    @Test
    public void helloTest() throws Exception{
        RequestBuilder reqHello = MockMvcRequestBuilders.get("/");

        this.mvc.perform(reqHello)
                .andExpect(content().string("Hello from Spring!"));
    }

    //accessing query string test
    @Test                           //tells java compiler that its possible to see an exception and to move on
    void getCatsReturnsAllTheCats() throws Exception{
        //send the request
        this.mvc.perform(get("/cats"))
                //see what is returned
                .andExpect(status().isOk())
                .andExpect(content().string("All the cats"));
    }

    @Test
    void getDogsAllowsSortByName() throws Exception{
        //request sent
        this.mvc.perform(get("/dogs?sort=name"))
                //test assumptions
                .andExpect(status().isOk())
                //the return type is a string hence .string lowercase "s"
                .andExpect(content().string("name is the sort"));
    }

}
