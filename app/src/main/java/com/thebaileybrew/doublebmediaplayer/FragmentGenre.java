package com.thebaileybrew.doublebmediaplayer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.thebaileybrew.doublebmediaplayer.songArrayList;

import java.util.ArrayList;
import java.util.List;

public class FragmentGenre extends Fragment implements GenreAdapter.ItemListener{
    public static FragmentGenre newInstance() {
        FragmentGenre fragment = new FragmentGenre();
        return fragment;
    }

    String selectedArtist;
    String selectedSong;
    int selectedImage;
    int currentPosition;
    ArrayList<songItem> SongItems;
    RecyclerView recyclerGridView;
    ArrayList<genreItem> genreList;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_genre, container, false);

        recyclerGridView = view.findViewById(R.id.grid_recycler);
        songArrayList genres = new songArrayList();
        genreList = genres.getGenreList();
        GenreAdapter adapter = new GenreAdapter(view.getContext(),genreList,this) {};
        recyclerGridView.setAdapter(adapter);

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(view.getContext(),300);
        recyclerGridView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onItemClick(genreItem item) {

    }
}
