package com.thebaileybrew.doublebmediaplayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class pagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 5;

    public pagerAdapter (FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0: // Search
                return FragmentSearch.newInstance();
            case 1: // Genres
                return FragmentGenre.newInstance();
            case 2: // Home
                return FragmentHomePage.newInstance();
            case 3: // A to Z
                return FragmentAlpha.newInstance();
            case 4: // Playlists
                return FragmentPlaylist.newInstance();
        }
        return null;
    }

    @Override
    public int getItemPosition(Object object) {
        if (object instanceof Fragment) {
            return POSITION_UNCHANGED;
        } else {
            return POSITION_NONE;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
