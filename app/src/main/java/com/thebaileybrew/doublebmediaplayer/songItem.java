package com.thebaileybrew.doublebmediaplayer;

public class songItem {

    private final int id;
    private final String artistName;
    private final String songName;
    private final int image;
    private final String genre;
    private final int songResource;

    public songItem(int id, String artistName, String songName, int image, String genre, int songResource) {
        this.id = id;
        this.artistName = artistName;
        this.songName = songName;
        this.image = image;
        this.genre = genre;
        this.songResource = songResource;
    }

    public int getId() {
        return id;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongName() {
        return songName;
    }

    public int getImage() {
        return image;
    }

    public String getGenre() {
        return genre;
    }

    public int getSongPlayable() {
        return songResource;
    }

}
