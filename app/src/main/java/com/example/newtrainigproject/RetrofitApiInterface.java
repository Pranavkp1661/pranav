package com.example.newtrainigproject;

import com.example.newtrainigproject.model.RetrofitListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiInterface {
    String BASE_URL="https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<RetrofitListModel>> getSuperHero();
}
