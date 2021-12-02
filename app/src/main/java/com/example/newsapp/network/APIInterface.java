package com.example.newsapp.network;

import com.example.newsapp.model.MasterResponceModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("sources?")
    Call<MasterResponceModel> doGetListResources( @Query("category") String category, @Query("apiKey") String apiKey,@Query("country") String country);
}
