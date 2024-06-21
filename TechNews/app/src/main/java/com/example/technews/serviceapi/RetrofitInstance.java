package com.example.technews.serviceapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    //act as a central configuration point for
    // defining how http requests are made
    //should be handled

    private static Retrofit retrofit = null;
    private  static  String BASE_URL = "https://newsapi.org/";

    public static NewsApiService getService(){
        if(retrofit ==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit.create(NewsApiService.class);

    }
}
