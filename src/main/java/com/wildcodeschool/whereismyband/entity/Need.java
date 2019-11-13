package com.wildcodeschool.whereismyband.entity;

public class Need {

    private long idNeed;
    private long idInstrument;
    private long idBand;
    private String availability;
    private int level;

    public Need(long idNeed, long idInstrument, long idBand, String availability, int level) {
        this.idNeed = idNeed;
        this.idInstrument = idInstrument;
        this.idBand = idBand;
        this.availability = availability;
        this.level = level;
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
}
