package com.wildcodeschool.whereismyband.entity;

public class LevelInstrument {


    private int idMusician;
    private int idMnstrument;
    private int level;

    public LevelInstrument(int idMusician, int idMnstrument, int level) {
        this.idMusician = idMusician;
        this.idMnstrument = idMnstrument;
        this.level = level;
    }

    public int getIdMusician() {
        return idMusician;
    }

    public void setIdMusician(int idMusician) {
        this.idMusician = idMusician;
    }

    public int getIdMnstrument() {
        return idMnstrument;
    }

    public void setIdMnstrument(int idMnstrument) {
        this.idMnstrument = idMnstrument;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
