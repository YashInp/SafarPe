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

public class PostRouteActivity extends AppCompatActivity {
Button btnPostRoute;
EditText Origin,Destination,Fare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post_route);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnPostRoute = findViewById(R.id.btnPostRoute);
        Origin = findViewById(R.id.Origin);
        Destination = findViewById(R.id.Destination);
        Fare = findViewById(R.id.Fare);

        DatabaseHelper dbHelper = new DatabaseHelper(PostRouteActivity.this);

        btnPostRoute.setOnClickListener(v -> {
            String origin = Origin.getText().toString().trim();
            String destination = Destination.getText().toString().trim();
            String fare = Fare.getText().toString().trim();

            if (origin.isEmpty() || destination.isEmpty() || fare.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                boolean inserted = dbHelper.insertRoute(origin,destination,fare);
                if(inserted){
                    Toast.makeText(this, "Route Saved successfully!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Failed to save route", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}