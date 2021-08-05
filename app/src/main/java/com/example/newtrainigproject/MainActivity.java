package com.example.newtrainigproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etUser;
    EditText etPassword;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initItems();
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkdata();
            }
        });

    }

    private void initItems() {
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        btSubmit = findViewById(R.id.btSubmit);

    }

    void checkdata() {

        if (etUser == null || etUser.getText().toString().trim().equals("") || etUser.getText().toString().length() < 3) {
            Toast t = Toast.makeText(this, "Enter a valid User Name", Toast.LENGTH_LONG);
            t.show();
        } else if (etPassword == null || etPassword.getText().toString().trim().equals("") || etPassword.getText().toString().length() < 6) {
            Toast t = Toast.makeText(this, "Enter a valid Password", Toast.LENGTH_LONG);
            t.show();
        } else {
            Toast t = Toast.makeText(this, "validation success", Toast.LENGTH_LONG);
            t.show();

        }

    }
}