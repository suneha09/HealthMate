package com.example.healthmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WaterActivity extends AppCompatActivity {

    private EditText editWeight;
    private Button btnCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        editWeight = findViewById(R.id.edit_weight);
        btnCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);

        btnCalculate.setOnClickListener(v -> {
            String weightStr = editWeight.getText().toString();

            if (!weightStr.isEmpty()) {
                float weight = Float.parseFloat(weightStr);
                float waterMl = weight * 35;

                textResult.setText(String.format("Your daily water requirement is %.0f ml (around %.1f L).",
                        waterMl, waterMl / 1000f));
            } else {
                textResult.setText("Please enter a valid weight.");
            }
        });
    }
}
