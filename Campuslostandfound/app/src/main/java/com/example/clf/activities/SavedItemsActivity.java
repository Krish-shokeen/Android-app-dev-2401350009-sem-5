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

public class SavedItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_items);

        RecyclerView rvSavedItems = findViewById(R.id.rvSavedItems);
        rvSavedItems.setLayoutManager(new LinearLayoutManager(this));

        List<ItemModel> sampleItems = new ArrayList<>();
        sampleItems.add(new ItemModel("2", "Water Bottle", "Found", "Accessories", "Cafeteria", "Yesterday", "Milton bottle"));

        ItemAdapter adapter = new ItemAdapter(this, sampleItems);
        rvSavedItems.setAdapter(adapter);
    }
}