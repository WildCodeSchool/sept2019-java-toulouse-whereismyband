package com.wildcodeschool.whereismyband.entity;

public class MusicianInstrumentLevel {

    private String postCode;
    private String availability;
    private int searchType;
    private int idMainInstrument;
    private int mainInstrumentLevel;
    private int idSecondInstrument;
    private int secondInstrumentLevel;

    public MusicianInstrumentLevel() {
    }

    public MusicianInstrumentLevel(String postCode,
                                   String availability,
                                   int searchType,
                                   int idMainInstrument,
                                   int mainInstrumentLevel) {
        this.postCode = postCode;
        this.availability = availability;
        this.searchType = searchType;
        this.idMainInstrument = idMainInstrument;
        this.mainInstrumentLevel = mainInstrumentLevel;
    }

    public MusicianInstrumentLevel(String postCode,
                                   String availability,
                                   int searchType,
                                   int idMainInstrument,
                                   int mainInstrumentLevel,
                                   int idSecondInstrument,
                                   int secondInstrumentLevel) {
        this.postCode = postCode;
        this.availability = availability;
        this.searchType = searchType;
        this.idMainInstrument = idMainInstrument;
        this.mainInstrumentLevel = mainInstrumentLevel;
        this.idSecondInstrument = idSecondInstrument;
        this.secondInstrumentLevel = secondInstrumentLevel;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
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

    public int getIdMainInstrument() {
        return idMainInstrument;
    }

    public void setIdMainInstrument(int idMainInstrument) {
        this.idMainInstrument = idMainInstrument;
    }

    public int getMainInstrumentLevel() {
        return mainInstrumentLevel;
    }

    public void setMainInstrumentLevel(int mainInstrumentLevel) {
        this.mainInstrumentLevel = mainInstrumentLevel;
    }

    public int getIdSecondInstrument() {
        return idSecondInstrument;
    }

    public void setIdSecondInstrument(int idSecondInstrument) {
        this.idSecondInstrument = idSecondInstrument;
    }

    public int getSecondInstrumentLevel() {
        return secondInstrumentLevel;
    }

    public void setSecondInstrumentLevel(int secondInstrumentLevel) {
        this.secondInstrumentLevel = secondInstrumentLevel;
    }
}