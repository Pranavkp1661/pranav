package com.example.newtrainigproject;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAddSpinner extends AppCompatActivity {
    EditText etSpinnerValue;
    Button btEnterSpinner;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_spinner);
        context = this;
        etSpinnerValue = findViewById(R.id.etSpinnerValue);
        btEnterSpinner = findViewById((R.id.btEnterSpinner));
        btEnterSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etSpinnerValue.getText().toString().trim().equals(""))
                {
                    etSpinnerValue.setError("Enter the valid data");
                }
                else {
                    Toast.makeText(context, "Value Entered", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}