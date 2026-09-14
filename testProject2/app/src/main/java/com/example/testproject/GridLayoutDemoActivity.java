package com.example.testproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridLayoutDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_layout_demo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set listeners for buttons 1-9
        for (int i = 1; i <= 9; i++) {
            int resId = getResources().getIdentifier("btn" + i, "id", getPackageName());
            Button button = findViewById(resId);
            final int number = i;
            button.setOnClickListener(v -> {
                Toast.makeText(GridLayoutDemoActivity.this, "Button " + number + " clicked", Toast.LENGTH_SHORT).show();
            });
        }

    }
}
