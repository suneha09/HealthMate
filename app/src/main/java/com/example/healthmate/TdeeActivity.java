package com.example.healthmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TdeeActivity extends AppCompatActivity {

    private EditText editWeight, editHeight, editAge, editGender, editActivityFactor;
    private Button btnCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdee);

        editWeight = findViewById(R.id.edit_weight);
        editHeight = findViewById(R.id.edit_height);
        editAge = findViewById(R.id.edit_age);
        editGender = findViewById(R.id.edit_gender);
        editActivityFactor = findViewById(R.id.edit_activity_factor);
        btnCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);

        btnCalculate.setOnClickListener(v -> {
            String weightStr = editWeight.getText().toString();
            String heightStr = editHeight.getText().toString();
            String ageStr = editAge.getText().toString();
            String genderStr = editGender.getText().toString().toLowerCase();
            String activityStr = editActivityFactor.getText().toString();

            if (!weightStr.isEmpty() && !heightStr.isEmpty() && !ageStr.isEmpty() && !genderStr.isEmpty() && !activityStr.isEmpty()) {
                float weight = Float.parseFloat(weightStr);
                float height = Float.parseFloat(heightStr);
                int age = Integer.parseInt(ageStr);
                float activityFactor = Float.parseFloat(activityStr);

                // Mifflin-St Jeor Equation
                float bmr;

                if (genderStr.equals("male")) {
                    bmr = 10 * weight + 6.25f * height - 5 * age + 5;
                } else {
                    bmr = 10 * weight + 6.25f * height - 5 * age - 161;
                }

                float tdee = bmr * activityFactor;

                textResult.setText("Your TDEE is approximately " + String.format("%.2f kcal/day", tdee));
            } else {
                textResult.setText("Please fill all fields.");
            }
        });
    }
}
