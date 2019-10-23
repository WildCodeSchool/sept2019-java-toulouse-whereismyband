package com.wildcodeschool.whereismyband.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/notLogView")
    public String notLogView(){
        return "notLogView";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "signUp";
    }


}
