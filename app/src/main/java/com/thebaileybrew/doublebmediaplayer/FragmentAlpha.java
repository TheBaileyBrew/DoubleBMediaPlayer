package com.thebaileybrew.doublebmediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FragmentAlpha extends Fragment {
    public static FragmentAlpha newInstance() {
        FragmentAlpha fragment = new FragmentAlpha();
        return fragment;
    }

    ArrayList<songItem> SongItems;
    ListView alphaListing;
    String selectedArtist;
    String selectedSong;
    int selectedImage;
    int currentPosition;
    Boolean alphaPlaylist;


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_alpha, container, false);
       alphaListing = view.findViewById(R.id.artist_listing);
        songArrayList songs = new songArrayList();
        SongItems = songs.getSongList();

        Collections.sort(SongItems, new Comparator<songItem>() {
            // This compares and resorts the ArrayList in alphabetical order by combining Artist + Song to create a unique identifier
            @Override
            public int compare(songItem o1, songItem o2) {
                return (o1.getArtistName() + o1.getSongName()).compareTo((o2.getArtistName() + o2.getSongName()));
            }
        });

        //mAdapter = new AlphaAdapter(view.getContext().getApplicationContext(), SongItems);
        alphaListing.setAdapter(new AlphaAdapter(getActivity(), SongItems));

        alphaListing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                alphaPlaylist = true;
                selectedArtist = SongItems.get(position).getArtistName();
                selectedSong = SongItems.get(position).getSongName();
                selectedImage = SongItems.get(position).getImage();
                currentPosition = SongItems.get(position).getId();
                Toast.makeText(view.getContext(), "You've selected: " + selectedArtist + " and " + selectedSong, Toast.LENGTH_LONG).show();
                Intent openSongPlayer = new Intent(view.getContext(),CurrentlyPlaying.class);
                openSongPlayer.putExtra("SelectedArtist", selectedArtist);
                openSongPlayer.putExtra("SelectedSong", selectedSong);
                openSongPlayer.putExtra("SelectedImage", selectedImage);
                openSongPlayer.putExtra("Position", currentPosition);
                openSongPlayer.putExtra("APlaylist",alphaPlaylist);
                view.getContext().startActivity(openSongPlayer);
            }
        });




        return view;
    }
}
