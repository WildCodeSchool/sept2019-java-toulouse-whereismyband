package com.wildcodeschool.whereismyband.entity;

public class Result {

    //TODO gérer le style dans la recherche
    private long idMusician;
    private long searchId;
    private int searchType;
    private String postCode;
    private long idInstrument;
    private String instrumentName;
    private int instrumentLevel;
    private long idBand;
    private String bandName;
    private String availability;
    private String bio;

    public Result(long searchId, int searchType, String postCode, long idInstrument, int instrumentLevel, String availability, long idMusician) {
        this.searchId = searchId;
        this.searchType = searchType;
        this.postCode = postCode;
        this.idInstrument = idInstrument;
        this.instrumentLevel = instrumentLevel;
        this.availability = availability;
        this.idMusician = idMusician;
    }

    public Result(int searchType, String postCode,
                  long idInstrument, String instrumentName, int instrumentLevel,
                  long idBand, String bandName, String availability, String bio) {
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

    public long getIdBand() {
        return idBand;
    }

    public void setIdBand(long idBand) {
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

    public long getSearchId() {
        return searchId;
    }

    public void setSearchId(long searchId) {
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

    public long getIdMusician() {
        return idMusician;
    }

    public void setIdMusician(long idMusician) {
        this.idMusician = idMusician;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public long getIdInstrument() {
        return idInstrument;
    }

    public void setIdInstrument(long idInstrument) {
        this.idInstrument = idInstrument;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}