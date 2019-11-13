package com.wildcodeschool.whereismyband.entity;

public class Style {

    private long idStyle;
    private String style;

    public Style(long id_style, String style) {
        this.idStyle = id_style;
        this.style = style;
    }

    public long getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
