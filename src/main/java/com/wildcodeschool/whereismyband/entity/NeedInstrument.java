package com.wildcodeschool.whereismyband.entity;

public class NeedInstrument {

    private long idNeed;
    private long idInstrument;
    private long idBand;
    private String availability;
    private int level;
    private String name;

    public NeedInstrument(long idNeed, long idInstrument, long idBand, String availability, int level, String name) {
        this.idNeed = idNeed;
        this.idInstrument = idInstrument;
        this.idBand = idBand;
        this.availability = availability;
        this.level = level;
        this.name = name;
    }

    public long getIdNeed() {
        return idNeed;
    }

    public void setIdNeed(long idNeed) {
        this.idNeed = idNeed;
    }

    public long getIdInstrument() {
        return idInstrument;
    }

    public void setIdInstrument(long idInstrument) {
        this.idInstrument = idInstrument;
    }

    public long getIdBand() {
        return idBand;
    }

    public void setIdBand(long idBand) {
        this.idBand = idBand;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
