package com.example.student_study_planner;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity {

    private ImageView ivBack;
    private EditText etTaskName, etTaskDesc;
    private RadioGroup rgSubject;
    private CheckBox cbImportant, cbPractice, cbAssignment;
    private TextView tvDate, tvTime;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the Add Task XML layout
        setContentView(R.layout.activity_add_task);

        // Bind Java variables to XML components using findViewById
        ivBack = findViewById(R.id.ivBack);
        etTaskName = findViewById(R.id.etTaskName);
        etTaskDesc = findViewById(R.id.etTaskDesc);
        rgSubject = findViewById(R.id.rgSubject);
        cbImportant = findViewById(R.id.cbImportant);
        cbPractice = findViewById(R.id.cbPractice);
        cbAssignment = findViewById(R.id.cbAssignment);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        btnSave = findViewById(R.id.btnSave);

        // --- Back Arrow Click Listener ---
        // Returns the user to the previous screen (HomeActivity) by closing this Activity
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); 
            }
        });

        // --- Date Picker Click Listener ---
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddTaskActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // Formatting date as DD/MM/YYYY
                                String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                tvDate.setText(selectedDate);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        // --- Time Picker Click Listener ---
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(AddTaskActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                // Simple AM/PM logic
                                String amPm = (hourOfDay >= 12) ? "PM" : "AM";
                                int displayHour = (hourOfDay > 12) ? hourOfDay - 12 : (hourOfDay == 0 ? 12 : hourOfDay);
                                String timeFormat = String.format(Locale.getDefault(), "%02d:%02d %s", displayHour, minute, amPm);
                                tvTime.setText(timeFormat);
                            }
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });

        // --- Save Button Click Listener ---
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Step 1: Read the EditText inputs
                String task = etTaskName.getText().toString().trim();
                String desc = etTaskDesc.getText().toString().trim();

                // Step 4: Validate - If task name is empty, don't proceed
                if (task.isEmpty()) {
                    Toast.makeText(AddTaskActivity.this, getString(R.string.err_task_empty), Toast.LENGTH_SHORT).show();
                    return; // exit the onClick early
                }

                // Step 2: Check which RadioButton is selected in the RadioGroup
                int selectedSubjectId = rgSubject.getCheckedRadioButtonId();
                String subject = "None"; // default value
                if (selectedSubjectId != -1) {
                    // Find the selected RadioButton by its ID
                    RadioButton selectedRb = findViewById(selectedSubjectId);
                    subject = selectedRb.getText().toString();
                }

                // Step 3: Check which CheckBoxes are selected (build a CSV string)
                StringBuilder priorityBuilder = new StringBuilder();
                if (cbImportant.isChecked()) {
                    priorityBuilder.append(cbImportant.getText().toString()).append(", ");
                }
                if (cbPractice.isChecked()) {
                    priorityBuilder.append(cbPractice.getText().toString()).append(", ");
                }
                if (cbAssignment.isChecked()) {
                    priorityBuilder.append(cbAssignment.getText().toString()).append(", ");
                }

                String priorityTags = priorityBuilder.toString();
                // Clean up the trailing comma and space if it exists
                if (priorityTags.endsWith(", ")) {
                    priorityTags = priorityTags.substring(0, priorityTags.length() - 2);
                }
                if (priorityTags.isEmpty()) {
                    priorityTags = "Normal";
                }

                String date = tvDate.getText().toString();
                String time = tvTime.getText().toString();

                // Step 5: Show Success Toast
                Toast.makeText(AddTaskActivity.this, getString(R.string.msg_task_saved), Toast.LENGTH_SHORT).show();

                // Step 6: Create explicit Intent to ProgressActivity and pass data
                Intent intent = new Intent(AddTaskActivity.this, ProgressActivity.class);
                // putExtra adds the data to the intent so the next activity can retrieve it
                intent.putExtra("task", task);
                intent.putExtra("desc", desc);
                intent.putExtra("subject", subject);
                intent.putExtra("priority", priorityTags);
                intent.putExtra("date", date);
                intent.putExtra("time", time);

                startActivity(intent);
                finish(); // Optionally finish this activity so user can't go back to the half-filled form
            }
        });
    }
}