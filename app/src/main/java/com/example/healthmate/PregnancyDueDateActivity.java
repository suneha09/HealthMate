package com.example.healthmate;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class PregnancyDueDateActivity extends AppCompatActivity {

    private Button btnPickDate, btnCalculate;
    private TextView textResult;

    private int lmpYear, lmpMonth, lmpDay;
    private boolean isDatePicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy_due_date);

        btnPickDate = findViewById(R.id.button_pick_date);
        btnCalculate = findViewById(R.id.button_calculate);
        textResult = findViewById(R.id.text_result);

        btnPickDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePicker = new DatePickerDialog(
                    PregnancyDueDateActivity.this,
                    (view, year, month, dayOfMonth) -> {
                        lmpYear = year;
                        lmpMonth = month;
                        lmpDay = dayOfMonth;
                        isDatePicked = true;
                        btnPickDate.setText("LMP Date: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            datePicker.show();
        });


        btnCalculate.setOnClickListener(v -> {
            if (isDatePicked) {
                Calendar dueDate = Calendar.getInstance();
                dueDate.set(lmpYear, lmpMonth, lmpDay);
                dueDate.add(Calendar.DAY_OF_YEAR, 280);

                int year = dueDate.get(Calendar.YEAR);
                int month = dueDate.get(Calendar.MONTH) + 1;
                int day = dueDate.get(Calendar.DAY_OF_MONTH);

                textResult.setText("Estimated Due Date:\n" + day + "/" + month + "/" + year);
            } else {
                textResult.setText("Please pick the LMP date first.");
            }
        });
    }
}
