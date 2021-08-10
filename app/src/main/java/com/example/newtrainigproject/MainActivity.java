package com.example.newtrainigproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtrainigproject.database.DbLoginRegister;
import com.example.newtrainigproject.model.LoginRegistrationModel;

public class MainActivity extends AppCompatActivity {
    EditText etUser;
    EditText etPassword;
    Button btSubmit;
    TextView tvNewRegistration;
    DbLoginRegister dbLoginRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initItems();
        dbLoginRegister=new DbLoginRegister(this);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkdata()){
                    LoginRegistrationModel mLoginRegistrationModel= dbLoginRegister.checkRegistration(etUser.getText().toString().trim(),etPassword.getText().toString().trim());
                    if(mLoginRegistrationModel.getName() != null){
                        Toast t = Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_LONG);
                        t.show();
                        startActivity(new Intent(MainActivity.this,HomePage.class));
                    }
                }
            }
        });
        tvNewRegistration.setOnClickListener(view -> {
            startActivity(new Intent(this,RegistrationActivity.class));
        });

    }

    private void initItems() {
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        btSubmit = findViewById(R.id.btSubmit);
        tvNewRegistration=findViewById(R.id.tvNewRegistration);

    }

    private boolean checkdata() {
        boolean valid=false;
        if (etUser == null || etUser.getText().toString().trim().equals("") || etUser.getText().toString().length() < 3) {
            Toast t = Toast.makeText(this, "Enter a valid User Name", Toast.LENGTH_LONG);
            t.show();
        } else if (etPassword == null || etPassword.getText().toString().trim().equals("") || etPassword.getText().toString().length() < 6) {
            Toast t = Toast.makeText(this, "Enter a valid Password", Toast.LENGTH_LONG);
            t.show();
        } else {
            Toast t = Toast.makeText(this, "validation success", Toast.LENGTH_LONG);
            t.show();
            valid=true;

        }
        return valid;

    }
}