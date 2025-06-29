package com.example.healthmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BodyFatActivity extends AppCompatActivity {

    private EditText editWeight, editHeight, editAge;
    private Button btnCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_fat);

        editWeight = findViewById(R.id.edit_weight);
        editHeight = findViewById(R.id.edit_height);
        editAge = findViewById(R.id.edit_age);
        btnCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);

        btnCalculate.setOnClickListener(v -> {
            String weightStr = editWeight.getText().toString();
            String heightStr = editHeight.getText().toString();
            String ageStr = editAge.getText().toString();

            if (!weightStr.isEmpty() && !heightStr.isEmpty() && !ageStr.isEmpty()) {
                float weight = Float.parseFloat(weightStr);
                float height = Float.parseFloat(heightStr) / 100f;
                int age = Integer.parseInt(ageStr);

                // Rough estimation using BMI method (you can use more accurate method later!)
                float bmi = weight / (height * height);
                float bodyFat = (1.20f * bmi) + (0.23f * age) - 16.2f;

                textResult.setText(String.format("Your estimated body fat is %.1f%%", bodyFat));
            } else {
                textResult.setText("Please fill all fields.");
            }
        });
    }
}
