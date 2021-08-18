package com.example.newtrainigproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.newtrainigproject.adapters.RvUserAdapter;
import com.example.newtrainigproject.database.TableLoginRegister;
import com.example.newtrainigproject.model.LoginRegistrationModel;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    RecyclerView rvUserLayout;
    TableLoginRegister mTableLoginRegister;
    Context context;
    List<LoginRegistrationModel> loginRegistrationModelList = new ArrayList<>();
    RvUserAdapter rvUserAdapter;
    Button btAddData;
    Button btViewItem;
    Button btAddSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_home_page);
        btAddData=findViewById(R.id.btAddData);
        btViewItem=findViewById(R.id.btViewItem);
        btAddSpinner=findViewById(R.id.btAddSpinner);
        rvUserLayout=findViewById(R.id.rvUserLayout);
        mTableLoginRegister =new TableLoginRegister(context);
        rvUserAdapter=new RvUserAdapter(context,loginRegistrationModelList);
        rvUserLayout.setLayoutManager(new LinearLayoutManager(context));
        rvUserLayout.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        rvUserLayout.setAdapter(rvUserAdapter);
        loginRegistrationModelList= mTableLoginRegister.getAllUser();
        rvUserAdapter.upDateAdapter(loginRegistrationModelList);
        btAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, AddItemActivity.class));
            }
        });
        btViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ViewItemActivity.class));
            }
        });
        btAddSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, AddSpinnerActivity.class));
            }
        });
    }
}