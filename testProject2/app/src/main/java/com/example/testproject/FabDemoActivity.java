package com.example.testproject;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FabDemoActivity extends AppCompatActivity {

    private TextView tvNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_demo);

        tvNotes = findViewById(R.id.tv_notes);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(v -> {
            // Create an AlertDialog to allow the user to type a note
            AlertDialog.Builder builder = new AlertDialog.Builder(FabDemoActivity.this);
            builder.setTitle("Add a New Note");

            // Set up an EditText for user input
            final EditText input = new EditText(FabDemoActivity.this);
            input.setHint("Type your note here...");
            
            // Add some padding to the input field
            int padding = (int) (16 * getResources().getDisplayMetrics().density);
            input.setPadding(padding, padding, padding, padding);
            
            builder.setView(input);

            // Set up the OK and Cancel buttons
            builder.setPositiveButton("Add", (dialog, which) -> {
                String note = input.getText().toString().trim();
                if (!note.isEmpty()) {
                    // Append the new note to the TextView
                    String currentNotes = tvNotes.getText().toString();
                    tvNotes.setText(currentNotes + "\n• " + note);
                } else {
                    Toast.makeText(FabDemoActivity.this, "Note cannot be empty", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            // Show the popup dialog
            builder.show();
        });
    }
}
