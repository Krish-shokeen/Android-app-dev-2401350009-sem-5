package com.example.clf.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clf.R;
import com.example.clf.adapters.NotificationAdapter;
import com.example.clf.models.NotificationModel;
import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        RecyclerView rvNotifications = findViewById(R.id.rvNotifications);
        rvNotifications.setLayoutManager(new LinearLayoutManager(this));

        List<NotificationModel> sampleNotifs = new ArrayList<>();
        sampleNotifs.add(new NotificationModel("Item Match!", "An item matching your 'Apple AirPods' was found.", "10 mins ago"));
        sampleNotifs.add(new NotificationModel("New Found Item", "A 'Calculus Textbook' was found near you.", "2 hours ago"));

        NotificationAdapter adapter = new NotificationAdapter(this, sampleNotifs);
        rvNotifications.setAdapter(adapter);
    }
}