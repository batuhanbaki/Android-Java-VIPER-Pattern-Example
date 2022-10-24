package com.batuhanbaki.viper.views;

import com.batuhanbaki.viper.models.User;

public interface IView
{
    void goNextScreen(User user);
    void showError(String message);
}
