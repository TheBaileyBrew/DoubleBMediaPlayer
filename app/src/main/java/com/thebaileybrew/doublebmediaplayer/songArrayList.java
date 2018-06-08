package com.thebaileybrew.doublebmediaplayer;

import java.util.ArrayList;
import java.util.List;

public class songArrayList extends ArrayList{
    private ArrayList<songItem> SongItems = new ArrayList<>();
    private ArrayList<genreItem> genreList = new ArrayList<>();

    //Get Raw Files from here: http://domino-music.net/?mp3=Jidenna&artist=0

    public ArrayList getSongList() {
        SongItems.add(new songItem(1, "Luca Stricagnoli", "Thunderstruck", R.drawable.luca_image_300, "Instrumental", R.raw.thunderstruck_luca));
        SongItems.add(new songItem(2, "Disturbed", "Open Your Eyes", R.drawable.disturbed_300, "Rock", R.raw.openyoureyes_disturbed));
        SongItems.add(new songItem(3, "Disturbed", "Sound of Silence", R.drawable.disturbed_300, "Rock", R.raw.soundofsilence_disturbed));
        SongItems.add(new songItem(4, "Metallica", "Nothing Else Matters", R.drawable.metallica_400, "Rock", R.raw.nothingelse_metallica));
        SongItems.add(new songItem(5, "Pop Evil", "Waking Lions", R.drawable.pop_evil_700, "Rock", R.raw.wakinglions_popevil));
        SongItems.add(new songItem(6, "Linkin Park", "In The End", R.drawable.linkin_700, "Rock", R.raw.intheend_linkin));
        SongItems.add(new songItem(7, "Metallica", "Enter The Sandman", R.drawable.metallica_400, "Rock", R.raw.entersandman_metallica));
        SongItems.add(new songItem(8, "Two Cellos", "Smells Like Teen Spirit", R.drawable.twocellos_900, "Instrumental", R.raw.smellslike_cellos));
        SongItems.add(new songItem(9, "Lindsey Stirling", "All Of Me", R.drawable.lindsey_stirling_1000, "Instrumental", R.raw.allofme_stirling));
        SongItems.add(new songItem(10, "Two Cellos", "Smooth Criminal", R.drawable.twocellos_900, "Instrumental", R.raw.smoothcriminal_cellos));
        SongItems.add(new songItem(11, "Andy McKee", "Art of Motion", R.drawable.andymckee_800, "Instrumental", R.raw.artofmotion_andy));
        SongItems.add(new songItem(12, "The Chainsmokers", "Everybody Hates Me", R.drawable.chainsmokers_500, "Electronic", R.raw.everybody_chain));
        SongItems.add(new songItem(13, "The Chainsmokers", "Sick Boy", R.drawable.chainsmokers_500, "Electronic", R.raw.sickboy_chain));
        SongItems.add(new songItem(14, "Ed Sheeran", "Shape of You", R.drawable.sheeran_700, "Pop", R.raw.shapeofyou_ed));
        SongItems.add(new songItem(15, "Fall Out Boy", "Immortals", R.drawable.falloutboy_500, "Alt Rock", R.raw.immortals_fob));
        SongItems.add(new songItem(16, "Green Day", "American Idiot", R.drawable.greenday_700, "Alt Rock", R.raw.idiot_green));
        SongItems.add(new songItem(17, "Fall Out Boy", "Sugar Were Going Down", R.drawable.falloutboy_500, "Alt Rock", R.raw.sugar_fob));
        SongItems.add(new songItem(18, "Imagine Dragons", "Radioactive", R.drawable.imaginedragons_1000, "Pop", R.raw.radioactive_dragons));
        SongItems.add(new songItem(19, "Imagine Dragons", "Thunder", R.drawable.imaginedragons_1000, "Pop", R.raw.thunder_dragons));
        SongItems.add(new songItem(20, "Selena Gomez", "Wolves", R.drawable.selena_900, "Pop", R.raw.wolves_marsh));
        SongItems.add(new songItem(21,"Kendrick Lamar","All The Stars", R.drawable.kendricklamar_800,"Rap/Hip Hop", R.raw.allthestars_kendrick));
        SongItems.add(new songItem(22,"The Weeknd", "Pray For Me", R.drawable.theweeknd_800, "Rap/Hip Hop", R.raw.pray_weeknd));
        SongItems.add(new songItem(23, "Jidenna", "Long Live The Chief", R.drawable.jidenna_800, "Rap/Hip Hop", R.raw.longlive_jidenna));
        SongItems.add(new songItem(24, "Witt Lowry", "Wish You Knew", R.drawable.wittlowry_800, "Rap/Hip Hop", R.raw.wishyouknew_wittlowry));
        SongItems.add(new songItem(25,"Ludacris","Get Back", R.drawable.ludacris_800, "Rap/Hip Hop", R.raw.getback_ludacris));
        SongItems.add(new songItem(26,"Ludacris","Act A Fool", R.drawable.ludacris_800, "Rap/Hip Hop", R.raw.actafool_ludacris));
        SongItems.add(new songItem(27, "The Lumineers", "Sleep on the Floor", R.drawable.lumineers_800, "Folk", R.raw.sleep_lumineers));
        SongItems.add(new songItem(28, "Shawn McDonald", "Hope Is Right Here", R.drawable.shawnmcdonald_800, "Religious", R.raw.hope_shawnmcdonald));
        SongItems.add(new songItem(29, "Shawn McDonald", "We Are Brave", R.drawable.shawnmcdonald_800, "Religious", R.raw.brave_shawnmcdonald));
        SongItems.add(new songItem(30, "Passenger", "Beautiful Birds", R.drawable.passenger_800, "Folk", R.raw.beautifulbirds_passenger));
        SongItems.add(new songItem(31, "Florida Georgia Line", "Last Day Alive", R.drawable.fgl_800, "Country", R.raw.lastdayalive_fgl));
        SongItems.add(new songItem(32, "Rascal Flatts", "What Hurts The Most", R.drawable.rascalflatts_800, "Country", R.raw.hurtsthemost_rascall));
        SongItems.add(new songItem(33, "Rascal Flatts", "Life is a Highway", R.drawable.rascalflatts_800, "Country", R.raw.highway_rascal));
        SongItems.add(new songItem(34, "Miranda Lambert", "Kerosene", R.drawable.lambert_800, "Country", R.raw.kerosene_miranda));
        SongItems.add(new songItem(35, "Marshmello", "Let Me Love You", R.drawable.marshmello_900, "Electronic", R.raw.letmelove_marsh));
        SongItems.add(new songItem(36,"Anberlin", "Breathe", R.drawable.anberlin_800, "Religious", R.raw.breathe_anberlin));
        SongItems.add(new songItem(37, "Crowder", "I Am", R.drawable.crowder_800, "Religious", R.raw.iam_crowder));
        SongItems.add(new songItem(38, "Anberlin", "Feel Good Drag", R.drawable.anberlin_800, "Religious", R.raw.feelgooddrag_anberlin));
        SongItems.add(new songItem(39, "Skillet", "Hero", R.drawable.skillet_800, "Religious", R.raw.hero_skillet));
        SongItems.add(new songItem(40, "The Lumineers", "Ho Hey", R.drawable.lumineers_800, "Folk", R.raw.hohey_lumineers));
        SongItems.add(new songItem(41,"Mumford and Sons", "Little Lion Man", R.drawable.mumford_800, "Folk", R.raw.littlelion_mumford));
        SongItems.add(new songItem(42, "The Gray Havens", "Silver", R.drawable.grayhavens_600, "Folk", R.raw.silver_grayhavens));
        SongItems.add(new songItem(43, "The Gray Havens", "Ghost of a King", R.drawable.grayhavens_600, "Folk", R.raw.ghost_grayhavens));


        return SongItems;
    }

    public ArrayList getGenreList() {
        genreList.add(new genreItem(1,"Rock", R.drawable.rock_icon, R.drawable.rock));
        genreList.add(new genreItem(2,"Electronic", R.drawable.edm_icon, R.drawable.electronic));
        genreList.add(new genreItem(3,"Pop", R.drawable.pop_icon, R.drawable.pop));
        genreList.add(new genreItem(4,"Instrumental", R.drawable.instrumental_icon, R.drawable.instrumental));
        genreList.add(new genreItem(5,"Alt Rock", R.drawable.alt_rock_icon, R.drawable.altrock));
        genreList.add(new genreItem(6,"Country", R.drawable.country_icon, R.drawable.country));
        genreList.add(new genreItem(7,"Rap/Hip-Hop", R.drawable.hiphop_icon, R.drawable.hiphop));
        genreList.add(new genreItem(8,"Folk",R.drawable.folk_icon, R.drawable.folk));
        genreList.add(new genreItem(9,"Jazz", R.drawable.jazz_icon, R.drawable.jazz));
        genreList.add(new genreItem(10,"Religious", R.drawable.religious_icon, R.drawable.religious));
        return genreList;
    }
}
