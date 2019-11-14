package com.wildcodeschool.whereismyband.entity;

public class Search {

    private Long idSearch;
    private String postcode;
    private String availability;
    private int searchType;
    private Long idInstrument;
    private int level;
    private Long idStyle;
    private Long idMusician;

    public Search(Long idSearch, String postcode, String availability, int searchType, Long idInstrument, int level, Long idStyle, Long idMusician) {
        this.idSearch = idSearch;
        this.postcode = postcode;
        this.availability = availability;
        this.searchType = searchType;
        this.idInstrument = idInstrument;
        this.level = level;
        this.idStyle = idStyle;
        this.idMusician = idMusician;
    }

    public Long getIdSearch() {
        return idSearch;
    }

    public void setIdSearch(Long idSearch) {
        this.idSearch = idSearch;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public Long getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(Long idStyle) {
        this.idStyle = idStyle;
    }

    public Long getIdMusician() {
        return idMusician;
    }

    public void setIdMusician(Long idMusician) {
        this.idMusician = idMusician;
    }
}
