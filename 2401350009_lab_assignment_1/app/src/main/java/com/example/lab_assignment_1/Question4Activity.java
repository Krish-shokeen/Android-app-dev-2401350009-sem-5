package com.example.lab_assignment_1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Question4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        Spinner spinnerCity = findViewById(R.id.spinnerCity);
        Button btnSubmitCity = findViewById(R.id.btnSubmitCity);

        String[] cities = {"Delhi", "Mumbai", "Bangalore", "Chennai", "Kolkata", "Hyderabad", "Pune", "Ahmedabad"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapter);

        btnSubmitCity.setOnClickListener(v -> {
            String selectedCity = spinnerCity.getSelectedItem().toString();
            Toast.makeText(this, "Selected City: " + selectedCity, Toast.LENGTH_SHORT).show();
        });
    }
}