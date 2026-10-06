package com.example.clf.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clf.R;
import com.example.clf.adapters.ItemAdapter;
import com.example.clf.models.ItemModel;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private ItemAdapter adapter;
    private List<ItemModel> sampleItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        RecyclerView rvSearchItems = findViewById(R.id.rvSearchItems);
        rvSearchItems.setLayoutManager(new LinearLayoutManager(this));

        sampleItems = new ArrayList<>();
        sampleItems.add(new ItemModel("1", "Apple AirPods", "Lost", "Electronics", "Library", "Today", "White color"));
        sampleItems.add(new ItemModel("2", "Water Bottle", "Found", "Accessories", "Cafeteria", "Yesterday", "Milton bottle"));
        sampleItems.add(new ItemModel("3", "Calculus Textbook", "Lost", "Books", "Room 401", "Oct 4", "14th edition."));

        adapter = new ItemAdapter(this, sampleItems);
        rvSearchItems.setAdapter(adapter);

        EditText etSearch = findViewById(R.id.etSearch);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filter(String text) {
        List<ItemModel> filteredList = new ArrayList<>();
        for (ItemModel item : sampleItems) {
            if (item.getName().toLowerCase().contains(text.toLowerCase()) || 
                item.getCategory().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.updateList(filteredList);
    }
}