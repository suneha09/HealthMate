package com.example.healthmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CaloriesBurnedActivity extends AppCompatActivity {

    private EditText editWeight, editDuration, editMet;
    private Button btnCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_burned);

        // Initialize Views
        editWeight = findViewById(R.id.edit_weight);
        editDuration = findViewById(R.id.edit_duration);
        editMet = findViewById(R.id.edit_met);
        btnCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);

        btnCalculate.setOnClickListener(v -> {
            String weightStr = editWeight.getText().toString();
            String durationStr = editDuration.getText().toString();
            String metStr = editMet.getText().toString();

            if (!weightStr.isEmpty() && !durationStr.isEmpty() && !metStr.isEmpty()) {
                float weight = Float.parseFloat(weightStr);
                float duration = Float.parseFloat(durationStr);
                float met = Float.parseFloat(metStr);

                // CALORIES BURNED FORMULA
                float calories = (met * 3.5f * weight / 200) * duration;

                textResult.setText("Calories Burned: " + String.format("%.2f", calories) + " kcal");
            } else {
                textResult.setText("Please fill in all fields.");
            }
        });
    }
}
