package com.example.safarpe;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BookingActivity extends AppCompatActivity {
Button btnBookRide;
EditText Pickup,Drop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Pickup = findViewById(R.id.Pickup);
        Drop = findViewById(R.id.Drop);
        btnBookRide = findViewById(R.id.btnBookRide);

        btnBookRide.setOnClickListener(v -> {
            String pickup = Pickup.getText().toString().trim();
            String drop = Drop.getText().toString().trim();

            if (pickup.isEmpty() || drop.isEmpty()) {
                Toast.makeText(this, "Please enter pickup and drop", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Ride booked: " + pickup + " → " + drop, Toast.LENGTH_SHORT).show();
            }
        });

    }
}