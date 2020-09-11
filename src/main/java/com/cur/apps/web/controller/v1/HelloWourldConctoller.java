package com.cur.apps.web.v1.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloWourldConctoller {

    @GetMapping("/tq")
    public String test(String abc){
        return "HELLO";
    }
}
