package com.example.healthmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WeightGainActivity extends AppCompatActivity {

    private EditText editCurrentWeight, editTargetWeight;
    private Button btnCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_gain);

        editCurrentWeight = findViewById(R.id.edit_current_weight);
        editTargetWeight = findViewById(R.id.edit_target_weight);
        btnCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);

        btnCalculate.setOnClickListener(v -> {
            String currentWeightStr = editCurrentWeight.getText().toString();
            String targetWeightStr = editTargetWeight.getText().toString();

            if (!currentWeightStr.isEmpty() && !targetWeightStr.isEmpty()) {
                float currentWeight = Float.parseFloat(currentWeightStr);
                float targetWeight = Float.parseFloat(targetWeightStr);
                float weightToGain = targetWeight - currentWeight;

                if (weightToGain > 0) {
                    float caloriesRequired = weightToGain * 7700; // Approx. calories for 1 kg
                    textResult.setText(String.format("You need approximately %.0f kcal to gain %.1f kg.",
                            caloriesRequired, weightToGain));
                } else {
                    textResult.setText("Target weight must be greater than the current weight.");
                }
            } else {
                textResult.setText("Please fill all fields.");
            }
        });
    }
}
