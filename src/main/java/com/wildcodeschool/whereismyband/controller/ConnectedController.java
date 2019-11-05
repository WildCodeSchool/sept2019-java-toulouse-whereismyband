package com.wildcodeschool.whereismyband.controller;

import com.wildcodeschool.whereismyband.entity.Musician;
import com.wildcodeschool.whereismyband.repository.MusicianRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConnectedController {

    private MusicianRepository repository = new MusicianRepository();

    @GetMapping("/profil-utilisateur")
    public String toProfile() {
        return "userProfile";
    }

    @PostMapping("/recherche")
    public String toSearch(Model model,
                           @RequestParam String password,
                           @RequestParam String newpassword,
                           @RequestParam(required = false, defaultValue = "") String alias,
                           @RequestParam String userMail,
                           @RequestParam String postcode,
                           @RequestParam(required = false, defaultValue = "") String bio,
                           @RequestParam(required = false, defaultValue = "") String avatar,
                           @RequestParam(required = false, defaultValue = "1111111") String availability,
                           @RequestParam(required = false, defaultValue = "0")  int searchType,
                           @RequestParam(required = false, defaultValue = "0")  int idSearch
    ) {
        //TODO vérifer password et newpassword
        model.addAttribute("musician", repository.save(password, alias, userMail, postcode, bio, avatar,
                availability, searchType));

        return "search";
    }
}