package com.batuhanbaki.viper.interactors;

import android.util.Log;

import com.batuhanbaki.viper.models.User;
import com.batuhanbaki.viper.services.API.RetrofitService;
import com.batuhanbaki.viper.services.Interfaces.ILoginAPI;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

import retrofit2.Response;

public class LoginInteractor implements IInteractor {
    IInteractorOutput iInteractorOutput;
    CountDownLatch latch;

    public LoginInteractor(IInteractorOutput iInteractorOutput, CountDownLatch latch) {
        this.iInteractorOutput = iInteractorOutput;
        this.latch = latch;
    }

    @Override
    public void login(String username, String password) {
        Log.d("DATAAAX", "data");
        ILoginAPI loginAPI = RetrofitService.getInstance().getApi();
        Thread thread = new Thread(() -> {
            try {
                HashMap<String,String> map = new HashMap<>();
                map.put("PhoneNumber",username);
                map.put("Password",password);
                Response<User> response = loginAPI.login(map).execute();
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        Log.d("DATAAAX", "login: "+response.body().getId());
                        iInteractorOutput.onLoginSuccess(response.body());
                    } else {
                        iInteractorOutput.onLoginError(response.message());
                    }
                } else {
                    iInteractorOutput.onLoginError(response.errorBody().string());
                }
                latch.countDown();
            } catch (IOException e) {
                e.printStackTrace();
                latch.countDown();
            }
        });
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
    }
}
