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

public class MyPostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_posts);

        RecyclerView rvMyPosts = findViewById(R.id.rvMyPosts);
        rvMyPosts.setLayoutManager(new LinearLayoutManager(this));

        List<ItemModel> sampleItems = new ArrayList<>();
        sampleItems.add(new ItemModel("1", "Apple AirPods", "Lost", "Electronics", "Library", "Today", "White color"));

        ItemAdapter adapter = new ItemAdapter(this, sampleItems);
        rvMyPosts.setAdapter(adapter);
    }
}