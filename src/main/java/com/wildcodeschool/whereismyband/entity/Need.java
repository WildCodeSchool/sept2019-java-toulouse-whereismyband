package com.wildcodeschool.whereismyband.entity;

public class Need {

    private Long idNeed;
    private Long idInstrument;
    private Long idBand;
    private String availability;
    private int level;

    public Need(Long idNeed, Long idInstrument, Long idBand, String availability, int level) {
        this.idNeed = idNeed;
        this.idInstrument = idInstrument;
        this.idBand = idBand;
        this.availability = availability;
        this.level = level;
    }

    public Long getIdNeed() {
        return idNeed;
    }

    public void setIdNeed(Long idNeed) {
        this.idNeed = idNeed;
    }

    public Long getIdInstrument() {
        return idInstrument;
    }

    public void setIdInstrument(Long idInstrument) {
        this.idInstrument = idInstrument;
    }

    public Long getIdBand() {
        return idBand;
    }

    public void setIdBand(Long idBand) {
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
