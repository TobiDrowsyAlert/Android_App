package com.tzutalin.dlibtest;

import android.util.Log;
import android.widget.Toast;

import com.tzutalin.dlibtest.domain.RequestAnalyzeSleepDTO;
import com.tzutalin.dlibtest.user.domain.RequestLoginDTO;
import com.tzutalin.dlibtest.user.domain.ResponseLoginDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {

    final String TAG = "RetrofitConnection";

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

    public void requestLogin(RequestLoginDTO requestLoginDTO){
        Call<ResponseLoginDTO> call = this.getServer().login(requestLoginDTO);
        call.enqueue(new Callback<ResponseLoginDTO>() {
            @Override
            public void onResponse(Call<ResponseLoginDTO> call, Response<ResponseLoginDTO> response) {

                if(response.isSuccessful()){
                    Log.e(TAG,"loginSuccess");
                }

            }

            @Override
            public void onFailure(Call<ResponseLoginDTO> call, Throwable t) {

            }
        });
    }



}