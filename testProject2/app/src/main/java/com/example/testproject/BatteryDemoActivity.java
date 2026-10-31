package com.example.testproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BatteryDemoActivity extends AppCompatActivity {
    
    private Button btnStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_demo);

        btnStatus = findViewById(R.id.btnStatus);

        btnStatus.setOnClickListener(v -> {
            BatteryReceiver receiver = new BatteryReceiver();
            IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            registerReceiver(receiver, filter);
        });
    }
}
