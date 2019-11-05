package com.wildcodeschool.whereismyband.entity;

public class LevelInstrument {

    private int id_musician;
    private int id_instrument;
    private int level;

    public LevelInstrument(int id_musician, int id_instrument, int level) {
        this.id_musician = id_musician;
        this.id_instrument = id_instrument;
        this.level = level;
    }

    public int getId_musician() {
        return id_musician;
    }

    public void setId_musician(int id_musician) {
        this.id_musician = id_musician;
    }

    public int getId_instrument() {
        return id_instrument;
    }

    public void setId_instrument(int id_instrument) {
        this.id_instrument = id_instrument;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
