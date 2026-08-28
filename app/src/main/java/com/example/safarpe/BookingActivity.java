package com.example.safarpe;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {
Button btnBookRide , btnViewBookings;
EditText Pickup,Drop;
ListView listRoutes;
DatabaseHelper dbHelper;
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
        btnViewBookings = findViewById(R.id.btViewBookings);
        listRoutes = findViewById(R.id.listRoutes);

        dbHelper = new DatabaseHelper(BookingActivity.this);

        btnBookRide.setOnClickListener(v -> {
            String pickup = Pickup.getText().toString().trim();
            String drop = Drop.getText().toString().trim();

            if (pickup.isEmpty() || drop.isEmpty()) {
                Toast.makeText(this, "Please enter pickup and drop", Toast.LENGTH_SHORT).show();
            } else {
                Cursor cursor = dbHelper.getAllRoutes();
                ArrayList<String> routes = new ArrayList<>();

                if(cursor.moveToFirst()){
                    do{
                        String origin = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ORIGIN));
                        String destination = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_DESTINATION));
                        String fare = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_FARE));

                        if(origin.equalsIgnoreCase(pickup) && destination.equalsIgnoreCase(drop)){
                            routes.add("Origin: "+origin+" -> Destination: "+destination+"|Fare: "+fare);
                        }
                    }while (cursor.moveToNext());
                }
                cursor.close();
                if(routes.isEmpty()){
                    Toast.makeText(this, "No routes found", Toast.LENGTH_SHORT).show();

                }else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, routes);
                         listRoutes.setAdapter(adapter);

                         listRoutes.setOnItemClickListener((parent, view, position, id) -> {
                             String selectedRoute = routes.get(position);
                             Toast.makeText(this, "Booked"+selectedRoute, Toast.LENGTH_SHORT).show();
                         });
                }
            }
        });
        btnViewBookings.setOnClickListener(v -> {
            Intent intent = new Intent(BookingActivity.this, ViewBookingActivity.class);
            startActivity(intent);
        });
    }
}