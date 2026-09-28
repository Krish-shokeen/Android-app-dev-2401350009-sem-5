package com.example.lab_assignment_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Question5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        CheckBox checkJava = findViewById(R.id.checkJavaQ5);
        CheckBox checkPython = findViewById(R.id.checkPythonQ5);
        CheckBox checkCpp = findViewById(R.id.checkCppQ5);
        Button btnSubmitLangs = findViewById(R.id.btnSubmitLangs);

        btnSubmitLangs.setOnClickListener(v -> {
            StringBuilder languages = new StringBuilder();
            if (checkJava.isChecked()) languages.append("Java ");
            if (checkPython.isChecked()) languages.append("Python ");
            if (checkCpp.isChecked()) languages.append("C++ ");
            
            if(languages.length() == 0) {
                 Toast.makeText(this, "No languages selected", Toast.LENGTH_SHORT).show();
            } else {
                 Toast.makeText(this, "Selected: " + languages.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}