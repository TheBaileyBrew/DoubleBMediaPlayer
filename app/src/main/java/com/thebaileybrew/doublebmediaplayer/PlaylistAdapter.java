package com.thebaileybrew.doublebmediaplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistAdapter extends ArrayAdapter<songItem> {

    private Context mContext;
    private ArrayList<songItem> SongItems;

    public PlaylistAdapter(@NonNull Context context, ArrayList<songItem> list) {
        super(context, 0, list);
        mContext = context;
        SongItems = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View playlistView = convertView;
        if (playlistView == null) {
            playlistView = LayoutInflater.from(mContext).inflate(R.layout.genre_playlist_listview, parent, false);
        }
        songItem currentGenreSong = SongItems.get(position);
        TextView artistName = playlistView.findViewById(R.id.artist_name);
        TextView songName = playlistView.findViewById(R.id.song_name);
        artistName.setText(currentGenreSong.getArtistName());
        songName.setText(currentGenreSong.getSongName());

        return playlistView;
    }


}
