package com.thebaileybrew.doublebmediaplayer;

public class songItem {
    /** ID value for song*/
    private final int id;
    /** String value for Artist*/
    private final String artistName;
    /** String value for Song*/
    private final String songName;
    /** Integer value for Artist image*/
    private final int image;
    /** String value for Artist genre */
    private final String genre;
    /** Integer value for value of R.raw.song resource*/
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
