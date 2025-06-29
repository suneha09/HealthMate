package com.example.healthmate;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class bmrActivity extends AppCompatActivity {

    private EditText editWeight, editHeight, editAge, editGender;
    private TextView textResult;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);

        editWeight = findViewById(R.id.edit_weight);
        editHeight = findViewById(R.id.edit_height);
        editAge = findViewById(R.id.edit_age);
        editGender = findViewById(R.id.edit_gender);
        textResult = findViewById(R.id.text_result);
        buttonCalculate = findViewById(R.id.button_calculate);

        buttonCalculate.setOnClickListener(v -> {
            String weightStr = editWeight.getText().toString();
            String heightStr = editHeight.getText().toString();
            String ageStr = editAge.getText().toString();
            String gender = editGender.getText().toString().toLowerCase();

            if (!weightStr.isEmpty() && !heightStr.isEmpty() && !ageStr.isEmpty() && !gender.isEmpty()) {
                float weight = Float.parseFloat(weightStr);
                float height = Float.parseFloat(heightStr);
                int age = Integer.parseInt(ageStr);

                float bmr;
                if (gender.equals("male")) {
                    bmr = 10 * weight + 6.25f * height - 5 * age + 5;
                } else if (gender.equals("female")) {
                    bmr = 10 * weight + 6.25f * height - 5 * age - 161;
                } else {
                    textResult.setText("Invalid gender. Enter 'male' or 'female'.");
                    return;
                }

                textResult.setText("Your BMR is " + String.format("%.2f", bmr) + " kcal/day");
            } else {
                textResult.setText("Please fill in all fields correctly.");
            }
        });
    }
}
