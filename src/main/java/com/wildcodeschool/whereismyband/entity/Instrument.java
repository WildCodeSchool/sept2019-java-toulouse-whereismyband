package com.wildcodeschool.whereismyband.entity;

public class Instrument {
    private int id_instrument;
    private String name;

    public Instrument(int id_instrument, String name) {
        this.id_instrument = id_instrument;
        this.name = name;
    }

    public int getId_instrument() {
        return id_instrument;
    }

    public String getName() {
        return name;
    }

    public void setId_instrument(int id_instrument) {
        this.id_instrument = id_instrument;
    }

    public void setName(String name) {
        this.name = name;
    }
}