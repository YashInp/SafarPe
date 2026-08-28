package com.example.safarpe;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ViewBookingActivity extends AppCompatActivity {
ListView listBookings;
DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listBookings = findViewById(R.id.listBookings);
        dbHelper = new DatabaseHelper(ViewBookingActivity.this);

        Cursor cursor = dbHelper.getAllBookings();
        ArrayList<String> bookings = new ArrayList<>();

        if (cursor.moveToFirst()){
            do{
                String origin = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_BOOKING_ORIGIN));
                String destination = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_BOOKING_DESTINATION));
                String fare = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_BOOKING_FARE));

                bookings.add("Origin: "+origin+" -> Destination: "+destination+" |Fare: "+fare);

            }while(cursor.moveToNext());
        }
        cursor.close();

        if(bookings.isEmpty()){
            Toast.makeText(this, "No bookings yet", Toast.LENGTH_SHORT).show();
        }else {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookings);
            listBookings.setAdapter(adapter);
        }
    }
}