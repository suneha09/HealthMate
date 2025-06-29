package com.example.healthmate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button buttonHealthTip, buttonBmi, buttonBmr, buttonSettings, buttonGoToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // Initialize Buttons
        buttonHealthTip = findViewById(R.id.button_health_tip);
        buttonBmi = findViewById(R.id.button_bmi);
        buttonBmr = findViewById(R.id.button_bmr);
        buttonSettings = findViewById(R.id.button_settings);
        buttonGoToMain = findViewById(R.id.button_go_to_main);

        // Click Listeners
        buttonHealthTip.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, tipActivity.class);
            startActivity(intent);
        });

        buttonBmi.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, bmiActivity.class);
            startActivity(intent);
        });

        buttonBmr.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, bmrActivity.class);
            startActivity(intent);
        });

        buttonSettings.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        buttonGoToMain.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
