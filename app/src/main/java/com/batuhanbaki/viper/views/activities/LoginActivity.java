package com.batuhanbaki.viper.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.batuhanbaki.viper.base.BaseActivity;
import com.batuhanbaki.viper.models.User;
import com.batuhanbaki.viper.presenters.IPresenter;
import com.batuhanbaki.viper.presenters.LoginPresenter;
import com.batuhanbaki.viper.views.IView;
import com.batuhanbaki.viper.databinding.ActivityLoginBinding;

import java.util.Objects;

public class LoginActivity extends BaseActivity implements IView, View.OnClickListener {

    ActivityLoginBinding binding;
    IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new LoginPresenter(this);
    }

    @Override
    public void goNextScreen(User user) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Id", user.getId());
        intent.putExtra("Token", user.getToken());
        startActivity(intent);
        finish();
    }

    @Override
    public void showError(String message) {
        runOnUiThread(() -> {
            Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == binding.loginBtn.getId()) {
            presenter.onLoginButton(Objects.requireNonNull(binding.etUsername.getText()).toString(), Objects.requireNonNull(binding.etPassword.getText()).toString());
        }
    }
}