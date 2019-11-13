package com.wildcodeschool.whereismyband.entity;

public class BandStyle {

    private long idStyle;
    private long idBand;

    public BandStyle(long idStyle, long idBand) {
        this.idStyle = idStyle;
        this.idBand = idBand;
    }

    public long getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(long idStyle) {
        this.idStyle = idStyle;
    }

    public long getIdBand() {
        return idBand;
    }

    public void setIdBand(long idBand) {
        this.idBand = idBand;
    }
}
