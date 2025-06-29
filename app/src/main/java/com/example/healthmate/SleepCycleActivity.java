package com.example.healthmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SleepCycleActivity extends AppCompatActivity {

    private EditText editWakeUp;
    private Button buttonCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_cycle);

        editWakeUp = findViewById(R.id.edit_wake_up);
        buttonCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);

        buttonCalculate.setOnClickListener(v -> {
            String wakeUpTime = editWakeUp.getText().toString();
            if (wakeUpTime.isEmpty() || !wakeUpTime.matches("\\d{2}:\\d{2}")) {
                textResult.setText("Please enter a valid time in HH:MM (24h) format.");
            } else {
                textResult.setText(calculateBedTimes(wakeUpTime));
            }
        });
    }

    private String calculateBedTimes(String wakeUpTime) {
        String[] parts = wakeUpTime.split(":");
        int wakeUpHour = Integer.parseInt(parts[0]);
        int wakeUpMinute = Integer.parseInt(parts[1]);

        int[][] bedTimes = new int[6][2];
        for (int i = 1; i <= 6; i++) {
            int totalMinutes = (wakeUpHour * 60 + wakeUpMinute) - (i * 90);
            totalMinutes = (totalMinutes + 24 * 60) % (24 * 60);
            bedTimes[i - 1][0] = totalMinutes / 60;
            bedTimes[i - 1][1] = totalMinutes % 60;
        }

        StringBuilder result = new StringBuilder("Ideal Bedtimes:\n");
        for (int i = 0; i < bedTimes.length; i++) {
            result.append(String.format("%02d:%02d\n", bedTimes[i][0], bedTimes[i][1]));
        }
        return result.toString();
    }
}
