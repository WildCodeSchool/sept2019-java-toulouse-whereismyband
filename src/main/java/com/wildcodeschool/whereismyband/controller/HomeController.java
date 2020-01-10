package com.wildcodeschool.whereismyband.controller;

import com.wildcodeschool.whereismyband.entity.Result;
import com.wildcodeschool.whereismyband.repository.CheckerRepository;
import com.wildcodeschool.whereismyband.repository.InstrumentRepository;
import com.wildcodeschool.whereismyband.repository.ResultRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class HomeController {

    private InstrumentRepository repository = new InstrumentRepository();
    private ResultRepository resultRepository = new ResultRepository();
    private CheckerRepository checkerRepository = new CheckerRepository();

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/vue-non-connectee")
    public String notLogView(Model model, @RequestParam String postcode) {

        List<Result> results = resultRepository.getResultNotLog(postcode);
        if( results.size() == 0 || !checkerRepository.checkPostcode(postcode)){
            model.addAttribute("erreur",true);
        }
        model.addAttribute("results",results);

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