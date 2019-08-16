package com.captain.cloudmail.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: captain
 * Date: 2019/8/15
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Value("${server.port}")
    String port;

    @GetMapping(value = "/hello")
    public String Hell(){
        return "hell, my port is " + port;
    }
}
