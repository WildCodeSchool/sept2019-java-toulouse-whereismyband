package com.wildcodeschool.whereismyband.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConnectedController {
    @PostMapping("/userProfile")
    public String search() {
        return "userProfile";
    }
}