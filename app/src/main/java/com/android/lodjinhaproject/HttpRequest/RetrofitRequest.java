package com.android.lodjinhaproject.HttpRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.android.lodjinhaproject.constants.Constants.BASE_URL;

public class RetrofitRequest {

    private static Retrofit sRetrofit;

    public static Retrofit getRetrofitInstance(){
        if(sRetrofit == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            sRetrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return sRetrofit;
    }
}
