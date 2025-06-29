package com.example.healthmate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Button buttonEditProfile, buttonNotificationSettings, buttonPrivacyPolicy, buttonAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        buttonEditProfile = findViewById(R.id.button_edit_profile);
        buttonNotificationSettings = findViewById(R.id.button_notification_settings);
        buttonPrivacyPolicy = findViewById(R.id.button_privacy_policy);
        buttonAbout = findViewById(R.id.button_about);

        buttonEditProfile.setOnClickListener(v -> {
            // TODO: Open Edit Profile page
            // startActivity(new Intent(SettingsActivity.this, EditProfileActivity.class));
        });
        buttonNotificationSettings.setOnClickListener(v -> {
            // TODO: Open Notification Settings page
            // startActivity(new Intent(SettingsActivity.this, NotificationSettingsActivity.class));
        });
        buttonPrivacyPolicy.setOnClickListener(v -> {
            // TODO: Open Privacy Policy page
            // startActivity(new Intent(SettingsActivity.this, PrivacyPolicyActivity.class));
        });
        buttonAbout.setOnClickListener(v -> {
            // TODO: Open About page
            // startActivity(new Intent(SettingsActivity.this, AboutActivity.class));
        });
    }
}
