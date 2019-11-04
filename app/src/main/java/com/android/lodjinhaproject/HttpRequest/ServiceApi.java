package com.android.lodjinhaproject.HttpRequest;

import com.android.lodjinhaproject.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceApi {

    private Retrofit mRetrofit = null;

    public ServiceApi(){}

    public DataEndpoint getAPI(){
        String BASE_URL = Constants.BASE_URL;
        if(mRetrofit == null){
            mRetrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit.create(DataEndpoint.class);
    }
}
