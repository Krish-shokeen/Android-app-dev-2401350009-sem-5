package com.example.testproject;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView tvAppName = findViewById(R.id.tvAppName);
        TextView tvVersion = findViewById(R.id.tvVersion);
        TextView tvDesc = findViewById(R.id.tvDesc);

        // Get app name (from app settings)
        String appName = getApplicationInfo().loadLabel(getPackageManager()).toString();
        tvAppName.setText(appName);

        // Get version name safely
        try {
            PackageManager pm = getPackageManager();
            PackageInfo info = pm.getPackageInfo(getPackageName(), 0);
            String versionName = info.versionName;
            tvVersion.setText("Version " + versionName);
        } catch (PackageManager.NameNotFoundException e) {
            // If version info is not found, show default text
            tvVersion.setText("Version N/A");
        }

        tvDesc.setText("This app helps you manage your daily tasks.");
    }
}