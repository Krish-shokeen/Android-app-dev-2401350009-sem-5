package com.example.testproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

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
        CheckBox cbColdDrink = findViewById(R.id.cb_cold_drink);
        Button btnCalculate = findViewById(R.id.btn_calculate);
        TextView tvTotalBill = findViewById(R.id.tv_total_bill);

        btnCalculate.setOnClickListener(v -> {
            int total = 0;

            if (cbPizza.isChecked()) {
                total += 100;
            }
            if (cbBurger.isChecked()) {
                total += 80;
            }
            if (cbPasta.isChecked()) {
                total += 120;
            }
            if (cbColdDrink.isChecked()) {
                total += 50;
            }

            tvTotalBill.setText("Total Bill: ₹" + total);
        });
    }
}
