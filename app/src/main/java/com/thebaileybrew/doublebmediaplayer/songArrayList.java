package com.thebaileybrew.doublebmediaplayer;

import java.util.ArrayList;
import java.util.List;

public class songArrayList extends ArrayList{
    private ArrayList<songItem> SongItems = new ArrayList<>();
    private ArrayList<genreItem> genreList = new ArrayList<>();

    public ArrayList getSongList() {
        SongItems.add(new songItem(1, "Luca Stricagnoli", "Thunderstruck", R.drawable.luca_image_300, "Instrumental"));
        SongItems.add(new songItem(2, "Pop Evil", "Monster You Made", R.drawable.pop_evil_700, "Rock"));
        SongItems.add(new songItem(3, "Disturbed", "Sound of Silence", R.drawable.disturbed_300, "Rock"));
        SongItems.add(new songItem(4, "Metallica", "Fade to Black", R.drawable.metallica_400, "Rock"));
        SongItems.add(new songItem(5, "Pop Evil", "Waking Lions", R.drawable.pop_evil_700, "Rock"));
        SongItems.add(new songItem(6, "Pop Evil", "The Big House", R.drawable.pop_evil_700, "Rock"));
        SongItems.add(new songItem(7, "Metallica", "Enter The Sandman", R.drawable.metallica_400, "Rock"));
        SongItems.add(new songItem(8, "Two Cellos", "Smells Like Teen Spirit", R.drawable.twocellos_900, "Instrumental"));
        SongItems.add(new songItem(9, "Lindsey Stirling", "Radioactive", R.drawable.lindsey_stirling_1000, "Instrumental"));
        SongItems.add(new songItem(10, "Two Cellos", "Smooth Criminal", R.drawable.twocellos_900, "Instrumental"));
        SongItems.add(new songItem(11, "Andy McKee", "Art of Motion", R.drawable.andymckee_800, "Instrumental"));
        SongItems.add(new songItem(12, "The Chainsmokers", "Everybody Hates Me", R.drawable.chainsmokers_500, "Electronic"));
        SongItems.add(new songItem(13, "The Chainsmokers", "Sick Boy", R.drawable.chainsmokers_500, "Electronic"));
        SongItems.add(new songItem(14, "Ed Sheeran", "Shape of You", R.drawable.sheeran_700, "Pop"));
        SongItems.add(new songItem(15, "Fall Out Boy", "Hum Hallelujah", R.drawable.falloutboy_500, "Alt Rock"));
        SongItems.add(new songItem(16, "Green Day", "American Idiot", R.drawable.greenday_700, "Alt Rock"));
        SongItems.add(new songItem(17, "Fall Out Boy", "The Mighty Fall", R.drawable.falloutboy_500, "Alt Rock"));
        SongItems.add(new songItem(18, "Imagine Dragons", "Radioactive", R.drawable.imaginedragons_1000, "Pop"));
        SongItems.add(new songItem(19, "Imagine Dragons", "Thunder", R.drawable.imaginedragons_1000, "Pop"));
        SongItems.add(new songItem(20, "Marshmello", "Alone", R.drawable.marshmello_900, "Electronic"));
        return SongItems;
    }

    public ArrayList getGenreList() {
        genreList.add(new genreItem(1,"Rock", R.drawable.rock_icon, R.drawable.rock));
        genreList.add(new genreItem(2,"Electronic", R.drawable.edm_icon, R.drawable.electronic));
        genreList.add(new genreItem(3,"Pop", R.drawable.pop_icon, R.drawable.pop));
        genreList.add(new genreItem(4,"Instrumental", R.drawable.instrumental_icon, R.drawable.instrumental));
        genreList.add(new genreItem(5,"Alt Rock", R.drawable.alt_rock_icon, R.drawable.altrock));
        return genreList;
    }
}
