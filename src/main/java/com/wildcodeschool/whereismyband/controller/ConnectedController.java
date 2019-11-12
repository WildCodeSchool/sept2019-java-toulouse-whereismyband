package com.wildcodeschool.whereismyband.controller;

import com.wildcodeschool.whereismyband.entity.LevelInstrument;
import com.wildcodeschool.whereismyband.entity.Musician;
import com.wildcodeschool.whereismyband.entity.MusicianInstrumentLevel;
import com.wildcodeschool.whereismyband.repository.InstrumentRepository;
import com.wildcodeschool.whereismyband.repository.LevelInstrumentRepository;
import com.wildcodeschool.whereismyband.repository.MusicianRepository;
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

    @GetMapping("/profil-utilisateur")
    public String toProfile(Model model, HttpSession session) {
        Musician musician = (Musician) session.getAttribute("musician");
        String availability = musician.getAvailability();
        char[] week = availability.toCharArray();
        boolean monday = false;
        if (week[0] == '1') {
            monday = true;
        }
        model.addAttribute("monday", monday);
        boolean tuesday = false;
        if (week[1] == '1') {
            tuesday = true;
        }
        model.addAttribute("tuesday", tuesday);
        boolean wednesday = false;
        if (week[2] == '1') {
            wednesday = true;
        }
        model.addAttribute("wednesday", wednesday);
        boolean thursday = false;
        if (week[3] == '1') {
            thursday = true;
        }
        model.addAttribute("thursday", thursday);
        boolean friday = false;
        if (week[4] == '1') {
            friday = true;
        }
        model.addAttribute("friday", friday);
        boolean saturday = false;
        if (week[5] == '1') {
            saturday = true;
        }
        model.addAttribute("saturday", saturday);
        boolean sunday = false;
        if (week[6] == '1') {
            sunday = true;
        }
        model.addAttribute("sunday", sunday);

        int searchType = musician.getSearch_type();
        boolean jam = false;
        boolean band = false;

        if (searchType == 1) {
            jam = true;
        } else if (searchType == 2) {
            band = true;
        } else {
            jam = true;
            band = true;
        }
        model.addAttribute("jam", jam);
        model.addAttribute("band", band);

        model.addAttribute("instruments", repository.findAllInstrument());
        model.addAttribute("levels", levelInstrumentRepository.getLevelInstrumentByIdMusician(musician.getId_musician()));

        return "userProfile";
    }

    @GetMapping("/resultats")
    public String showResults(Model model) {
        //TODO intégrer les méthodes des queries SQL
        model.addAttribute("instruments", repository.findAllInstrument());
        return "search";
    }

    @PostMapping("/sign-up")
    public String toSearch(Model model,
                           HttpSession session,
                           @RequestParam String password,
                           @RequestParam String newpassword,
                           @RequestParam(required = false, defaultValue = "alias") String alias,
                           @RequestParam String userMail,
                           @RequestParam String postCode,
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
        Musician musician = musicianRepository.save(password, userMail, userMail, postCode, bio, avatar, availability, searchType);
        Musician musicianSession = musicianRepository.getMusicianLogIn(userMail, password);
        session.setAttribute("musician", musicianSession);
        LevelInstrument levelInstrument1 = levelInstrumentRepository.save(musician.getId_musician(), mainInstrument, mainInstrumentLevel);
        if (secondInstrument > 0) {
            LevelInstrument levelInstrument2 = levelInstrumentRepository.save(musician.getId_musician(), secondInstrument, secondInstrumentLevel);
        }
        initSearchSession(session,musician);
        return "redirect:/resultats";
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
        return "redirect:/redirection-session";
    }

    @PostMapping("/me-connecter")
    public String searchByLogIn(Model model, HttpSession session,
                                @RequestParam String userMail,
                                @RequestParam String userPassword) {
        Musician musician = musicianRepository.getMusicianLogIn(userMail, userPassword);
        session.setAttribute("musician", musician);
        if (musician == null) {
            model.addAttribute("errorMessage", true);
            return "login";
        }

        initSearchSession(session,musician);

        return "redirect:/resultats";
    }

    private void initSearchSession(HttpSession session, Musician musician) {
        List<LevelInstrument> instruments = levelInstrumentRepository.getLevelInstrumentByIdMusician(musician.getId_musician());
        int idMainInstrument = instruments.get(0).getIdMnstrument();
        int mainInstrumentLevel = instruments.get(0).getLevel();
        int idSecondInstrument = -1;
        if (instruments.size() > 1) {
            idSecondInstrument = instruments.get(1).getIdMnstrument();
        }

        MusicianInstrumentLevel userSearch = new MusicianInstrumentLevel(musician.getPostcode(),
                musician.getAvailability(), musician.getSearch_type(), idMainInstrument, mainInstrumentLevel);
        session.setAttribute("sessionSearch", userSearch);
    }


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