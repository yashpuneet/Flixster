package com.example.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Movie> movies;

    private final int POP = 1;
    private final int NP = 0;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getItemViewType(int position) {
        Movie movie = movies.get(position);
        if (movie.getVote() > 7) {
            return POP;
        } else {
            return NP;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(context);
        RecyclerView.ViewHolder viewHolder;

        if (viewType == POP) {
            View popView = inflater.inflate(R.layout.item_popular_movie, parent, false);
            viewHolder = new PopularViewHolder(popView);
        } else {
            View movieView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder = new ViewHolder(movieView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d("MovieAdapter", "onBindViewHolder " + position);
        Movie movie = movies.get(position);

        if (holder.getItemViewType() == POP) {
            PopularViewHolder popularViewHolder = (PopularViewHolder) holder;
            popularViewHolder.bind(movie);
        }
        else
        {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.bind(movie);
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPoster;
        TextView tvTitle;
        TextView tvOverview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
        }

        public void bind(Movie movie) {
            String imageUrl;

            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                imageUrl = movie.getBackdropPath();
            } else {
                imageUrl = movie.getPosterPath();
            }

            Glide.with(context).load(imageUrl).placeholder(R.drawable.ic__85640_movie_icon).into(ivPoster);
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
        }
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView popImage;
        TextView popTitle;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            popImage = itemView.findViewById(R.id.popImage);
            popTitle = itemView.findViewById(R.id.popTitle);
        }

        public void bind(Movie movie) {
            String imageUrl = movie.getBackdropPath();

            Glide.with(context).load(imageUrl).placeholder(R.drawable.ic__85640_movie_icon).into(popImage);
            popTitle.setText(movie.getTitle());
        }
    }

}
