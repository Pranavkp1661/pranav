package com.example.newtrainigproject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtrainigproject.database.TableAddSpinnerValue;
import com.example.newtrainigproject.model.AddSpinnerValueModel;

public class ActivityAddSpinner extends AppCompatActivity {
    EditText etSpinnerValue;
    Button btEnterSpinner;
    Context context;
    TableAddSpinnerValue tableAddSpinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_spinner);
        context = this;
        etSpinnerValue = findViewById(R.id.etSpinnerValue);
        btEnterSpinner = findViewById((R.id.btEnterSpinner));
        tableAddSpinnerValue = new TableAddSpinnerValue(context);
        btEnterSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etSpinnerValue.getText().toString().trim().equals("")) {
                    etSpinnerValue.setError("Enter the valid data");
                } else {
                    Toast.makeText(context, "Value Entered", Toast.LENGTH_LONG).show();
                    enterSpinner();
                    clearSpinner();
                }
            }
        });
    }

    private void clearSpinner() {
        etSpinnerValue.setText("");
    }

    private void enterSpinner() {
        AddSpinnerValueModel addSpinnerValueModel = new AddSpinnerValueModel();
        addSpinnerValueModel.setSp_name(etSpinnerValue.getText().toString().trim());
        long l = tableAddSpinnerValue.insertIntoAddSpinnerValue(addSpinnerValueModel);
        Log.d("log", "insert " + l);
    }
}