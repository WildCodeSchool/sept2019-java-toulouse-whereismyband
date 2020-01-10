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
    private Long idInstrument2;
    private String instrumentName2;
    private int instrumentLevel2;
    private Long idBand;
    private String bandName;
    private String availability;
    private String bio;
    private Long idStyle;
    private String style;

    public Result(Long idMusician, Long searchId, int searchType, String postCode, Long idInstrument, String instrumentName, int instrumentLevel, Long idInstrument2, String instrumentName2, int instrumentLevel2, Long idBand, String bandName, String availability, String bio, Long idStyle, String style) {
        this.idMusician = idMusician;
        this.searchId = searchId;
        this.searchType = searchType;
        this.postCode = postCode;
        this.idInstrument = idInstrument;
        this.instrumentName = instrumentName;
        this.instrumentLevel = instrumentLevel;
        this.idInstrument2 = idInstrument2;
        this.instrumentName2 = instrumentName2;
        this.instrumentLevel2 = instrumentLevel2;
        this.idBand = idBand;
        this.bandName = bandName;
        this.availability = availability;
        this.bio = bio;
        this.idStyle = idStyle;
        this.style = style;
    }

    public Result(Long idMusician, Long searchId, int searchType, String postCode, Long idInstrument, String instrumentName, int instrumentLevel, Long idBand, String bandName, String availability, String bio, Long idStyle, String style) {
        this.idMusician = idMusician;
        this.searchId = searchId;
        this.searchType = searchType;
        this.postCode = postCode;
        this.idInstrument = idInstrument;
        this.instrumentName = instrumentName;
        this.instrumentLevel = instrumentLevel;
        this.idBand = idBand;
        this.bandName = bandName;
        this.availability = availability;
        this.bio = bio;
        this.idStyle = idStyle;
        this.style = style;
    }

    public Long getIdMusician() {
        return idMusician;
    }

    public void setIdMusician(Long idMusician) {
        this.idMusician = idMusician;
    }

    public Long getSearchId() {
        return searchId;
    }

    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
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

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public int getInstrumentLevel() {
        return instrumentLevel;
    }

    public void setInstrumentLevel(int instrumentLevel) {
        this.instrumentLevel = instrumentLevel;
    }

    public Long getIdInstrument2() {
        return idInstrument2;
    }

    public void setIdInstrument2(Long idInstrument2) {
        this.idInstrument2 = idInstrument2;
    }

    public String getInstrumentName2() {
        return instrumentName2;
    }

    public void setInstrumentName2(String instrumentName2) {
        this.instrumentName2 = instrumentName2;
    }

    public int getInstrumentLevel2() {
        return instrumentLevel2;
    }

    public void setInstrumentLevel2(int instrumentLevel2) {
        this.instrumentLevel2 = instrumentLevel2;
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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Long getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(Long idStyle) {
        this.idStyle = idStyle;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}