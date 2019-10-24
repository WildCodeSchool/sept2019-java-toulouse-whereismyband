package com.wildcodeschool.whereismyband.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/notLogView")
    public String notLogView() {
        return "notLogView";
    }

    @GetMapping("/signup")
    public String toSignUp() {
        return "signUp";
    }

    @GetMapping("/login")
    public String toLogIn() {
        return "login";
    }
}