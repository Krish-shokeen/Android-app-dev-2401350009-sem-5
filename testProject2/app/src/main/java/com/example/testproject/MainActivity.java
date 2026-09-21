package com.example.testproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // I removed EdgeToEdge for now to fix the black screen issue
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_open_calculator).setOnClickListener(v -> startActivity(new Intent(this, CalculatorActivity.class)));
        findViewById(R.id.btn_open_second_activity).setOnClickListener(v -> startActivity(new Intent(this, Second_activity.class)));
        findViewById(R.id.btn_open_checkbox).setOnClickListener(v -> startActivity(new Intent(this, CheckboxActivity.class)));
        findViewById(R.id.btn_open_listview).setOnClickListener(v -> startActivity(new Intent(this, ListViewActivity.class)));
        findViewById(R.id.btn_open_login_page).setOnClickListener(v -> startActivity(new Intent(this, Login_page.class)));
        findViewById(R.id.btn_open_select_color).setOnClickListener(v -> startActivity(new Intent(this, Select_color.class)));
        findViewById(R.id.btn_open_hello_page).setOnClickListener(v -> startActivity(new Intent(this, HelloActivity.class)));
        findViewById(R.id.btn_open_google).setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))));
        findViewById(R.id.btn_open_caller).setOnClickListener(v -> startActivity(new Intent(this, CallerActivity.class)));
        findViewById(R.id.btn_open_location).setOnClickListener(v -> startActivity(new Intent(this, LocationActivity.class)));
        findViewById(R.id.btn_open_file_manager).setOnClickListener(v -> startActivity(new Intent(this, FileManagerActivity.class)));
        findViewById(R.id.btn_open_grid_layout).setOnClickListener(v -> startActivity(new Intent(this, GridLayoutDemoActivity.class)));
        findViewById(R.id.btn_open_frame_layout).setOnClickListener(v -> startActivity(new Intent(this, FrameLayoutActivity.class)));
        findViewById(R.id.btn_open_linear_layout).setOnClickListener(v -> startActivity(new Intent(this, LinearLayoutDemoActivity.class)));
        findViewById(R.id.btn_open_food_order).setOnClickListener(v -> startActivity(new Intent(this, FoodOrderActivity.class)));
        findViewById(R.id.btn_open_splash_screen).setOnClickListener(v -> startActivity(new Intent(this, SplashActivity.class)));
        findViewById(R.id.btn_open_fragment_demo).setOnClickListener(v -> startActivity(new Intent(this, FragmentDemoActivity.class)));
    }
}
