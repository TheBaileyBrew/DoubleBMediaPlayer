package com.thebaileybrew.doublebmediaplayer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FragmentGenre extends Fragment {
    public static FragmentGenre newInstance() {
        FragmentGenre fragment = new FragmentGenre();
        return fragment;
    }

    String selectedArtist;
    String selectedSong;
    int selectedImage;
    int currentPosition;
    List<songItem> SongItems;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_genre, container, false);

        return view;
    }
}
