package com.example.movieapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.RequestManager;
import com.example.movieapp.adapter.MoviesAdapter;
import com.example.movieapp.adapter.MoviesLoadStateApter;
import com.example.movieapp.databinding.ActivityMainBinding;
import com.example.movieapp.model.Movie;
import com.example.movieapp.util.GridSpace;
import com.example.movieapp.util.MovieComparator;
import com.example.movieapp.util.Util;
import com.example.movieapp.viewmodel.MovieViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

public class MainActivity extends AppCompatActivity {

    MovieViewModel mainActivityViewModel;
    ActivityMainBinding binding;
    MoviesAdapter moviesAdapter;

    @Inject
    RequestManager requestManager;
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Util.API_KEY == null || Util.API_KEY.isEmpty()) {

            Toast.makeText(this, "Error in API key", Toast.LENGTH_SHORT).show();
        }

        moviesAdapter = new MoviesAdapter(new MovieComparator(), requestManager);
        mainActivityViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        initRecyclerViewAndAdapter();
        //subscribe to paging data

        mainActivityViewModel.moviePagingDataFlowable.subscribe(moviePagingData -> {

            moviesAdapter.submitData(getLifecycle(),moviePagingData);
        });
    }

    private  void initRecyclerViewAndAdapter(){


        GridLayoutManager  gridLayoutManager = new GridLayoutManager(this,2);
        binding.recyclerViewMovies.setLayoutManager(gridLayoutManager);

        binding.recyclerViewMovies.addItemDecoration(new GridSpace(2,20,true));


        binding.recyclerViewMovies.setAdapter(moviesAdapter.withLoadStateFooter(new MoviesLoadStateApter(view ->

        {
            moviesAdapter.retry();
        })));

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return moviesAdapter.getItemViewType(position) == MoviesAdapter.LOADING_ITEM ? 1:2;
            }
        });
    }
}