package com.wildcodeschool.whereismyband.entity;

public class BandAndStyle {
    private long idBand;
    private String name;
    private String bio;
    private int searchType;
    private String postcode;
    private long idMusician;
    private long idStyle;

    public BandAndStyle(long idBand, String name, String bio, int searchType, String postcode, long idMusician, long idStyle) {
        this.idBand = idBand;
        this.name = name;
        this.bio = bio;
        this.searchType = searchType;
        this.postcode = postcode;
        this.idMusician = idMusician;
        this.idStyle = idStyle;
    }

    public long getIdBand() {
        return idBand;
    }

    public void setIdBand(long idBand) {
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

    public long getIdMusician() {
        return idMusician;
    }

    public void setIdMusician(long idMusician) {
        this.idMusician = idMusician;
    }

    public long getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(long idStyle) {
        this.idStyle = idStyle;
    }
}
