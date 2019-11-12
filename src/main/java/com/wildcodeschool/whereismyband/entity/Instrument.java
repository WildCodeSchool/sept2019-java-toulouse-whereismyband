package com.wildcodeschool.whereismyband.entity;

public class Instrument {
    private Long idInstrument;
    private String name;

    public Instrument(Long idInstrument, String name) {
        this.idInstrument = idInstrument;
        this.name = name;
    }

    public Long getIdInstrument() {
        return idInstrument;
    }

    public String getName() {
        return name;
    }

    public void setIdInstrument(Long idInstrument) {
        this.idInstrument = idInstrument;
    }

    public void setName(String name) {
        this.name = name;
    }
}