package com.wildcodeschool.whereismyband.controller;

import com.wildcodeschool.whereismyband.entity.*;
import com.wildcodeschool.whereismyband.repository.*;
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
    private StyleRepository styleRepository = new StyleRepository();
    private BandRepository bandRepository = new BandRepository();
    private BandStyleRepository bandStyleRepository = new BandStyleRepository();
    private BandAndStyleRepository bandAndStyleRepository = new BandAndStyleRepository();
    private NeedRepository needRepository = new NeedRepository();
    private NeedInstrumentRepository needInstrumentRepository = new NeedInstrumentRepository();
    private CheckerRepository checkerRepository = new CheckerRepository();

    @GetMapping("/profil-utilisateur")
    public String toProfile(Model model, HttpSession session) {

        MusicianLevelInstrument musicianLevelInstrument = (MusicianLevelInstrument) session.getAttribute("musicianLevelInstrument");

        String availability = musicianLevelInstrument.getAvailability();
        this.sendAvaibilityToForm(model, availability);

        int searchType = musicianLevelInstrument.getSearchType();
        this.sendSearchTypeToForm(model, searchType);

        List<LevelInstrument> musicianInstruments = levelInstrumentRepository.getLevelInstrumentByIdMusician(musicianLevelInstrument.getIdMusician());
        boolean twoInstrument = musicianInstruments.size() > 1;

        model.addAttribute("instruments", repository.findAllInstrument());
        model.addAttribute("levels", musicianInstruments);
        model.addAttribute("twoInstrument", twoInstrument);
        return "userProfile";
    }

    @PostMapping("/creation-session-recherche")
    public String creationSession(HttpSession session, Model model,
                                  @RequestParam(required = false) int comefromhere,
                                  @RequestParam(required = false) Long idMusician,
                                  @RequestParam(required = false) String postcode,
                                  @RequestParam(required = false, defaultValue = "") String bio,
                                  @RequestParam String userMail,
                                  @RequestParam(required = false, defaultValue = "") String newpassword,
                                  @RequestParam String password,
                                  @RequestParam(required = false, defaultValue = "") String avatar,
                                  @RequestParam(required = false) String alias,
                                  @RequestParam(required = false, defaultValue = "") String monday,
                                  @RequestParam(required = false, defaultValue = "") String tuesday,
                                  @RequestParam(required = false, defaultValue = "") String wednesday,
                                  @RequestParam(required = false, defaultValue = "") String thursday,
                                  @RequestParam(required = false, defaultValue = "") String friday,
                                  @RequestParam(required = false, defaultValue = "") String saturday,
                                  @RequestParam(required = false, defaultValue = "") String sunday,
                                  @RequestParam(required = false, defaultValue = "") String jam,
                                  @RequestParam(required = false, defaultValue = "") String band,
                                  @RequestParam(required = false, defaultValue = "1111111") String availability,
                                  @RequestParam(required = false, defaultValue = "3") int searchType,
                                  @RequestParam(required = false) Long mainInstrument,
                                  @RequestParam(required = false, defaultValue = "0") int mainInstrumentLevel,
                                  @RequestParam(required = false, defaultValue = "0") Long secondInstrument,
                                  @RequestParam(required = false, defaultValue = "0") int secondInstrumentLevel,
                                  @RequestParam(required = false) Long previousInstrument1,
                                  @RequestParam(required = false, defaultValue = "0") Long previousInstrument2) {

        Musician musician;
        switch (comefromhere) {
            case 1:
                boolean checkPassword = checkerRepository.checkPassword(password, newpassword);
                boolean checkEmail = checkerRepository.checkEmail(userMail);
                boolean checkPostcode = checkerRepository.checkPostcode(postcode);
                if (!checkPassword || !checkEmail || !checkPostcode) {
                    model.addAttribute("checkPassword", checkPassword);
                    model.addAttribute("checkEmail", checkEmail);
                    model.addAttribute("checkPostcode", checkPostcode);
                    model.addAttribute("instruments", repository.findAllInstrument());
                    return "signUp";
                }

                musician = musicianRepository.save(password, userMail, userMail, postcode, bio, avatar, availability, searchType);  //(on vient d'inscription)
                idMusician = musician.getIdMusician();
                LevelInstrument levelInstrument = levelInstrumentRepository.save(idMusician, mainInstrument, mainInstrumentLevel);
                if (secondInstrument != 0) {
                    LevelInstrument levelSecondInstrument = levelInstrumentRepository.save(idMusician, secondInstrument, secondInstrumentLevel);
                }
                break;

            case 2:
                searchType = formatSearchType(jam, band);
                String[] week = {monday, tuesday, wednesday, thursday, friday, saturday, sunday};
                availability = formatAvailability(week);
                musician = musicianRepository.update(idMusician, password, alias, userMail, postcode, bio,
                        avatar, availability, searchType);
                if (secondInstrument == 0 && previousInstrument2 != 0) {
                    levelInstrumentRepository.deleteSecondInstrument(idMusician, previousInstrument2);
                }
                LevelInstrument levelInstrumentUp = levelInstrumentRepository.update(idMusician, mainInstrument,
                        mainInstrumentLevel, previousInstrument1);
                if (secondInstrument != 0) {
                    if (previousInstrument2 == 0) {
                        LevelInstrument levelSecondInstrument = levelInstrumentRepository.save(idMusician, secondInstrument, secondInstrumentLevel);
                    }

                    LevelInstrument levelSecondInstrumentUp = levelInstrumentRepository.update(idMusician, secondInstrument,
                            secondInstrumentLevel, previousInstrument2);
                }
                break;

            case 3: //TODO : enregistrer dans la derniere recherche (on vient de la recherche)
                break;

            case 4:
                musician = musicianRepository.getMusicianLogIn(userMail, password); //on arrive du login
                idMusician = musician.getIdMusician();
        }

        musician = musicianRepository.getMusicianById(idMusician);
        LevelInstrument levelInstrument = levelInstrumentRepository.getLevelInstrumentByIdMusician(musician.getIdMusician()).get(0);

        MusicianLevelInstrument musicianLevelInstrument;
        if (secondInstrument == 0) {

            musicianLevelInstrument = new MusicianLevelInstrument(musician.getIdMusician(), musician.getPassword(), musician.getAlias(), musician.getEmail(), musician.getPostcode(),
                    musician.getBio(), musician.getAvatar(), musician.getAvailability(), musician.getSearchType(), levelInstrument.getIdMnstrument(), levelInstrument.getLevel());
        } else {
            LevelInstrument levelInstrument2 = levelInstrumentRepository.getLevelInstrumentByIdMusician(musician.getIdMusician()).get(1);
            musicianLevelInstrument = new MusicianLevelInstrument(musician.getIdMusician(), musician.getPassword(), musician.getAlias(), musician.getEmail(), musician.getPostcode(),
                    musician.getBio(), musician.getAvatar(), musician.getAvailability(), musician.getSearchType(), levelInstrument.getIdMnstrument(),
                    levelInstrument.getLevel(), levelInstrument2.getIdMnstrument(), levelInstrument2.getLevel());
        }

        session.setAttribute("musicianLevelInstrument", musicianLevelInstrument);
        //TODO : gerer 2eme instru
        //TODO : constructeur musician_levelInstrument a remplir avec les infos d'avant puis le passer dans une session recherche.
        return "redirect:/recherche";
    }

    @GetMapping("/recherche")
    public String toSearch(Model model, HttpSession session) {
        //TODO vérifer password et newpassword
        MusicianLevelInstrument musicianLevelInstrument = (MusicianLevelInstrument) session.getAttribute("musicianLevelInstrument");
        String availability = musicianLevelInstrument.getAvailability();
        this.sendAvaibilityToForm(model, availability);
        int searchType = musicianLevelInstrument.getSearchType();
        this.sendSearchTypeToForm(model, searchType);

        List<LevelInstrument> musicianInstruments = levelInstrumentRepository.getLevelInstrumentByIdMusician(musicianLevelInstrument.getIdMusician());
        List<Result> results = resultRepository.getResult(musicianLevelInstrument.getSearchType(), musicianLevelInstrument.getPostcode(),
                musicianLevelInstrument.getIdInstrument(), musicianLevelInstrument.getLevel(), musicianLevelInstrument.getAvailability());


        boolean twoInstrument = musicianInstruments.size() > 1;

        model.addAttribute("twoInstrument", twoInstrument);
        model.addAttribute("results", results);
        model.addAttribute("levels", levelInstrumentRepository.getLevelInstrumentByIdMusician(musicianLevelInstrument.getIdMusician()));
        model.addAttribute("instruments", repository.findAllInstrument());

        String bandLinHref = "";
        String bandLinkText = "";
        BandAndStyle band = bandAndStyleRepository.getBandsByIdMusician(musicianLevelInstrument.getIdMusician());
        if (band == null) {
            bandLinHref = "/creation-groupe";
            bandLinkText = "Créer mon groupe";
        } else {
            bandLinHref = "/gestion-groupe";
            bandLinkText = "Gérer mes groupes";
        }
        model.addAttribute("bandLinHref", bandLinHref);
        model.addAttribute("bandLinkText", bandLinkText);
        return "search";
    }

    @GetMapping("/creation-groupe")
    public String createBand(Model model, HttpSession session) {
        model.addAttribute("styles", styleRepository.findAllStyle());
        MusicianLevelInstrument musicianLevelInstrument = (MusicianLevelInstrument) session.getAttribute("musicianLevelInstrument");
        return "band";
    }

    @PostMapping("/creation-groupe")
    public String insertBand(@RequestParam(required = false) String name,
                             @RequestParam(required = false) String bio,
                             @RequestParam(required = false) int searchType,
                             @RequestParam(required = false) String postcode,
                             @RequestParam(required = false) Long style,
                             @RequestParam(required = false) Long idMusician) {

        Band band = bandRepository.save(name, bio, searchType, postcode, idMusician);
        BandStyle bandStyle = bandStyleRepository.save(band.getIdBand(), style);
        return "band";
    }

    @GetMapping("/gestion-groupe")
    public String viewBand(HttpSession session, Model model) {

        MusicianLevelInstrument musicianLevelInstrument = (MusicianLevelInstrument) session.getAttribute("musicianLevelInstrument");
        BandAndStyle band = bandAndStyleRepository.getBandsByIdMusician(musicianLevelInstrument.getIdMusician());
        model.addAttribute("band", band);
        model.addAttribute("styles", styleRepository.findAllStyle());
        model.addAttribute("instruments", repository.findAllInstrument());
        model.addAttribute("needs", needInstrumentRepository.getNeedsByIdBands(band.getIdBand()));
        return "need";
    }

    @PostMapping("/gestion-groupe")
    public String updateBand(HttpSession session, Model model,
                             @RequestParam Long idBand,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String bio,
                             @RequestParam(required = false) int searchType,
                             @RequestParam(required = false) String postcode,
                             @RequestParam(required = false) Long style,
                             @RequestParam(required = false) Long idMusician) {

        Band band = bandRepository.update(idBand, name, bio, searchType, postcode, idMusician);
        BandStyle bandStyle = bandStyleRepository.update(band.getIdBand(), style);

        return "redirect:/gestion-groupe";
    }

    @PostMapping("creation-annonce")
    public String createAnnouncement(@RequestParam Long idBand,
                                     @RequestParam Long idInstrument,
                                     @RequestParam int level,
                                     @RequestParam(required = false, defaultValue = "") String monday,
                                     @RequestParam(required = false, defaultValue = "") String tuesday,
                                     @RequestParam(required = false, defaultValue = "") String wednesday,
                                     @RequestParam(required = false, defaultValue = "") String thursday,
                                     @RequestParam(required = false, defaultValue = "") String friday,
                                     @RequestParam(required = false, defaultValue = "") String saturday,
                                     @RequestParam(required = false, defaultValue = "") String sunday) {

        String[] week = {monday, tuesday, wednesday, thursday, friday, saturday, sunday};
        String availability = formatAvailability(week);
        Need need = needRepository.save(idInstrument, idBand, availability, level);
        return "redirect:/gestion-groupe";
    }

    @PostMapping("desactiver-annonce")
    public String createAnnouncement(@RequestParam Long idNeed) {

        Long id = needRepository.desactiveNeed(idNeed);
        return "redirect:/gestion-groupe";
    }

    private String formatAvailability(String[] week) {
        String availability = "";
        for (String day : week) {
            if (day.equals("on")) {
                availability += "1";
            } else {
                availability += "0";
            }
        }
        return availability;
    }

    private int formatSearchType(String jam, String band) {
        int i = 0;
        if (jam.equals("on")) {
            i += 1;
        }
        if (band.equals("on")) {
            i += 2;
        }
        return i;
    }

    private void sendAvaibilityToForm(Model model, String availability) {
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
    }

    private void sendSearchTypeToForm(Model model, int searchType) {

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
    }
}