package com.tzutalin.dlibtest;

import com.tzutalin.dlibtest.domain.RequestAnalyzeSleepDTO;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {

    Retrofit retrofit;
    RetrofitInterface server;

    public RetrofitConnection(){ }

    public RetrofitConnection(String url){
        setRetrofit(url);
    }

    public RetrofitInterface getServer() {
        return server;
    }

    public void setServer(RetrofitInterface server) {
        this.server = server;
    }

    public void setRetrofit(String url){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        server = retrofit.create(RetrofitInterface.class);

    }

    public void requestSleepAnalyze(RequestAnalyzeSleepDTO requestAnalyzeSleepDTO){

    }


}