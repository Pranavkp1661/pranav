package com.example.newtrainigproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.newtrainigproject.adapters.RvViewItemAdapter;
import com.example.newtrainigproject.database.TableAddItem;
import com.example.newtrainigproject.model.AddItemModel;

import java.util.ArrayList;
import java.util.List;

public class ViewItemActivity extends AppCompatActivity {
    RecyclerView rvViewItem;
    TableAddItem mTableAddItem;
    Context context;
    List<AddItemModel> addItemModelList=new ArrayList<>();
    RvViewItemAdapter rvViewItemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);
        context=this;
        rvViewItem=findViewById(R.id.rvViewItem);
        mTableAddItem=new TableAddItem(context);
        rvViewItemAdapter=new RvViewItemAdapter(context,addItemModelList);
        rvViewItem.setLayoutManager(new LinearLayoutManager(context));
        rvViewItem.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        rvViewItem.setAdapter(rvViewItemAdapter);
        addItemModelList=mTableAddItem.getViewItems();
        rvViewItemAdapter.updateView(addItemModelList);
    }
}