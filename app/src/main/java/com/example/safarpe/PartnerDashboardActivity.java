package com.example.safarpe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PartnerDashboardActivity extends AppCompatActivity {
Button btnBookRide,btnSendParcel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_partner_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnBookRide = findViewById(R.id.btnBookRide);
        btnSendParcel = findViewById(R.id.btnSendParcel);

        btnBookRide.setOnClickListener(v -> {
            Intent intent = new Intent(PartnerDashboardActivity.this, BookingActivity.class);
            startActivity(intent);
        });

        btnSendParcel.setOnClickListener(v -> {
            Intent intent = new Intent(PartnerDashboardActivity.this, SendParcelActivity.class);
            startActivity(intent);
        });
        }
    }
