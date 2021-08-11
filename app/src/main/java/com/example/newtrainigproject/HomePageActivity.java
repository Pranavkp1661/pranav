package com.example.newtrainigproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Adapter;

import com.example.newtrainigproject.adapters.RvUserAdapter;
import com.example.newtrainigproject.database.DbLoginRegister;
import com.example.newtrainigproject.model.LoginRegistrationModel;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    RecyclerView rvUserLayout;
    DbLoginRegister mDbLoginRegister;
    Context context;
    List<LoginRegistrationModel> loginRegistrationModelList = new ArrayList<>();
    RvUserAdapter rvUserAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_home_page);
        rvUserLayout=findViewById(R.id.rvUserLayout);
        mDbLoginRegister=new DbLoginRegister(context);
        rvUserAdapter=new RvUserAdapter(context,loginRegistrationModelList);
        rvUserLayout.setLayoutManager(new LinearLayoutManager(context));
        rvUserLayout.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        rvUserLayout.setAdapter(rvUserAdapter);
        loginRegistrationModelList=mDbLoginRegister.getAllUser();
        rvUserAdapter.upDateAdapter(loginRegistrationModelList);
    }
}