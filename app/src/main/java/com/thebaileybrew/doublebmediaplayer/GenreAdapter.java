package com.thebaileybrew.doublebmediaplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {

    private ArrayList<genreItem> genreItems;
    CustomerGenreClickInterface genreListener;

    public GenreAdapter(ArrayList<genreItem> GenreItems, CustomerGenreClickInterface listener) {
        this.genreItems = GenreItems;
        this.genreListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_display_item,parent,false);
        ViewHolder vHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genreListener.onItemClick(view, vHolder.getLayoutPosition());
            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        genreItem currentGenre = genreItems.get(position);

        holder.nameOfGenre.setText(currentGenre.getGenreName());
        holder.backgroundOfGenre.setImageResource(currentGenre.getGenreBackground());
        holder.iconOfGenre.setImageResource(currentGenre.getGenreIcon());

    }

    @Override
    public int getItemCount() {
        return genreItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView nameOfGenre;
        private ImageView backgroundOfGenre;
        private ImageView iconOfGenre;

        public ViewHolder(View genreView) {
            super(genreView);
            nameOfGenre = genreView.findViewById(R.id.genre_name);
            backgroundOfGenre = genreView.findViewById(R.id.genre_background);
            iconOfGenre = genreView.findViewById(R.id.genre_icon);

        }


    }
}
