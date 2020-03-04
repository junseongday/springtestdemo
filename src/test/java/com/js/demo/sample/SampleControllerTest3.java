package com.js.demo.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest3 {

    @Autowired
    WebTestClient client;

    @MockBean
    SampleService service;

    @Test
    public void smapleTest() throws Exception {
        when(service.getName()).thenReturn("AAA");
        client.get().uri("/hello").exchange().expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello AAA");
    }
}