package com.example.technews.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.technews.model.Article;
import com.example.technews.model.NewsRepository;

import java.util.List;

public class MainActivityViewModel  extends AndroidViewModel {

      private   NewsRepository newsRepository;

      LiveData<List<Article>> articleList;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.newsRepository = new NewsRepository(application);

    }

    public LiveData<List<Article>> getAllArticles(){

        return newsRepository.getMutableLiveData();
    }
}
