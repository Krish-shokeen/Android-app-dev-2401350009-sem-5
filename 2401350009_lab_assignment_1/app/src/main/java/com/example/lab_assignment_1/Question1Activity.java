package com.example.lab_assignment_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Question1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        EditText editName = findViewById(R.id.editName);
        EditText editEmail = findViewById(R.id.editEmail);
        EditText editPhone = findViewById(R.id.editPhone);
        RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
        CheckBox checkJava = findViewById(R.id.checkJava);
        CheckBox checkPython = findViewById(R.id.checkPython);
        CheckBox checkCpp = findViewById(R.id.checkCpp);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String email = editEmail.getText().toString();
            String phone = editPhone.getText().toString();
            
            String gender = "";
            int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
            if (selectedGenderId != -1) {
                RadioButton selectedGender = findViewById(selectedGenderId);
                gender = selectedGender.getText().toString();
            }

            StringBuilder languages = new StringBuilder();
            if (checkJava.isChecked()) languages.append("Java ");
            if (checkPython.isChecked()) languages.append("Python ");
            if (checkCpp.isChecked()) languages.append("C++ ");

            String result = "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone + 
                            "\nGender: " + gender + "\nLanguages: " + languages.toString();

            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        });
    }
}