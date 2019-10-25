package com.wildcodeschool.whereismyband.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/vue-non-connectee")
    public String notLogView() {
        return "notLogView";
    }

    @GetMapping("/inscription")
    public String toSignUp() {
        return "signUp";
    }

    @GetMapping("/connexion")
    public String toLogIn() {
        return "login";
    }
}