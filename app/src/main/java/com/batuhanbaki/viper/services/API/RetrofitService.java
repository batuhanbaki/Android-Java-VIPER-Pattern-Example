package com.batuhanbaki.viper.services.API;

import com.batuhanbaki.viper.services.Interfaces.ILoginAPI;

import java.io.Serializable;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService implements Serializable {
    //Thread Safe Instance
    private static volatile RetrofitService INSTANCE;
    private static ILoginAPI api;

    private RetrofitService() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(chain -> {
            Request.Builder requestBuilder = chain.request().newBuilder();
            requestBuilder.header("Content-Type", "application/json");
            requestBuilder.header("Accept", "application/json");
            return chain.proceed(requestBuilder.build());
        });
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("BASE-URL")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build());
        Retrofit retrofit = builder.build();
        api = retrofit.create(ILoginAPI.class);
    }

    public static RetrofitService getInstance() {
        if (INSTANCE == null) {
            synchronized (RetrofitService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RetrofitService();
                }
            }

        }
        return INSTANCE;
    }

    public ILoginAPI getApi() {
        return api;
    }

    public Object readResolve() {
        return INSTANCE;
    }
}
