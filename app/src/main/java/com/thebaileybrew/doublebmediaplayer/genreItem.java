package com.thebaileybrew.doublebmediaplayer;

public class genreItem {

    /** ID value for song*/
    private final int id;
    /** string value for genre name*/
    private final String genreName;
    /** integer value for genre button icon*/
    private final int genreIcon;
    /** integer value for genre button background*/
    private final int genreBackground;

    public genreItem(int id, String genreName, int genreIcon, int genreBackground) {
        this.id = id;
        this.genreName = genreName;
        this.genreIcon = genreIcon;
        this.genreBackground = genreBackground;
    }

    public int getId() {
        return id;
    }

    public String getGenreName() {
        return genreName;
    }

    public int getGenreIcon() {
        return genreIcon;
    }

    public int getGenreBackground() {
        return genreBackground;
    }
}
