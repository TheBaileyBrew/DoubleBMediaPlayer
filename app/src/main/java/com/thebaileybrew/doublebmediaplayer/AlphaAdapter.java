package com.thebaileybrew.doublebmediaplayer;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// This Adapter populates the Alphabetical sort in the AlphaFragment

public class AlphaAdapter extends ArrayAdapter<songItem> {


    private Context mContext;
    private ArrayList<songItem> SongItems;

    public AlphaAdapter(@NonNull Context context, ArrayList<songItem> list) {
        super(context, 0, list);
        mContext = context;
        SongItems = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.alpha_listview, parent, false);
        }

        songItem currentSong = SongItems.get(position);
        TextView artistName = listItem.findViewById(R.id.artist_name);
        artistName.setText(currentSong.getArtistName());
        TextView songName = listItem.findViewById(R.id.song_name);
        songName.setText(currentSong.getSongName());

        return listItem;
    }
}
