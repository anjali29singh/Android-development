package com.example.technews;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.technews.databinding.ActivityMainBinding;
import com.example.technews.model.Article;
import com.example.technews.view.ArticleAdapter;
import com.example.technews.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Article> articlesList;
    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;
    private SwipeRefreshLayout   swipeRefreshLayout;

    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        getTopNews();
        swipeRefreshLayout = binding.swipeLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.black);
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        getTopNews();
                    }
                }
        );

    }

    private  void getTopNews(){

        viewModel.getAllArticles().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articlesFromLiveData) {
                articlesList = ( ArrayList<Article>) articlesFromLiveData;
                displayArticlesInRecyclerView();
            }
        });
    }

    private void displayArticlesInRecyclerView() {

        recyclerView = binding.recyclerview;
        articleAdapter = new ArticleAdapter(this,articlesList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(articleAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        articleAdapter.notifyDataSetChanged();
    }
}