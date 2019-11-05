package com.wildcodeschool.whereismyband.entity;

public class Musician {

    private int id_musician;
    private String password;
    private String alias;
    private String email;
    private String postcode;
    private String bio;
    private String avatar;
    private String availability;
    private int search_type;

    public Musician(int id_musician, String password, String alias, String email, String postcode, String bio,
                    String avatar, String availability, int search_type) {
        this.id_musician = id_musician;
        this.password = password;
        this.alias = alias;
        this.email = email;
        this.postcode = postcode;
        this.bio = bio;
        this.avatar = avatar;
        this.availability = availability;
        this.search_type = search_type;
    }

    public int getId_musician() {
        return id_musician;
    }

    public void setId_musician(int id_musician) {
        this.id_musician = id_musician;
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

    public int getSearch_type() {
        return search_type;
    }

    public void setSearch_type(int search_type) {
        this.search_type = search_type;
    }

}
