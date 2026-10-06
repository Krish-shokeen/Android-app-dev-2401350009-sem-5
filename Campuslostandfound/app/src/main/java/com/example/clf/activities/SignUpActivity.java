package com.example.clf.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.clf.MainActivity;
import com.example.clf.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etPassword = findViewById(R.id.etPassword);
        EditText etConfirmPassword = findViewById(R.id.etConfirmPassword);
        Button btnSignUp = findViewById(R.id.btnSignUp);
        TextView tvLogin = findViewById(R.id.tvLogin);

        btnSignUp.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String phone = etPhone.getText().toString();
            String pass = etPassword.getText().toString();
            String confirmPass = etConfirmPassword.getText().toString();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else if (!pass.equals(confirmPass)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                finishAffinity();
            }
        });

        tvLogin.setOnClickListener(v -> finish());
    }
}