package com.agarwood.voc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("/hello")
    public String hello(String msg) {
        return "Hello,agarwood-voc-service!" + msg;
    }
}
