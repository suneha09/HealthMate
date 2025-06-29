package com.example.healthmate;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tipActivity extends AppCompatActivity {
    private ImageView imageTip;
    private TextView textTipTitle, textTipDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        imageTip = findViewById(R.id.image_tip);
        textTipTitle = findViewById(R.id.text_tip_title);
        textTipDescription = findViewById(R.id.text_tip_description);

        // Here you can set a specific tip text, or load from an array, or an Intent
        textTipTitle.setText("Health Tip of the Day");
        textTipDescription.setText("Drink at least 8 glasses of water daily to stay properly hydrated and support your overall health.");
        // If needed, you can also set an image programmatically:
        // imageTip.setImageResource(R.drawable.your_tip_image_here);
    }
}
