package com.example.testproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FoodOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CheckBox cbPizza = findViewById(R.id.cb_pizza);
        CheckBox cbBurger = findViewById(R.id.cb_burger);
        CheckBox cbPasta = findViewById(R.id.cb_pasta);
        CheckBox cbCoffee = findViewById(R.id.cb_coffee);
        Button btnOrder = findViewById(R.id.btn_order);

        btnOrder.setOnClickListener(v -> {
            int total = 0;
            StringBuilder result = new StringBuilder("Selected Items:\n");

            if (cbPizza.isChecked()) {
                total += 10;
                result.append("Pizza: $10\n");
            }
            if (cbBurger.isChecked()) {
                total += 5;
                result.append("Burger: $5\n");
            }
            if (cbPasta.isChecked()) {
                total += 8;
                result.append("Pasta: $8\n");
            }
            if (cbCoffee.isChecked()) {
                total += 3;
                result.append("Coffee: $3\n");
            }

            result.append("\nTotal: $").append(total);
            Toast.makeText(FoodOrderActivity.this, result.toString(), Toast.LENGTH_LONG).show();
        });
    }
}
