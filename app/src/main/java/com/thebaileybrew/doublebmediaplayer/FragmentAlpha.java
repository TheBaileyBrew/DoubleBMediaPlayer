package com.thebaileybrew.doublebmediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_alpha, container, false);
       alphaListing = view.findViewById(R.id.artist_listing);
        SongItems = new ArrayList<>();
        SongItems.add(new songItem(1,"Luca Stricagnoli","Thunderstruck",R.drawable.luca_image_300, "Instrumental"));
        SongItems.add(new songItem(2,"Pop Evil", "Monster You Made", R.drawable.pop_evil_700, "Rock"));
        SongItems.add(new songItem(3,"Disturbed", "Sound of Silence", R.drawable.disturbed_300, "Rock"));
        SongItems.add(new songItem(4,"Metallica","Fade to Black", R.drawable.metallica_400, "Rock"));
        SongItems.add(new songItem(5,"Pop Evil", "Waking Lions", R.drawable.pop_evil_700, "Rock"));
        SongItems.add(new songItem(6,"Pop Evil", "The Big House",R.drawable.pop_evil_700, "Rock"));
        SongItems.add(new songItem(7,"Metallica", "Enter The Sandman", R.drawable.metallica_400, "Rock"));
        SongItems.add(new songItem(8,"Two Cellos", "Smells Like Teen Spirit", R.drawable.twocellos_900, "Instrumental"));
        SongItems.add(new songItem(9,"Lindsey Stirling", "Radioactive",R.drawable.lindsey_stirling_1000, "Instrumental"));
        SongItems.add(new songItem(10, "Two Cellos", "Smooth Criminal", R.drawable.twocellos_900, "Instrumental"));
        SongItems.add(new songItem(11, "Andy McKee", "Art of Motion", R.drawable.andymckee_800,"Instrumental"));
        SongItems.add(new songItem(12, "The Chainsmokers", "Everybody Hates Me", R.drawable.chainsmokers_500, "Electronic"));
        SongItems.add(new songItem(13, "The Chainsmokers", "Sick Boy", R.drawable.chainsmokers_500, "Electronic"));
        SongItems.add(new songItem(14, "Ed Sheeran", "Shape of You", R.drawable.sheeran_700, "Pop"));
        SongItems.add(new songItem(15, "Fall Out Boy", "Hum Hallelujah", R.drawable.falloutboy_500, "Alt Rock"));
        SongItems.add(new songItem(16, "Green Day", "American Idiot", R.drawable.greenday_700, "Alt Rock"));
        SongItems.add(new songItem(17, "Fall Out Boy", "The Mighty Fall", R.drawable.falloutboy_500, "Alt Rock"));
        SongItems.add(new songItem(18, "Imagine Dragons", "Radioactive", R.drawable.imaginedragons_1000, "Pop"));
        SongItems.add(new songItem(19, "Imagine Dragons", "Thunder", R.drawable.imaginedragons_1000, "Pop"));
        SongItems.add(new songItem(20, "Marshmello", "Alone", R.drawable.marshmello_900, "Electronic"));

        Collections.sort(SongItems, new Comparator<songItem>() {
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
                view.getContext().startActivity(openSongPlayer);
            }
        });




        return view;
    }
}
