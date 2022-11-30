package com.axeuno.moneycounter.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Blabla {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }

    @PostMapping("/hello")
    public String postSMTH() {
        return "You have just posted something!";
    }

}
