package com.batuhanbaki.viper.interactors;

import com.batuhanbaki.viper.models.User;

public interface IInteractorOutput {
    void onLoginSuccess(User user);

    void onLoginError(String message);
}
