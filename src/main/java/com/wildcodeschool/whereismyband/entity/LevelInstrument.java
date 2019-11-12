package com.wildcodeschool.whereismyband.entity;

public class LevelInstrument {


    private Long idMusician;
    private Long idMnstrument;
    private int level;

    public LevelInstrument(Long idMusician, Long idMnstrument, int level) {
        this.idMusician = idMusician;
        this.idMnstrument = idMnstrument;
        this.level = level;
    }

    public Long getIdMusician() {
        return idMusician;
    }

    public void setIdMusician(Long idMusician) {
        this.idMusician = idMusician;
    }

    public Long getIdMnstrument() {
        return idMnstrument;
    }

    public void setIdMnstrument(Long idMnstrument) {
        this.idMnstrument = idMnstrument;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
