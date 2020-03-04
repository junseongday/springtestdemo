package com.js.demo.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    Logger logger = LoggerFactory.getLogger(SampleController.class);
    @Autowired
    private SampleService service;

    @GetMapping("/hello")
    public String hello() {
        logger.info("JS");
        System.out.println("skip");
        return "hello " + service.getName();
    }
}
