package com.example.healthmate;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FastingActivity extends AppCompatActivity {

    private EditText editFastingHours;
    private Button buttonCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasting);

        editFastingHours = findViewById(R.id.edit_fasting_hours);
        buttonCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);

        buttonCalculate.setOnClickListener(v -> {
            String fastingHoursStr = editFastingHours.getText().toString();

            if (!fastingHoursStr.isEmpty()) {
                int fastingHours = Integer.parseInt(fastingHoursStr);

                if (fastingHours >= 0 && fastingHours <= 24) {
                    int eatingHours = 24 - fastingHours;

                    textResult.setText("Fasting Hours: " + fastingHours + "h\n" +
                            "Eating Window: " + eatingHours + "h");
                } else {
                    textResult.setText("Please enter hours between 0 and 24.");
                }
            } else {
                textResult.setText("Please enter fasting hours.");
            }
        });
    }
}
