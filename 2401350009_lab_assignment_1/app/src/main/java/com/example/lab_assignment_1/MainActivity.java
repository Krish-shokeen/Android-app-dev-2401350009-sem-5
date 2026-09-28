package com.example.lab_assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnQ1 = findViewById(R.id.btnQ1);
        Button btnQ2 = findViewById(R.id.btnQ2);
        Button btnQ3 = findViewById(R.id.btnQ3);
        Button btnQ4 = findViewById(R.id.btnQ4);
        Button btnQ5 = findViewById(R.id.btnQ5);

        btnQ1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Question1Activity.class)));
        btnQ2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Question2Activity.class)));
        btnQ3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Question3Activity.class)));
        btnQ4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Question4Activity.class)));
        btnQ5.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Question5Activity.class)));
    }
}