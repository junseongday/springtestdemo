package com.js.demo.sample;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest5 {

    @Rule
    public OutputCaptureRule rule = new OutputCaptureRule();

    @MockBean
    SampleService mockService;

    @Autowired
    MockMvc mvc;

    @Test
    public void smapleTest() throws Exception {
        when(mockService.getName()).thenReturn("AAA");

        mvc.perform(get("/hello"))
                .andExpect(content().string("hello AAA"));

        assertThat(rule.toString())
                .contains("JS")
                .contains("skip");
    }
}