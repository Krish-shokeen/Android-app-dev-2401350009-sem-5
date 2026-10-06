package com.example.clf.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clf.R;
import com.example.clf.adapters.ItemAdapter;
import com.example.clf.models.ItemModel;
import java.util.ArrayList;
import java.util.List;

public class LostItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_items);

        RecyclerView rvLostItems = findViewById(R.id.rvLostItems);
        rvLostItems.setLayoutManager(new LinearLayoutManager(this));

        List<ItemModel> sampleItems = new ArrayList<>();
        sampleItems.add(new ItemModel("1", "Apple AirPods", "Lost", "Electronics", "Library 2nd Floor", "Today, 10:00 AM", "White color with a blue case."));
        sampleItems.add(new ItemModel("3", "Calculus Textbook", "Lost", "Books", "Room 401", "Oct 4, 11:30 AM", "Thomas Calculus 14th edition."));

        ItemAdapter adapter = new ItemAdapter(this, sampleItems);
        rvLostItems.setAdapter(adapter);
    }
}