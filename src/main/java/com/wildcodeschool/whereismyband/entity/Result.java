package com.wildcodeschool.whereismyband.entity;

public class Result {

    //TODO gérer le style dans la recherche
    private Long idMusician;
    private Long searchId;
    private int searchType;
    private String postCode;
    private Long idInstrument;
    private String instrumentName;
    private int instrumentLevel;
    private Long idBand;
    private String bandName;
    private String availability;
    private String bio;

    public Result(Long searchId, int searchType, String postCode, Long idInstrument, int instrumentLevel, String availability, Long idMusician) {
        this.searchId = searchId;
        this.searchType = searchType;
        this.postCode = postCode;
        this.idInstrument = idInstrument;
        this.instrumentLevel = instrumentLevel;
        this.availability = availability;
        this.idMusician = idMusician;
    }

    public Result(int searchType, String postCode,
                  Long idInstrument, String instrumentName, int instrumentLevel,
                  Long idBand, String bandName, String availability, String bio) {
        this.searchType = searchType;
        this.postCode = postCode;
        this.idInstrument = idInstrument;
        this.instrumentName = instrumentName;
        this.instrumentLevel = instrumentLevel;
        this.idBand = idBand;
        this.bandName = bandName;
        this.availability = availability;
        this.bio = bio;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public int getInstrumentLevel() {
        return instrumentLevel;
    }

    public Long getIdBand() {
        return idBand;
    }

    public void setIdBand(Long idBand) {
        this.idBand = idBand;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Long getSearchId() {
        return searchId;
    }

    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setInstrumentLevel(int instrumentLevel) {
        this.instrumentLevel = instrumentLevel;
    }

    public Long getIdMusician() {
        return idMusician;
    }

    public void setIdMusician(Long idMusician) {
        this.idMusician = idMusician;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Long getIdInstrument() {
        return idInstrument;
    }

    public void setIdInstrument(Long idInstrument) {
        this.idInstrument = idInstrument;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}