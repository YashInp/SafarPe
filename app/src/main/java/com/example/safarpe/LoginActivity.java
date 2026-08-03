package com.example.safarpe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
Button btnlogin;
TextView Signup,ForgotPassword;
    EditText username, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnlogin = findViewById(R.id.btnlogin);
        Signup = findViewById(R.id.Signup);
        ForgotPassword = findViewById(R.id.ForgotPassword);
        username = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);

        btnlogin.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = passwordField.getText().toString();

            if (user.isEmpty() || pass.isEmpty()) {
                username.setError("Enter Username");
                passwordField.setError("Enter Password");
            } else {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ForgotPassword.setOnClickListener(v ->{
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
        Signup.setOnClickListener(v ->{
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });
    }
}


