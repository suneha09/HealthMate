package com.example.healthmate;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MealTimingActivity extends AppCompatActivity {

    private EditText editWeight, editGoal;
    private Button buttonCalculate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_timing);

        editWeight = findViewById(R.id.edit_weight);
        editGoal = findViewById(R.id.edit_goal);
        buttonCalculate = findViewById(R.id.button_calculate_plan);
        textResult = findViewById(R.id.text_result);

        buttonCalculate.setOnClickListener(v -> {
            String weightStr = editWeight.getText().toString();
            String goal = editGoal.getText().toString().toLowerCase().trim();

            if (!weightStr.isEmpty() && !goal.isEmpty()) {
                float weight = Float.parseFloat(weightStr);
                String result = generateMealPlan(weight, goal);
                textResult.setText(result);
            } else {
                textResult.setText("Please fill in both fields.");
            }
        });
    }

    private String generateMealPlan(float weight, String goal) {
        String morning = "7:30 AM - Light breakfast";
        String lunch = "12:30 PM - Balanced lunch";
        String snack = "4:00 PM - Healthy snack";
        String dinner = "7:30 PM - Light dinner";

        if (goal.equals("gain")) {
            return "For Weight Gain (" + weight + "kg):\n" +
                    morning + " (Add more protein and carbs)\n" +
                    lunch + " (Increase portion size)\n" +
                    snack + " (Nuts, yogurt or protein shake)\n" +
                    dinner + " (More complex carbs and lean protein)";
        } else if (goal.equals("loss")) {
            return "For Weight Loss (" + weight + "kg):\n" +
                    morning + " (High protein, low carbs)\n" +
                    lunch + " (Lean protein and veggies)\n" +
                    snack + " (Fruit or yogurt)\n" +
                    dinner + " (Light, low-calorie meal)";
        } else {
            return "For Maintaining (" + weight + "kg):\n" +
                    morning + " (Balanced breakfast)\n" +
                    lunch + " (Adequate protein, moderate carbs)\n" +
                    snack + " (Fruit, nuts or yogurt)\n" +
                    dinner + " (Moderate portion, balanced nutrition)";
        }
    }
}
