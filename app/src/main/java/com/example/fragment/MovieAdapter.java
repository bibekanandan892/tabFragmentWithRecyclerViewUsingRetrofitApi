package com.example.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fragment.model.Result;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;
    List<Result> nowPlayingData;
    public MovieAdapter(Context context, List<Result> playings) {
        this.context=context;
        this.nowPlayingData=playings;
    }


    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.show_movies,null);
        MovieViewHolder movieViewHolder= new MovieViewHolder(view);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder( MovieAdapter.MovieViewHolder holder, int position) {

        holder.name.setText(nowPlayingData.get(position).getTitle());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/original"+nowPlayingData.get(position).getPosterPath())
                .into(holder.view);
    }

    @Override
    public int getItemCount() {
        return nowPlayingData.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView view;
        public MovieViewHolder( View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tvTitle);
            view=itemView.findViewById(R.id.imageView);
        }
    }
}

