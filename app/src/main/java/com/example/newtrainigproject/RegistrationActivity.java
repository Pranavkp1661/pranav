package com.example.newtrainigproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPass;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etAddress;
    private EditText etDob;
    private EditText etAge;
    private Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
        btRegister.setOnClickListener(view -> {
            if (etName.getText().toString().trim().equals("")) {
                etName.setError("Enter valid Name");
            }
            if (etPass.getText().toString().trim().equals("") || etPass.getText().toString().length() > 6) {
                etPass.setError("Enter valid password");
            }
            if (etEmail.getText().toString().trim().equals("")) {
                etEmail.setError("Enter valid Email");
            }
            if (etPhone.getText().toString().trim().equals("")) {
                etPhone.setError("Enter valid Phone Number");
            }

        });


    }

    private void init() {
        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        etDob = findViewById(R.id.etDob);
        etAge = findViewById(R.id.etAge);
        btRegister = findViewById(R.id.btRegister);
    }
}