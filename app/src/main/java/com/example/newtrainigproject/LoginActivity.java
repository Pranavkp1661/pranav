package com.example.newtrainigproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.newtrainigproject.database.TableLoginRegister;
import com.example.newtrainigproject.model.LoginRegistrationModel;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText etUser;
    EditText etPassword;
    Button btSubmit;
    Button btLocation;
    TextView tvNewRegistration;
    TableLoginRegister tableLoginRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initItems();
        checkAndRequestPermissions();
        tableLoginRegister =new TableLoginRegister(this);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkdata()){
                    LoginRegistrationModel mLoginRegistrationModel= tableLoginRegister.checkRegistration(etUser.getText().toString().trim(),etPassword.getText().toString().trim());
                    if(mLoginRegistrationModel.getName() != null){
                        Toast t = Toast.makeText(LoginActivity.this, "login success", Toast.LENGTH_LONG);
                        t.show();
                        startActivity(new Intent(LoginActivity.this, HomePageActivity.class));
                    }
                }
            }
        });
        tvNewRegistration.setOnClickListener(view -> {
            startActivity(new Intent(this,RegistrationActivity.class));
        });
        btLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,LocationActivity.class));
            }
        });

    }

    private void initItems() {
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        btSubmit = findViewById(R.id.btSubmit);
        tvNewRegistration=findViewById(R.id.tvNewRegistration);
        btLocation=findViewById(R.id.btLocation);

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
    private void checkAndRequestPermissions() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> PERMISSIONS = new ArrayList<>();
            PERMISSIONS.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
            PERMISSIONS.add(Manifest.permission.ACCESS_FINE_LOCATION);
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                PERMISSIONS.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION);
            }
            List<String> listPermissionsNeeded = new ArrayList<>();
            for (String permission : PERMISSIONS) {
                if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    listPermissionsNeeded.add(permission);
                }
            }
            if (!listPermissionsNeeded.isEmpty()) {
                ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[0]), 1);
            }
        }
    }

}