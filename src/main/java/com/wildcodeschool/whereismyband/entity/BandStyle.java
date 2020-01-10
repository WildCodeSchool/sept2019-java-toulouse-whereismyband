package com.wildcodeschool.whereismyband.entity;

public class BandStyle {

    private Long idStyle;
    private Long idBand;

    public BandStyle(Long idStyle, Long idBand) {
        this.idStyle = idStyle;
        this.idBand = idBand;
    }

    public Long getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(Long idStyle) {
        this.idStyle = idStyle;
    }

    public Long getIdBand() {
        return idBand;
    }

    public void setIdBand(Long idBand) {
        this.idBand = idBand;
    }
}
