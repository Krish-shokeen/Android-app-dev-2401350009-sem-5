package com.example.clf;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clf.activities.*;
import com.example.clf.adapters.ItemAdapter;
import com.example.clf.models.ItemModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvRecentPosts;
    private ItemAdapter adapter;
    private List<ItemModel> sampleItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRecentPosts = findViewById(R.id.rvRecentPosts);
        rvRecentPosts.setLayoutManager(new LinearLayoutManager(this));

        sampleItems = new ArrayList<>();
        sampleItems.add(new ItemModel("1", "Apple AirPods", "Lost", "Electronics", "Library 2nd Floor", "Today, 10:00 AM", "White color with a blue case."));
        sampleItems.add(new ItemModel("2", "Water Bottle", "Found", "Accessories", "Cafeteria", "Yesterday, 2:00 PM", "Milton water bottle, silver color."));
        sampleItems.add(new ItemModel("3", "Calculus Textbook", "Lost", "Books", "Room 401", "Oct 4, 11:30 AM", "Thomas Calculus 14th edition."));

        adapter = new ItemAdapter(this, sampleItems);
        rvRecentPosts.setAdapter(adapter);

        Button btnReportLost = findViewById(R.id.btnReportLost);
        btnReportLost.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PostItemActivity.class)));

        MaterialCardView cardLostItems = findViewById(R.id.cardLostItems);
        cardLostItems.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LostItemsActivity.class)));

        MaterialCardView cardFoundItems = findViewById(R.id.cardFoundItems);
        cardFoundItems.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FoundItemsActivity.class)));

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setSelectedItemId(R.id.nav_home);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                return true;
            } else if (id == R.id.nav_post) {
                startActivity(new Intent(MainActivity.this, PostItemActivity.class));
                return true;
            } else if (id == R.id.nav_search) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                return true;
            }
            return false;
        });
    }
}