package com.wildcodeschool.whereismyband.controller;

import com.wildcodeschool.whereismyband.repository.InstrumentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private InstrumentRepository repository = new InstrumentRepository();

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/vue-non-connectee")
    public String notLogView() {
        return "notLogView";
    }

    @GetMapping("/inscription")
    public String toSignUp(Model model) {
        model.addAttribute("instruments", repository.findAllInstrument());
        return "signUp";
    }

    @GetMapping("/connexion")
    public String toLogIn() {
        return "login";
    }
}