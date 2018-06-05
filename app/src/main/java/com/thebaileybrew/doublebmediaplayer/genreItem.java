package com.thebaileybrew.doublebmediaplayer;

public class genreItem {

    private final int id;
    private final String genreName;
    private final int genreIcon;
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
