package com.example.abridge.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    public static final Object LOCK = new Object();
    public static volatile RestClient sInstance;

    private Retrofit retrofit;

    private RestClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(APIEndpoints.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RestClient getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
               if (sInstance == null)
                    sInstance = new RestClient();
            }
        }

        return sInstance;
    }

    public Retrofit getAPIClient() {
        return retrofit;
    }
}
