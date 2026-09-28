package com.example.student_study_planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProgressActivity extends AppCompatActivity {
    // UI References
    private Toolbar toolbar;
    private TextView tvTaskName, tvSubject, tvPriority;
    private Button btnViewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        // Bind Java variables to XML layouts
        toolbar = findViewById(R.id.toolbar);
        tvTaskName = findViewById(R.id.tvTaskName);
        tvSubject = findViewById(R.id.tvSubject);
        tvPriority = findViewById(R.id.tvPriority);
        btnViewDetails = findViewById(R.id.btnViewDetails);

        // Setup custom Toolbar
        setSupportActionBar(toolbar);
        // The back arrow on the toolbar closes this screen and goes back
        toolbar.setNavigationOnClickListener(v -> finish());

        // --- Intent Extras & Null Safety ---
        // getIntent() retrieves the explicit intent that was fired by AddTaskActivity
        Intent intent = getIntent();
        
        // getStringExtra() retrieves the specific strings we packaged in putExtra()
        String task = intent.getStringExtra("task");
        String subject = intent.getStringExtra("subject");
        String priority = intent.getStringExtra("priority");

        // Null safety check: If a user opens Progress directly from the Home Screen menu, 
        // the intent will NOT have these extras. We must handle this gracefully.
        if (task == null || task.isEmpty()) {
            tvTaskName.setText(getString(R.string.msg_no_task));
            tvSubject.setText(String.format(getString(R.string.label_subject), getString(R.string.fallback_subject)));
            tvPriority.setText(String.format(getString(R.string.label_priority), getString(R.string.fallback_priority)));
        } else {
            tvTaskName.setText(task);
            // We use String.format to insert the intent data into our localized strings
            tvSubject.setText(String.format(getString(R.string.label_subject), subject));
            tvPriority.setText(String.format(getString(R.string.label_priority), priority));
        }

        // --- View Details Button ---
        btnViewDetails.setOnClickListener(v -> Toast.makeText(ProgressActivity.this, "Feature coming soon", Toast.LENGTH_SHORT).show());
    }

    // --- Options Menu Methods ---
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_my_progress) {
            return true; // We are already here!
        } else if (id == R.id.menu_home) {
            startActivity(new Intent(this, HomeActivity.class));
            return true;
        } else if (id == R.id.menu_add_task) {
            startActivity(new Intent(this, AddTaskActivity.class));
            return true;
        } else if (id == R.id.menu_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (id == R.id.menu_about) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.about_dialog_title)
                    .setMessage(R.string.about_dialog_message)
                    .setPositiveButton(R.string.ok, null)
                    .show();
            return true;
        } else if (id == R.id.menu_exit) {
            finishAffinity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}