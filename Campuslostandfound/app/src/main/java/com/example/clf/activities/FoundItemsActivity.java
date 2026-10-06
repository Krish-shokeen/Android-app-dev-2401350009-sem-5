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

public class FoundItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_items);

        RecyclerView rvFoundItems = findViewById(R.id.rvFoundItems);
        rvFoundItems.setLayoutManager(new LinearLayoutManager(this));

        List<ItemModel> sampleItems = new ArrayList<>();
        sampleItems.add(new ItemModel("2", "Water Bottle", "Found", "Accessories", "Cafeteria", "Yesterday, 2:00 PM", "Milton water bottle, silver color."));

        ItemAdapter adapter = new ItemAdapter(this, sampleItems);
        rvFoundItems.setAdapter(adapter);
    }
}