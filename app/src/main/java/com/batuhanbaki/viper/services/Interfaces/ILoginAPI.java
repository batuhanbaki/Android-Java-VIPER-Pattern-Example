package com.batuhanbaki.viper.services.Interfaces;

import com.batuhanbaki.viper.models.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ILoginAPI {
    @POST("/api/auth/login")
    Call<User> login(@Body Map<String,String> credentials);
}
