package com.example.clf.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.clf.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button btnGetStarted = findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(v -> {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        });
        
        // Auto transition after 3 seconds if button is not clicked
        new Handler().postDelayed(() -> {
            if (!isDestroyed()) {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, 3000);
    }
}