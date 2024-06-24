package com.example.technews.model;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.technews.R;
import com.example.technews.serviceapi.NewsApiService;
import com.example.technews.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    // repository is used to get data from database or api
    private ArrayList<Article> articles= new ArrayList<>();
    private MutableLiveData<List<Article>> mutableLiveData = new MutableLiveData<>();

    private Application application;

    public NewsRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Article>> getMutableLiveData() {

        NewsApiService newsApiService = RetrofitInstance.getService();

        Call<Result> call = newsApiService.getTechNews(application.getApplicationContext().getString(R.string.tech),application.getApplicationContext().getString(R.string.sortBy),application.getApplicationContext().getString(R.string.apiKey));

        //enqueue is  asynchronous(background) method to make http request

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                //get the response
                Result result = response.body();
                if(result!=null && result.getNewsArticleList()!=null){

                articles =(ArrayList<Article>)result.getNewsArticleList();
                mutableLiveData.setValue(articles);

                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {
                System.out.println("error");
            }
        });

        return mutableLiveData;
    }



}
