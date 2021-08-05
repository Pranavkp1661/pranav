package com.example.newtrainigproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    EditText etName;
    EditText editPass;
    EditText etEmail;
    EditText etphNumber;
    EditText etAge;
    EditText etDob;
    CheckBox cbDrawing;
    CheckBox cbSinging;
    CheckBox cbDancing;
    CheckBox cbAgree;
    Button btSubmit;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName=findViewById(R.id.etName);
        editPass=findViewById(R.id.editPass);
        etEmail=findViewById(R.id.etEmail);
        etphNumber=findViewById(R.id.etPhNumber);
        etAge=findViewById(R.id.etAge);
        etDob=findViewById(R.id.etDob);
        cbDrawing=findViewById(R.id.cbDrawing);
        cbSinging=findViewById(R.id.cbSinging);
        cbDancing=findViewById(R.id.cbDancing);
        cbAgree=findViewById(R.id.cbAgree);
        btSubmit=findViewById(R.id.btSubmit);




    }
}