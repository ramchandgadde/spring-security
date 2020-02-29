package com.myapp.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "Greetings !";
    }

    @RequestMapping("/user")
    public String indexUser() {
        return "Greetings from User !";
    }

    @RequestMapping("/admin")
    public String indexAdmin() {
        return "Greetings from Admin !";
    }


}
