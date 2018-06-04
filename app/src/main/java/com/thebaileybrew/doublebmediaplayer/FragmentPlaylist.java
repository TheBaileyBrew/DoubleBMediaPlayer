package com.thebaileybrew.doublebmediaplayer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FragmentPlaylist extends Fragment {
    public static FragmentPlaylist newInstance() {
        FragmentPlaylist fragment = new FragmentPlaylist();
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

        final View view = inflater.inflate(R.layout.fragment_playlist, container, false);

        return view;
    }
}
