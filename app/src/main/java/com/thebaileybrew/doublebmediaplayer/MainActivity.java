package com.thebaileybrew.doublebmediaplayer;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

public class MainActivity extends AppCompatActivity {

    BottomNavigation musicNavigator;
    PagerAdapter musicPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //https://github.com/florent37/DiagonalLayout

        //https://github.com/florent37/MaterialLeanBack

        //https://github.com/sephiroth74/Material-BottomNavigation

        musicNavigator = findViewById(R.id.bottomNavigation);
        musicNavigator.setSelectedIndex(2,true);
        final ViewPager pager = findViewById(R.id.viewPager);
        musicPagerAdapter = new pagerAdapter(getSupportFragmentManager());
        pager.setAdapter(musicPagerAdapter);
        pager.setCurrentItem(2,true);

        musicNavigator.setOnMenuItemClickListener(new BottomNavigation.OnMenuItemSelectionListener() {
            @Override
            public void onMenuItemSelect(int i, int i1, boolean b) {
                pager.setCurrentItem(i1,true);
            }

            @Override
            public void onMenuItemReselect(int i, int i1, boolean b) {

            }
        });

        //        SongItems = new ArrayList<>();
        //        SongItems.add(new songItem(1,"Luca Stricagnoli","Thunderstruck",R.drawable.luca_image_300, "Instrumental"));
        //        SongItems.add(new songItem(2,"Pop Evil", "Monster You Made", R.drawable.pop_evil_700, "Rock"));
        //        SongItems.add(new songItem(3,"Disturbed", "Sound of Silence", R.drawable.disturbed_300, "Rock"));
        //        SongItems.add(new songItem(4,"Metallica","Fade to Black", R.drawable.metallica_400, "Rock"));
        //        SongItems.add(new songItem(5,"Pop Evil", "Waking Lions", R.drawable.pop_evil_700, "Rock"));
        //        SongItems.add(new songItem(6,"Pop Evil", "The Big House",R.drawable.pop_evil_700, "Rock"));
        //        SongItems.add(new songItem(7,"Metallica", "Enter The Sandman", R.drawable.metallica_400, "Rock"));
        //        SongItems.add(new songItem(8,"Two Cellos", "Smells Like Teen Spirit", R.drawable.twocellos_900, "Instrumental"));
        //        SongItems.add(new songItem(9,"Lindsey Stirling", "Radioactive",R.drawable.lindsey_stirling_1000, "Instrumental"));
        //        SongItems.add(new songItem(10, "Two Cellos", "Smooth Criminal", R.drawable.twocellos_900, "Instrumental"));
        //        SongItems.add(new songItem(11, "Andy McKee", "Art of Motion", R.drawable.andymckee_800,"Instrumental"));
        //        SongItems.add(new songItem(12, "The Chainsmokers", "Everybody Hates Me", R.drawable.chainsmokers_500, "Electronic"));
        //        SongItems.add(new songItem(13, "The Chainsmokers", "Sick Boy", R.drawable.chainsmokers_500, "Electronic"));
        //        SongItems.add(new songItem(14, "Ed Sheeran", "Shape of You", R.drawable.sheeran_700, "Pop"));
        //        SongItems.add(new songItem(15, "Fall Out Boy", "Hum Hallelujah", R.drawable.falloutboy_500, "Alt Rock"));
        //        SongItems.add(new songItem(16, "Green Day", "American Idiot", R.drawable.greenday_700, "Alt Rock"));
        //        SongItems.add(new songItem(17, "Fall Out Boy", "The Mighty Fall", R.drawable.falloutboy_500, "Alt Rock"));
        //        SongItems.add(new songItem(18, "Imagine Dragons", "Radioactive", R.drawable.imaginedragons_1000, "Pop"));
        //        SongItems.add(new songItem(19, "Imagine Dragons", "Thunder", R.drawable.imaginedragons_1000, "Pop"));
        //        SongItems.add(new songItem(20, "Marshmello", "Alone", R.drawable.marshmello_900, "Electronic"));


        //        mBottomNavigation = findViewById(R.id.bottom_navigation);
        //        mBottomNavigation.setSelectedIndex(2,true);
        //        mBottomNavigation.setOnMenuItemClickListener(new BottomNavigation.OnMenuItemSelectionListener() {
        //            @Override
        //            public void onMenuItemSelect(int i, int i1, boolean b) {
        //                switch (i1) {
        //                    case 0:   //ARTISTS
        //                        break;
        //                    case 1:   //GENRES
        //                        break;
        //                    case 2:   //HOME PAGE
        //                        break;
        //                    case 3:   //ALPHABETICAL
        //                        break;
        //                    case 4:   //PLAYLISTS
        //                        break;
        //                }
        //            }
        //
        //            @Override
        //            public void onMenuItemReselect(int i, int i1, boolean b) {
        //
        //            }
        //        });

    }
}
