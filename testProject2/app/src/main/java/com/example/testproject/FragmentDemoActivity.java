package com.example.testproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        findViewById(R.id.btnFirst).setOnClickListener(v -> loadFragment(new FirstFragment()));
        findViewById(R.id.btnSecond).setOnClickListener(v -> loadFragment(new SecondFragment()));
        
        // Optionally load the first fragment by default
        // loadFragment(new FirstFragment());
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}