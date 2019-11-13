package com.wildcodeschool.whereismyband.entity;

public class NeedInstrument {

    private Long idNeed;
    private Long idInstrument;
    private Long idBand;
    private String availability;
    private int level;
    private String name;

    public NeedInstrument(Long idNeed, Long idInstrument, Long idBand, String availability, int level, String name) {
        this.idNeed = idNeed;
        this.idInstrument = idInstrument;
        this.idBand = idBand;
        this.availability = availability;
        this.level = level;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
