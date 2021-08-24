package com.example.newtrainigproject;



import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientApi {

    private static RetrofitClientApi instance = null;
    private RetrofitApiInterface myApi;

    private RetrofitClientApi() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(RetrofitApiInterface.class);
    }
    public static synchronized RetrofitClientApi getInstance() {
        if (instance == null) {
            instance = new RetrofitClientApi();
        }
        return instance;
    }

    public RetrofitApiInterface getMyApi() {
        return myApi;
    }
}
