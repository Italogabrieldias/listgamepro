package com.flametec.listgamepro.projections;

public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getgameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
