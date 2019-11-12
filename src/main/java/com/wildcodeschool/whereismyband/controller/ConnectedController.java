package com.wildcodeschool.whereismyband.controller;

import com.wildcodeschool.whereismyband.entity.*;
import com.wildcodeschool.whereismyband.repository.InstrumentRepository;
import com.wildcodeschool.whereismyband.repository.LevelInstrumentRepository;
import com.wildcodeschool.whereismyband.repository.MusicianRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ConnectedController {

    private MusicianRepository musicianRepository = new MusicianRepository();
    private LevelInstrumentRepository levelInstrumentRepository = new LevelInstrumentRepository();
    private InstrumentRepository repository = new InstrumentRepository();

    @GetMapping("/profil-utilisateur")
    public String toProfile(Model model) {
        model.addAttribute("instruments", repository.findAllInstrument());
        return "userProfile";
    }

    @PostMapping("/creation-session-recherche")
    public String creationSession(HttpSession session,
                                  @RequestParam(required = false) int comefromhere,
                                  @RequestParam(required = false) Long idMusician,
                                  @RequestParam(required = false) String postcode,
                                  @RequestParam(required = false, defaultValue = "") String bio,
                                  @RequestParam String userMail,
                                  @RequestParam String password,
                                  @RequestParam(required = false, defaultValue = "") String avatar,
                                  @RequestParam(required = false) String alias,
                                  @RequestParam(required = false, defaultValue = "false") boolean monday,
                                  @RequestParam(required = false, defaultValue = "false") boolean tuesday,
                                  @RequestParam(required = false, defaultValue = "false") boolean wednesday,
                                  @RequestParam(required = false, defaultValue = "false") boolean thursday,
                                  @RequestParam(required = false, defaultValue = "false") boolean friday,
                                  @RequestParam(required = false, defaultValue = "false") boolean saturday,
                                  @RequestParam(required = false, defaultValue = "false") boolean sunday,
                                  @RequestParam(required = false, defaultValue = "false") boolean jam,
                                  @RequestParam(required = false, defaultValue = "false") boolean band,
                                  @RequestParam(required = false) String availability,
                                  @RequestParam(required = false, defaultValue = "3") int searchType,
                                  @RequestParam(required = false) Long mainInstrument,
                                  @RequestParam(required = false, defaultValue = "0") int mainInstrumentLevel,
                                  @RequestParam(required = false) Long secondInstrument,
                                  @RequestParam(required = false, defaultValue = "0") int secondInstrumentLevel) {

        Musician musician;
        switch (comefromhere) {
            case 1:
                musician = musicianRepository.save(password, userMail, userMail, postcode, bio, avatar, availability, searchType);  //(on vient d'inscription)
                idMusician = musician.getIdMusician();
                LevelInstrument levelInstrument = levelInstrumentRepository.save(idMusician,mainInstrument,mainInstrumentLevel);
                break;
            case 2:
                searchType = formatSearchType(jam, band);
                boolean[] week = {monday, tuesday, wednesday, thursday, friday, saturday, sunday};
                availability = formatAvailability(week);
                musician = musicianRepository.update(idMusician, password, alias, userMail, postcode, bio,
                        avatar, availability, searchType); //(on vient de profil)
                break;
            case 3: //enregistrer dans la derniere recherche (on vient de la recherche)
                break;
            case 4:
                musician = musicianRepository.getMusicianLogIn(userMail, password); //on arrive du login
                idMusician = musician.getIdMusician();
        }
        musician = musicianRepository.getMusicianById(idMusician);
        LevelInstrument levelInstrument = levelInstrumentRepository.getLevelInstrumentByIdMusician(musician.getIdMusician()).get(0);
        MusicianLevelInstrument musicianLevelInstrument = new MusicianLevelInstrument(musician.getIdMusician(), musician.getPassword(), musician.getAlias(), musician.getEmail(), musician.getPostcode(),
                musician.getBio(), musician.getAvatar(), musician.getAvailability(), musician.getSearchType(), levelInstrument.getIdMnstrument(), levelInstrument.getLevel());
        session.setAttribute("musicianLevelInstrument", musicianLevelInstrument);
        //TODO : gerer 2eme instru
        //TODO : constructeur musician_levelInstrument a remplir avec les infos d'avant puis le passer dans une session recherche.
        return "redirect:/recherche";
    }

    @GetMapping("/recherche")
    public String toSearch(Model model, HttpSession session){

        //TODO vérifer password et newpassword

        model.addAttribute("instruments", repository.findAllInstrument());
        return "search";
    }

    /*
    @PostMapping("/redirection-session")
    public String redirectSession(HttpSession session,
                                  @RequestParam String password,
                                  @RequestParam String userMail,
                                  @RequestParam(required = false, defaultValue = "0") String postCode,
                                  @RequestParam(required = false, defaultValue = "0") String availability,
                                  @RequestParam(required = false, defaultValue = "false") boolean monday,
                                  @RequestParam(required = false, defaultValue = "false") boolean tuesday,
                                  @RequestParam(required = false, defaultValue = "false") boolean wednesday,
                                  @RequestParam(required = false, defaultValue = "false") boolean thursday,
                                  @RequestParam(required = false, defaultValue = "false") boolean friday,
                                  @RequestParam(required = false, defaultValue = "false") boolean saturday,
                                  @RequestParam(required = false, defaultValue = "false") boolean sunday,
                                  @RequestParam(required = false, defaultValue = "false") boolean jam,
                                  @RequestParam(required = false, defaultValue = "false") boolean band,
                                  @RequestParam(required = false, defaultValue = "0") int idMainInstrument,
                                  @RequestParam(required = false, defaultValue = "0") int mainInstrumentLevel,
                                  @RequestParam(required = false, defaultValue = "0") int idSecondInstrument,
                                  @RequestParam(required = false, defaultValue = "0") int secondInstrumentLevel,
                                  @RequestParam(required = false, defaultValue = "0") int searchType) {

        Musician musician = (Musician) session.getAttribute("musician");
        MusicianInstrumentLevel userSearch;

        if (postCode.equals("0")) {
            postCode = musician.getPostcode();
        }

        if (availability.equals("0")) {
            boolean[] week = {monday, tuesday, wednesday, thursday, friday, saturday, sunday};
            availability = formatAvailability(week);
        }

        if (searchType == 0) {
            searchType = formatSearchType(jam, band);
        }

        if (idSecondInstrument != 0) {
            userSearch = new MusicianInstrumentLevel(postCode,
                    availability,
                    searchType,
                    idMainInstrument,
                    mainInstrumentLevel,
                    idSecondInstrument,
                    secondInstrumentLevel);
        } else {
            userSearch = new MusicianInstrumentLevel(
                    postCode,
                    availability,
                    searchType,
                    idMainInstrument,
                    mainInstrumentLevel);
        }

        session.setAttribute("sessionSearch", userSearch);

        return "redirect:/resultats";
    }
*/
    private String formatAvailability(boolean[] week) {
        char[] availability = {'0', '0', '0', '0', '0', '0', '0'};
        int i = 0;
        for (boolean day : week) {
            if (day) {
                availability[i] = 1;
            }
            i++;
        }
        return String.valueOf(availability);
    }

    private int formatSearchType(boolean jam, boolean band) {
        int i = 0;
        if (jam) {
            i += 1;
        }
        if (band) {
            i += 2;
        }
        return i;
    }
}