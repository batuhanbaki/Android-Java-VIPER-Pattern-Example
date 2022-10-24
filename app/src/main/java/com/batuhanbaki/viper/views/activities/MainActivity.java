package com.batuhanbaki.viper.views.activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.batuhanbaki.viper.base.BaseActivity;
import com.batuhanbaki.viper.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.batuhanbaki.viper.databinding.ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        String data = "Id:" + bundle.getString("Id") + " Token:" + bundle.getString("Token");
        binding.data.setText(data);
    }
}
