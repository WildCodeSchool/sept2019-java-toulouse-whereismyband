package com.wildcodeschool.whereismyband.entity;

public class Musician {

    private Long idMusician;
    private String password;
    private String alias;
    private String email;
    private String postcode;
    private String bio;
    private String avatar;
    private String availability;
    private int searchType;

    public Musician(Long idMusician, String password, String alias, String email, String postcode, String bio,
                    String avatar, String availability, int searchType) {
        this.idMusician = idMusician;
        this.password = password;
        this.alias = alias;
        this.email = email;
        this.postcode = postcode;
        this.bio = bio;
        this.avatar = avatar;
        this.availability = availability;
        this.searchType = searchType;
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