package com.example.healthmate;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IbwActivity extends AppCompatActivity {

    private EditText editHeight, editGender;
    private Button btnCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibw);

        editHeight = findViewById(R.id.edit_height);
        editGender = findViewById(R.id.edit_gender);
        btnCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);

        btnCalculate.setOnClickListener(v -> {
            String heightStr = editHeight.getText().toString();
            String genderStr = editGender.getText().toString().toLowerCase().trim();

            if (!heightStr.isEmpty() && !genderStr.isEmpty()) {
                float heightCm = Float.parseFloat(heightStr);
                float heightInches = heightCm / 2.54f;

                // Apply Devine formula
                float ibw;

                if (genderStr.equals("male")) {
                    ibw = 50 + 2.3f * (heightInches - 60);
                } else if (genderStr.equals("female")) {
                    ibw = 45.5f + 2.3f * (heightInches - 60);
                } else {
                    textResult.setText("Invalid gender! Enter 'male' or 'female'.");
                    return;
                }

                textResult.setText("Ideal Body Weight: " + String.format("%.2f", ibw) + " kg");
            } else {
                textResult.setText("Please fill in both fields.");
            }
        });
    }
}
