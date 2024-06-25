package com.example.movieapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.example.movieapp.model.Movie;
import  com.example.movieapp.databinding.SingleMovieItemBinding;
import io.reactivex.rxjava3.core.Single;

public class MoviesAdapter extends PagingDataAdapter<Movie,MoviesAdapter.MovieViewHolder> {

    public  static  final int LOADING_ITEM=0;
    public static  final int MOVIE_ITEM=1;
    RequestManager glide;

    public  MoviesAdapter(@NonNull DiffUtil.ItemCallback<Movie> diffCallback,RequestManager requestManager){

        super(diffCallback);
        this.glide=glide;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(SingleMovieItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = getItem(position);

        if (movie != null) {

            glide.load("https://image.tmdb.org/t/p/w500" + movie.getPosterPath()).into(holder.movieItemBinding.imageViewMovie);
        }
    }

    @Override
    public int getItemViewType(int position) {

        return  position==getItemCount()? MOVIE_ITEM : LOADING_ITEM;
    }

    public  class MovieViewHolder extends RecyclerView.ViewHolder{

        SingleMovieItemBinding movieItemBinding;
        public  MovieViewHolder(@NonNull SingleMovieItemBinding movieItemBinding){

            super(movieItemBinding.getRoot());
            this.movieItemBinding = movieItemBinding;
        }

    }


}
