package com.example.healthmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HeartRateActivity extends AppCompatActivity {

    private EditText editAge;
    private Button buttonCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate);

        editAge = findViewById(R.id.edit_age);
        buttonCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);

        buttonCalculate.setOnClickListener(v -> {
            String ageStr = editAge.getText().toString();
            if (!ageStr.isEmpty()) {
                int age = Integer.parseInt(ageStr);
                int maxHeartRate = 220 - age;
                int targetLow = (int) (maxHeartRate * 0.5);
                int targetHigh = (int) (maxHeartRate * 0.85);

                textResult.setText(
                        "Max Heart Rate: " + maxHeartRate + " bpm\n" +
                                "Target Zone: " + targetLow + "–" + targetHigh + " bpm"
                );
            } else {
                textResult.setText("Please enter a valid age.");
            }
        });
    }
}
