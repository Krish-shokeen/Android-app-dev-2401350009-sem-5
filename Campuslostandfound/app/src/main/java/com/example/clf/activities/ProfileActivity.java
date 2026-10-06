package com.example.clf.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.clf.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        findViewById(R.id.tvMyPosts).setOnClickListener(v -> startActivity(new Intent(this, MyPostsActivity.class)));
        findViewById(R.id.tvSavedItems).setOnClickListener(v -> startActivity(new Intent(this, SavedItemsActivity.class)));
        findViewById(R.id.tvNotifications).setOnClickListener(v -> startActivity(new Intent(this, NotificationsActivity.class)));
        findViewById(R.id.tvHelpSupport).setOnClickListener(v -> startActivity(new Intent(this, HelpSupportActivity.class)));
        findViewById(R.id.tvLogout).setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.nav_profile);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(this, com.example.clf.MainActivity.class));
                return true;
            } else if (id == R.id.nav_post) {
                startActivity(new Intent(this, PostItemActivity.class));
                return true;
            } else if (id == R.id.nav_search) {
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            } else if (id == R.id.nav_profile) {
                return true;
            }
            return false;
        });
    }
}