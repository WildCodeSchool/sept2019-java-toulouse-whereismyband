package com.wildcodeschool.whereismyband.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConnectedController {
    @PostMapping("/userProfile")
    public String toProfile() {
        return "userProfile";
    }

    @PostMapping("/search")
    public String toSearch() {
        return "search";
    }
}

