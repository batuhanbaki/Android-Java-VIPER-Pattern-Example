package com.batuhanbaki.viper.base;

import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {
    private boolean isClicked = false;
    @Override
    public void onBackPressed() {
        if (isClicked) {
            BaseActivity.super.onBackPressed();
        } else {
            Toast.makeText(BaseActivity.this, "Çıkmak için lütfen tekrar tıklayınız", Toast.LENGTH_SHORT).show();
            isClicked = true;
            new Handler().postDelayed(() -> isClicked = false, 1500);
        }
    }
}
