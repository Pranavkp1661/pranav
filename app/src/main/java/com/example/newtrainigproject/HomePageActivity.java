package com.example.newtrainigproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.newtrainigproject.adapters.UserRvAdapter;
import com.example.newtrainigproject.database.DbLoginRegister;
import com.example.newtrainigproject.model.LoginRegistrationModel;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
RecyclerView rvHomeItems;
DbLoginRegister mDbLoginRegister;
Context context;
UserRvAdapter adapter;
List<LoginRegistrationModel> loginRegistrationModelList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_home_page);
        rvHomeItems=findViewById(R.id.rvHomeItems);
        mDbLoginRegister=new DbLoginRegister(context);
        adapter=new UserRvAdapter(context,loginRegistrationModelList);
        rvHomeItems.setLayoutManager(new LinearLayoutManager(context));
        rvHomeItems.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        rvHomeItems.setAdapter(adapter);
        loginRegistrationModelList=mDbLoginRegister.getAllUsers();
        adapter.updateAdapter(loginRegistrationModelList);
    }
}