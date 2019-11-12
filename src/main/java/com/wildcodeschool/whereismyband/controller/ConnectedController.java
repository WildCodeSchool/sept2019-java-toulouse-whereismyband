package com.wildcodeschool.whereismyband.controller;

import com.wildcodeschool.whereismyband.entity.LevelInstrument;
import com.wildcodeschool.whereismyband.entity.Musician;
import com.wildcodeschool.whereismyband.entity.Result;
import com.wildcodeschool.whereismyband.repository.InstrumentRepository;
import com.wildcodeschool.whereismyband.repository.LevelInstrumentRepository;
import com.wildcodeschool.whereismyband.repository.MusicianRepository;
import com.wildcodeschool.whereismyband.repository.ResultRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ConnectedController {

    private MusicianRepository musicianRepository = new MusicianRepository();
    private LevelInstrumentRepository levelInstrumentRepository = new LevelInstrumentRepository();
    private InstrumentRepository repository = new InstrumentRepository();
    private ResultRepository resultRepository = new ResultRepository();

    @GetMapping("/profil-utilisateur")
    public String toProfile() {
        return "userProfile";
    }

    @PostMapping("/recherche")
    public String toSearch(Model model, HttpSession session,
                           @RequestParam String password,
                           @RequestParam String newpassword,
                           @RequestParam(required = false, defaultValue = "") String alias,
                           @RequestParam String userMail,
                           @RequestParam String postcode,
                           @RequestParam(required = false, defaultValue = "") String bio,
                           @RequestParam(required = false, defaultValue = "") String avatar,
                           @RequestParam(required = false, defaultValue = "1111111") String availability,
                           @RequestParam(required = false, defaultValue = "3") int searchType,
                           @RequestParam int mainInstrument,
                           @RequestParam int mainInstrumentLevel,
                           @RequestParam(required = false, defaultValue = "0") int secondInstrument,
                           @RequestParam(required = false, defaultValue = "0") int secondInstrumentLevel
    ) {
        //TODO vérifer password et newpassword
        Musician musician = musicianRepository.save(password, alias, userMail, postcode, bio, avatar, availability, searchType);
        model.addAttribute("musician", musician);

        session.setAttribute("musician", musician);

        LevelInstrument levelInstrument1 = levelInstrumentRepository.save(musician.getId_musician(), mainInstrument, mainInstrumentLevel);
        model.addAttribute("levelInstrument1", levelInstrument1);

        if (secondInstrument > 0) {
            LevelInstrument levelInstrument2 = levelInstrumentRepository.save(musician.getId_musician(), secondInstrument, secondInstrumentLevel);
            model.addAttribute("levelInstrument2", levelInstrument2);
        }
        return "search";
    }

    @PostMapping("/rechercheviarecherche")
    public String searchBySearch(Model model,
                                 @RequestParam String postcode,
                                 @RequestParam(required = false) String bio,
                                 @RequestParam(required = false) String avatar,
                                 @RequestParam(required = false, defaultValue = "false") boolean monday,
                                 @RequestParam(required = false, defaultValue = "false") boolean tuesday,
                                 @RequestParam(required = false, defaultValue = "false") boolean wednesday,
                                 @RequestParam(required = false, defaultValue = "false") boolean thursday,
                                 @RequestParam(required = false, defaultValue = "false") boolean friday,
                                 @RequestParam(required = false, defaultValue = "false") boolean saturday,
                                 @RequestParam(required = false, defaultValue = "false") boolean sunday,
                                 @RequestParam(required = false, defaultValue = "false") boolean jam,
                                 @RequestParam(required = false, defaultValue = "false") boolean band,
                                 @RequestParam int mainInstrument,
                                 @RequestParam int mainInstrumentLevel,
                                 @RequestParam(required = false, defaultValue = "0") int secondInstrument,
                                 @RequestParam(required = false, defaultValue = "0") int secondInstrumentLevel) {

        model.addAttribute("instruments", repository.findAllInstrument());
        return "search";
    }

    @PostMapping("/recherchevialogin")
    public String searchByLogIn(Model model, HttpSession session,
                                @RequestParam String userMail,
                                @RequestParam String userPassword) {
        Musician musician = musicianRepository.getMusicianLogIn(userMail, userPassword);
        session.setAttribute("musician", musician);
        model.addAttribute("instruments", repository.findAllInstrument());
        if (musician == null) {
            model.addAttribute("errorMessage", true);
            return "login";
        }
        return "search";
    }

    @PostMapping("/rechercheviaprofil")
    public String updateProfil(Model model,
                               @RequestParam int idMusician,
                               @RequestParam String password,
                               @RequestParam String newpassword,
                               @RequestParam(required = false, defaultValue = "") String alias,
                               @RequestParam String userMail,
                               @RequestParam String postcode,
                               @RequestParam(required = false, defaultValue = "") String bio,
                               @RequestParam(required = false, defaultValue = "") String avatar,
                               @RequestParam boolean monday,
                               @RequestParam boolean tuesday,
                               @RequestParam boolean wednesday,
                               @RequestParam boolean thursday,
                               @RequestParam boolean friday,
                               @RequestParam boolean saturday,
                               @RequestParam boolean sunday,
                               @RequestParam boolean jam,
                               @RequestParam boolean band,
                               @RequestParam int mainInstrument,
                               @RequestParam int mainInstrumentLevel,
                               @RequestParam int previousInstrument1,
                               @RequestParam(required = false, defaultValue = "0") int secondInstrument,
                               @RequestParam(required = false, defaultValue = "0") int secondInstrumentLevel,
                               @RequestParam int previousInstrument2) {

        boolean[] week = {monday, tuesday, wednesday, thursday, friday, saturday, sunday};
        String availability = formatAvailability(week);

        int searchType = formatSearchType(jam, band);

        //TODO vérifer password et newpassword
        Musician musician = musicianRepository.update(idMusician, password, alias, userMail, postcode, bio, avatar, availability, searchType);
        model.addAttribute("musician", musician);

        LevelInstrument levelInstrument1 = levelInstrumentRepository.update(musician.getId_musician(), mainInstrument, mainInstrumentLevel, previousInstrument1);
        model.addAttribute("levelInstrument1", levelInstrument1);
        model.addAttribute("instruments", repository.findAllInstrument());

        if (secondInstrument > 0) {
            LevelInstrument levelInstrument2 = levelInstrumentRepository.update(musician.getId_musician(), secondInstrument, secondInstrumentLevel, previousInstrument2);
            model.addAttribute("levelInstrument2", levelInstrument2);
        }

        return "search";
    }

    @GetMapping("/resultat-recherche")
    public String getResult(Model model) {
        List<Result> results = resultRepository.getResult(2, "31000", 209,1, "1100111");
        model.addAttribute("results",results);
        return "search";
    }

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