package com.example.newtrainigproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.newtrainigproject.database.TableAddItem;
import com.example.newtrainigproject.model.AddItemModel;

public class ActivityAddItem extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] states={"Kerala","karnataka","Tamilnadu","Jammu & kashmir"};
    EditText etDistrict,etPinCode;
    Button btEnter;
    Spinner spState;
    Context context;
    String spinnerValue="";
    Button btBack;
    TableAddItem mTableAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        context=this;
        mTableAddItem =new TableAddItem(context);
        etDistrict=findViewById(R.id.etDistrict);
        etPinCode=findViewById(R.id.etPinCode);
        btEnter=findViewById(R.id.btEnter);
        btBack=findViewById(R.id.btBack);
        spState=findViewById(R.id.spState);
        spState.setOnItemSelectedListener(this);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(context,android.R.layout.simple_spinner_item,states);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spState.setAdapter(arrayAdapter);
        btEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCheck();

            }
        });
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,HomePageActivity.class));
            }
        });

    }

    private void itemClear() {
        etDistrict.setText("");
        etPinCode.setText("");
    }

    private void itemCheck() {
        if(etDistrict.getText().toString().equals("")){
            etDistrict.setError("Enter the District Name");
        }else if (etPinCode.getText().toString().equals("")){
            etPinCode.setError("Enter the Pin Code");
        }else{
            Toast.makeText(context,"Item Entered",Toast.LENGTH_SHORT).show();
            itemAdd();
            itemClear();
        }
    }

    private void itemAdd() {
        AddItemModel mAddItemModel= new AddItemModel();
        mAddItemModel.setDistrict(etDistrict.getText().toString().trim());
        mAddItemModel.setPinCode(etPinCode.getText().toString());
        mAddItemModel.setState(spinnerValue);
        mTableAddItem.insertIntoItem(mAddItemModel);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(context,states[i]+"Selected",Toast.LENGTH_LONG).show();
spinnerValue=states[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}