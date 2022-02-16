package com.example.fragment;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class restAdapter  {

    public static MovieApi getMovies(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        MovieApi api= retrofit.create(MovieApi.class);
        return  api;
    }
}
