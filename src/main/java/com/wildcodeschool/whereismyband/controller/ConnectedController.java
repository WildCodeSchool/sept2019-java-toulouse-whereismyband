package com.wildcodeschool.whereismyband.controller;

import com.wildcodeschool.whereismyband.entity.LevelInstrument;
import com.wildcodeschool.whereismyband.entity.Musician;
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
        String availability = "1010101";
        //TODO : A récupérer depuis le table musician
        char[] week = availability.toCharArray();
        boolean monday = false;
        if(week[0] == '1'){ monday = true;}
        model.addAttribute("monday", monday);
        boolean tuesday = false;
        if(week[1] == '1'){ tuesday = true;}
        model.addAttribute("tuesday", tuesday);
        boolean wednesday = false;
        if(week[2] == '1'){ wednesday = true;}
        model.addAttribute("wednesday", wednesday);
        boolean thursday = false;
        if(week[3] == '1'){ thursday = true;}
        model.addAttribute("thursday", thursday);
        boolean friday = false;
        if(week[4] == '1'){ friday = true;}
        model.addAttribute("friday", friday);
        boolean saturday = false;
        if(week[5] == '1'){ saturday = true;}
        model.addAttribute("saturday", saturday);
        boolean sunday = false;
        if(week[6] == '1'){ sunday = true;}
        model.addAttribute("sunday", sunday);

        int searchType = 2;
        boolean jam = false;
        boolean group = false;

        if(searchType == 1) {
            jam = true;
        } else if (searchType == 2) {
            group = true;
        }
        else{
            jam=true;
            group = true;
        }
        model.addAttribute("jam", jam);
        model.addAttribute("group", group);

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

        session.setAttribute("session", musician);

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