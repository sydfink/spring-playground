package com.galvanize.demo;


import org.junit.jupiter.api.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class piTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testPiPage() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");

        this.mvc.perform(request).andExpect(content().string("3.141592653589793"));
    }


}
