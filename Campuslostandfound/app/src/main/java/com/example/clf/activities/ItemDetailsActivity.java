package com.example.clf.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.clf.R;
import com.example.clf.models.ItemModel;

public class ItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        TextView tvItemName = findViewById(R.id.tvItemName);
        TextView tvItemStatus = findViewById(R.id.tvItemStatus);
        TextView tvCategory = findViewById(R.id.tvCategory);
        TextView tvLocation = findViewById(R.id.tvLocation);
        TextView tvDate = findViewById(R.id.tvDate);
        TextView tvDescription = findViewById(R.id.tvDescription);

        ItemModel item = (ItemModel) getIntent().getSerializableExtra("item");

        if (item != null) {
            tvItemName.setText(item.getName());
            tvItemStatus.setText(item.getStatus());
            tvCategory.setText("Category: " + item.getCategory());
            tvLocation.setText(item.getLocation());
            tvDate.setText(item.getDate());
            tvDescription.setText(item.getDescription());

            if (item.getStatus().equalsIgnoreCase("Lost")) {
                tvItemStatus.setBackgroundColor(Color.parseColor("#E53935"));
            } else {
                tvItemStatus.setBackgroundColor(Color.parseColor("#43A047"));
            }
        }

        findViewById(R.id.btnContact).setOnClickListener(v -> 
            Toast.makeText(this, "Contacting Owner...", Toast.LENGTH_SHORT).show()
        );

        findViewById(R.id.btnShare).setOnClickListener(v -> 
            Toast.makeText(this, "Sharing Item...", Toast.LENGTH_SHORT).show()
        );
    }
}