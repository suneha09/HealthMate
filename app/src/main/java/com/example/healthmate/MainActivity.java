package com.example.healthmate;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnHealthTip, btnBmi, btnBmr, btnTdee, btnBodyFat,
            btnWater, btnIbw, btnPregnancy, btnHeartRate, btnCaloriesBurned,
            btnFasting, btnSleep, btnMealTiming,
            btnWeightGain, btnNormal, btnWeightLoss, btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHealthTip = findViewById(R.id.button_health_tip);
        btnBmi = findViewById(R.id.button_bmi);
        btnBmr = findViewById(R.id.button_bmr);
        btnTdee = findViewById(R.id.button_tdee);
        btnBodyFat = findViewById(R.id.button_bodyfat);
        btnWater = findViewById(R.id.button_water);
        btnIbw = findViewById(R.id.button_ibw);
        btnPregnancy = findViewById(R.id.button_pregnancy);
        btnHeartRate = findViewById(R.id.button_heartrate);
        btnCaloriesBurned = findViewById(R.id.button_caloriesburned);
        btnFasting = findViewById(R.id.button_fasting);
        btnSleep = findViewById(R.id.button_sleep);
        btnMealTiming = findViewById(R.id.button_mealtiming);
        btnWeightGain = findViewById(R.id.button_weight_gain);
        btnNormal = findViewById(R.id.button_normal);
        btnWeightLoss = findViewById(R.id.button_weight_loss);
        btnSettings = findViewById(R.id.button_settings);

        // Click Listeners
        btnHealthTip.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, tipActivity.class)));
        btnBmi.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, bmiActivity.class)));
        btnBmr.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, bmrActivity.class)));
        btnTdee.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TdeeActivity.class)));
        btnBodyFat.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, BodyFatActivity.class)));
        btnWater.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, WaterActivity.class)));
        btnIbw.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, IbwActivity.class)));
        btnPregnancy.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PregnancyDueDateActivity.class)));
        btnHeartRate.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HeartRateActivity.class)));
        btnCaloriesBurned.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CaloriesBurnedActivity.class)));
        btnFasting.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FastingActivity.class)));
        btnSleep.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SleepCycleActivity.class)));
        btnMealTiming.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MealTimingActivity.class)));
        btnWeightGain.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, WeightGainActivity.class)));
        btnNormal.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, NormalDietActivity.class)));
        btnWeightLoss.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, WeightLossActivity.class)));
        btnSettings.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SettingsActivity.class)));
    }
}