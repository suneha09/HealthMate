package com.example.healthmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WeightLossActivity extends AppCompatActivity {
    private EditText editCurrentWeight, editTargetWeight;
    private Button btnCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_loss);

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

                if (targetWeight < currentWeight) {
                    float weightToLose = currentWeight - targetWeight;

                    textResult.setText(String.format("You need to lose %.2f kg to reach your target weight!", weightToLose));
                } else {
                    textResult.setText("Your target weight is not lower than your current weight.");
                }
            } else {
                textResult.setText("Please fill in both fields.");
            }
        });
    }
}
