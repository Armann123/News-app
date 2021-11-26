package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterfacce {

    String BASE_URL="https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<NewsVariables>getNews(
    @Query("country")  String country,
    @Query("pageSize") int pagesize,
    @Query("apiKey") String apikey

    );

    @GET("top-headlines")
    Call<NewsVariables>getCategoryNews(
            @Query("country")  String country,
            @Query("pageSize") int pagesize,
            @Query("category") String category,
            @Query("apiKey") String apikey

    );

    Call<NewsVariables> getCategoryNews(String country, int i, String api);

}

