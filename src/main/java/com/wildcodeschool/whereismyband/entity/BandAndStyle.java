package com.wildcodeschool.whereismyband.entity;

public class BandAndStyle {
    private Long idBand;
    private String name;
    private String bio;
    private int searchType;
    private String postcode;
    private Long idMusician;
    private Long idStyle;

    public BandAndStyle(Long idBand, String name, String bio, int searchType, String postcode, Long idMusician, Long idStyle) {
        this.idBand = idBand;
        this.name = name;
        this.bio = bio;
        this.searchType = searchType;
        this.postcode = postcode;
        this.idMusician = idMusician;
        this.idStyle = idStyle;
    }

    public Long getIdBand() {
        return idBand;
    }

    public void setIdBand(Long idBand) {
        this.idBand = idBand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Long getIdMusician() {
        return idMusician;
    }

    public void setIdMusician(Long idMusician) {
        this.idMusician = idMusician;
    }

    public Long getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(Long idStyle) {
        this.idStyle = idStyle;
    }
}
