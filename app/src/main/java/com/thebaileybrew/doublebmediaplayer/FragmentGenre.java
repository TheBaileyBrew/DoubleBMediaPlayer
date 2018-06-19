package com.thebaileybrew.doublebmediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.thebaileybrew.doublebmediaplayer.songArrayList;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentGenre extends Fragment {
    public static FragmentGenre newInstance() {
        FragmentGenre fragment = new FragmentGenre();
        return fragment;
    }
    String selectedArtist;
    String selectedSong;
    String currentGenre;
    int selectedImage;
    int currentPosition;
    boolean genrePlaylist = false;
    ArrayList<songItem> SongItems;
    RecyclerView recyclerGridView;
    ListView playlistRecyclerList;
    ArrayList<genreItem> genreList;
    ArrayList<songItem> tempList = new ArrayList<>();

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_genre, container, false);
        tempList.clear();
        recyclerGridView = view.findViewById(R.id.grid_recycler);
        playlistRecyclerList = view.findViewById(R.id.genre_display_artistlist);
        songArrayList genres = new songArrayList();
        songArrayList songs = new songArrayList();
        genreList = genres.getGenreList();
        SongItems = songs.getSongList();
        GenreAdapter adapter = new GenreAdapter(genreList, new CustomerGenreClickInterface() {
            @Override
            public void onItemClick(View v, int position) {
                SongItems.clear();
                SongItems = songs.getSongList();
                tempList.clear();
                String genre = "";
                Toast.makeText(view.getContext(), "Clicked on this" + position, Toast.LENGTH_SHORT).show();
                switch(position) {
                    case 0: //Rock
                        genre = "Rock";
                        break;
                    case 1: //Electronic
                        genre = "Electronic";
                        break;
                    case 2: //Pop
                        genre = "Pop";
                        break;
                    case 3: //Instrumental
                        genre = "Instrumental";
                        break;
                    case 4: //Alt Rock
                        genre = "Alt Rock";
                        break;
                    case 5: //Country
                        genre = "Country";
                        break;
                    case 6: //Rap & Hip Hop
                        genre = "Rap/Hip Hop";
                        break;
                    case 7: //Folk
                        genre = "Folk";
                        break;
                    case 8: //Jazz
                        genre = "Jazz";
                        break;
                    case 9: //Religious
                        genre = "Religious";
                        break;
                }
                // This takes the String value of genre and checks all songs to see if it has the correct genre
                // If the genre matches, the value is stored in a temporary ArrayList to be passed via Intent.
                for (songItem song : SongItems) {
                    if (song.getGenre().equals(genre)) {
                        tempList.add(song);
                    }
                }
                playlistRecyclerList.setAdapter(new PlaylistAdapter(getActivity(), tempList));
                playlistRecyclerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        genrePlaylist = true;
                        selectedArtist = tempList.get(position).getArtistName();
                        selectedSong = tempList.get(position).getSongName();
                        selectedImage = tempList.get(position).getImage();
                        currentPosition = parent.getSelectedItemPosition();
                        currentGenre = tempList.get(position).getGenre();
                        Toast.makeText(view.getContext(), "You've selected: " + selectedArtist + " and " + selectedSong, Toast.LENGTH_LONG).show();
                        Intent openSongPlayer = new Intent(view.getContext(),CurrentlyPlaying.class);
                        openSongPlayer.putExtra("SelectedArtist", selectedArtist);
                        openSongPlayer.putExtra("SelectedSong", selectedSong);
                        openSongPlayer.putExtra("SelectedImage", selectedImage);
                        openSongPlayer.putExtra("Position", currentPosition);
                        openSongPlayer.putExtra("SelectedGenre",currentGenre);
                        openSongPlayer.putExtra("Playlist", genrePlaylist);
                        view.getContext().startActivity(openSongPlayer);
                    }
                });
            }
        });
        recyclerGridView.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(view.getContext(),3,GridLayoutManager.VERTICAL,false);
        recyclerGridView.setLayoutManager(manager);
        return view;
    }

}
