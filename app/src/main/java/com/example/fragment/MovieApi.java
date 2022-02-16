package com.example.fragment;
import com.example.fragment.model.Retrofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("now_playing")
    Call<Retrofit> getMovie(@Query("api_key") String key);

    @GET("top_rated")
    Call<Retrofit> getTopRated(@Query("api_key") String key);
}

