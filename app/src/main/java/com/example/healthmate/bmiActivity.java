package com.example.healthmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bmiActivity extends AppCompatActivity {
    private EditText editWeight, editHeight;
    private Button buttonCalculate;
    private TextView textResult, textAdvice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        // Initialize Views
        editWeight = findViewById(R.id.edit_weight);
        editHeight = findViewById(R.id.edit_height);
        buttonCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);
        textAdvice = findViewById(R.id.text_advice);

        // Button Click
        buttonCalculate.setOnClickListener(v -> {
            String weightStr = editWeight.getText().toString();
            String heightStr = editHeight.getText().toString();

            if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                float weight = Float.parseFloat(weightStr);
                float heightCm = Float.parseFloat(heightStr);

                // Convert CM to M
                float heightMeters = heightCm / 100;

                // Calculate BMI
                float bmi = weight / (heightMeters * heightMeters);

                // Result
                textResult.setText(String.format("Your BMI is: %.2f", bmi));

                // Advice
                if (bmi < 18.5) {
                    textAdvice.setText("💡 Underweight: Try to eat more nutritious and calorie-rich meals.");
                } else if (bmi < 24.9) {
                    textAdvice.setText("✅ Normal: Maintain your current lifestyle for a balanced health.");
                } else if (bmi < 29.9) {
                    textAdvice.setText("⚠️ Overweight: Consider regular exercise and a balanced diet.");
                } else {
                    textAdvice.setText("❗ Obesity: Consult a doctor or nutritionist for personalized guidance.");
                }
            } else {
                textResult.setText("Please fill in both fields.");
                textAdvice.setText("");
            }
        });
    }
}
