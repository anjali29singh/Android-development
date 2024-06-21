package com.example.technews.serviceapi;

import com.example.technews.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiService {

    @GET("v2/everything")
    Call<Result> getTechNews(@Query("q") String query,@Query("apiKey") String apikey);
}
