package com.batuhanbaki.viper.presenters;

import com.batuhanbaki.viper.interactors.IInteractor;
import com.batuhanbaki.viper.interactors.IInteractorOutput;
import com.batuhanbaki.viper.interactors.LoginInteractor;
import com.batuhanbaki.viper.models.User;
import com.batuhanbaki.viper.views.IView;

import java.util.concurrent.CountDownLatch;

public class LoginPresenter implements IPresenter, IInteractorOutput {

    private IView view;
    private IInteractor iInteractor;

    public LoginPresenter(IView view) {
        this.view = view;
        iInteractor = new LoginInteractor(this, new CountDownLatch(1));
    }

    @Override
    public void onLoginSuccess(User user) {
        view.goNextScreen(user);
    }

    @Override
    public void onLoginError(String message) {
        view.showError(message);
    }

    @Override
    public void onDestroy() {
        view = null;
        iInteractor = null;
    }

    @Override
    public void onLoginButton(String username, String password) {
        iInteractor.login(username, password);
    }
}
