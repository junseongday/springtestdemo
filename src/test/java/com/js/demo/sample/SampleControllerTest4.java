package com.js.demo.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest4 {

    @MockBean
    SampleService mockService;

    @Autowired
    MockMvc mvc;

    @Test
    public void smapleTest() throws Exception {
        when(mockService.getName()).thenReturn("AAA");

        mvc.perform(get("/hello"))
                .andExpect(content().string("hello AAA"));

    }
}