package com.thebaileybrew.doublebmediaplayer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.materialleanback.MaterialLeanBack;

public class MusicViewHolder extends MaterialLeanBack.ViewHolder {

    TextView songArtist;
    TextView songName;
    ImageView songImage;

    public MusicViewHolder(View itemView) {
        super(itemView);
        songArtist = itemView.findViewById(R.id.cardview_artist_name);
        songName = itemView.findViewById(R.id.cardview_song_name);
        songImage = itemView.findViewById(R.id.cardview_artist_image);
    }
}
