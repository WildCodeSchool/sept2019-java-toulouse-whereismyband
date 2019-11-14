package com.wildcodeschool.whereismyband.entity;

public class MusicianLevelInstrument {

    private Long idMusician;
    private String password;
    private String alias;
    private String email;
    private String postcode;
    private String bio;
    private String avatar;
    private String availability;
    private int searchType;
    private Long idInstrument;
    private Long idSecondInstrument;
    private int level;
    private int secondLevel;

    public MusicianLevelInstrument(Long idMusician, String password, String alias, String email, String postcode, String bio,
                                   String avatar, String availability, int searchType, Long idInstrument, int level) {
        this.idMusician = idMusician;
        this.password = password;
        this.alias = alias;
        this.email = email;
        this.postcode = postcode;
        this.bio = bio;
        this.avatar = avatar;
        this.availability = availability;
        this.searchType = searchType;
        this.idInstrument = idInstrument;
        this.level = level;
    }

    public MusicianLevelInstrument(Long idMusician, String password, String alias, String email, String postcode, String bio,
                                   String avatar, String availability, int searchType, Long idInstrument, int level, Long idSecondInstrument, int secondLevel) {
        this.idMusician = idMusician;
        this.password = password;
        this.alias = alias;
        this.email = email;
        this.postcode = postcode;
        this.bio = bio;
        this.avatar = avatar;
        this.availability = availability;
        this.searchType = searchType;
        this.idInstrument = idInstrument;
        this.level = level;
        this.idSecondInstrument = idSecondInstrument;
        this.secondLevel = secondLevel;
    }

    public Long getIdInstrument() {
        return idInstrument;
    }

    public void setIdInstrument(Long idInstrument) {
        this.idInstrument = idInstrument;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Long getIdSecondInstrument() {
        return idSecondInstrument;
    }

    public void setIdSecondInstrument(Long idSecondInstrument) {
        this.idSecondInstrument = idSecondInstrument;
    }

    public int getSecondLevel() {
        return secondLevel;
    }

    public void setSecondLevel(int secondLevel) {
        this.secondLevel = secondLevel;
    }

    public Long getIdMusician() {
        return idMusician;
    }

    public void setIdMusician(Long idMusician) {
        this.idMusician = idMusician;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }
}