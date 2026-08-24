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

public class SendParcelActivity extends AppCompatActivity {
EditText etParcelDetails,etDeliveryAddress;
Button btnSendParcel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_parcel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etParcelDetails = findViewById(R.id.etParcelDetails);
        etDeliveryAddress = findViewById(R.id.etParcelDetails);
        btnSendParcel = findViewById(R.id.btnSendParcel);

        btnSendParcel.setOnClickListener(v -> {
            String ParcelDetail = etParcelDetails.getText().toString().trim();
            String DeliveryAddress = etDeliveryAddress.getText().toString().trim();
            
            if(ParcelDetail.isEmpty() || DeliveryAddress.isEmpty()){
                Toast.makeText(this, "Please enter ParcelDetail and Delvery Address", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Parcel : " + ParcelDetail + " → " + DeliveryAddress, Toast.LENGTH_SHORT).show();
            }
        });
    }
}