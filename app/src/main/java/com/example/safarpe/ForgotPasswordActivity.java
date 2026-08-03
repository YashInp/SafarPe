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

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText etEmail = findViewById(R.id.Email);
        Button btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            if(email.isEmpty()){
                etEmail.setError("Enter your email");
            } else {
                Toast.makeText(this, "Reset link sent to " + email, Toast.LENGTH_SHORT).show();
            }
        });
    }
}