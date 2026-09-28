package com.example.student_study_planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CardView cardAddTask, cardViewProgress, cardTodaysTasks, cardSettings;
    private FloatingActionButton fabAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        cardAddTask = findViewById(R.id.cardAddTask);
        cardViewProgress = findViewById(R.id.cardViewProgress);
        cardTodaysTasks = findViewById(R.id.cardTodaysTasks);
        cardSettings = findViewById(R.id.cardSettings);
        fabAddTask = findViewById(R.id.fabAddTask);

        // Setup custom Toolbar
        setSupportActionBar(toolbar);
        
        // Handle navigation icon click (Hamburger menu)
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Navigation Menu Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set Click Listeners for the Navigation Cards
        cardAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddTaskActivity.class));
            }
        });

        cardViewProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ProgressActivity.class));
            }
        });

        cardTodaysTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, TodaysTasksActivity.class));
            }
        });

        cardSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
            }
        });

        // FAB Click to open Add Task
        fabAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddTaskActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the 3-dot overflow menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_home) {
            return true;
        } else if (id == R.id.menu_add_task) {
            startActivity(new Intent(this, AddTaskActivity.class));
            return true;
        } else if (id == R.id.menu_my_progress) {
            startActivity(new Intent(this, ProgressActivity.class));
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