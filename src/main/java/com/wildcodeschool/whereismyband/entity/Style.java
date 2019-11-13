package com.wildcodeschool.whereismyband.entity;

public class Style {

    private Long idStyle;
    private String style;

    public Style(Long idStyle, String style) {
        this.idStyle = idStyle;
        this.style = style;
    }

    public Long getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(Long idStyle) {
        this.idStyle = idStyle;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
