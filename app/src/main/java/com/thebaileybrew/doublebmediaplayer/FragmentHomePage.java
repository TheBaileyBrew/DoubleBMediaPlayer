package com.thebaileybrew.doublebmediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.florent37.materialleanback.MaterialLeanBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentHomePage extends Fragment {
    public static FragmentHomePage newInstance() {
        FragmentHomePage fragment = new FragmentHomePage();
        return fragment;
    }

    String selectedArtist;
    String selectedSong;
    int selectedImage;
    int currentPosition;
    ArrayList<songItem> SongItems;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        songArrayList songs = new songArrayList();
        SongItems = songs.getSongList();
        MaterialLeanBack materialLeanBack = view.findViewById(R.id.material_leanback);
        materialLeanBack.setAdapter(new MaterialLeanBack.Adapter<MusicViewHolder>() {
            @Override
            public int getLineCount() {
                return 1;
            }

            @Override
            public int getCellsCount(int row) {
                return SongItems.size();
            }

            @Override
            public MusicViewHolder onCreateViewHolder(ViewGroup viewGroup, int row) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.song_display_item, viewGroup,false);
                return new MusicViewHolder(view);
            }

            @Override
            public void onBindViewHolder(MusicViewHolder viewHolder, int position) {
                viewHolder.songArtist.setText(SongItems.get(position).getArtistName());
                viewHolder.songName.setText(SongItems.get(position).getSongName());
                viewHolder.songImage.setImageResource(SongItems.get(position).getImage());
            }
        });

        materialLeanBack.setOnItemClickListener(new MaterialLeanBack.OnItemClickListener() {
            @Override
            public void onTitleClicked(int row, String text) {
            }
            @Override
            public void onItemClicked(int row, int column) {
                column = column -1;
                selectedArtist = SongItems.get(column).getArtistName();
                selectedSong = SongItems.get(column).getSongName();
                selectedImage = SongItems.get(column).getImage();
                currentPosition = SongItems.get(column).getId();
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
