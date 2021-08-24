package com.example.newtrainigproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.newtrainigproject.adapters.RvRetrofitListAdapter;
import com.example.newtrainigproject.model.RetrofitListModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitListActivity extends AppCompatActivity {
    RecyclerView rvRetrofitList;
    RvRetrofitListAdapter rvRetrofitListAdapter;
    Context context;
    List<RetrofitListModel> retrofitListModelList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_retrofit_list);
        rvRetrofitList=findViewById(R.id.rvRetrofitList);
        rvRetrofitListAdapter=new RvRetrofitListAdapter(context,retrofitListModelList);
        rvRetrofitList.setLayoutManager(new LinearLayoutManager(context));
        rvRetrofitList.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));
        rvRetrofitList.setAdapter(rvRetrofitListAdapter);
        getSuperHero();

    }

    private void getSuperHero() {
        Call<List<RetrofitListModel>> call=RetrofitClientApi.getInstance().getMyApi().getSuperHero();
        call.enqueue(new Callback<List<RetrofitListModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<RetrofitListModel>> call, @NonNull Response<List<RetrofitListModel>> response) {
                rvRetrofitListAdapter.UpdateRetrofitList(response.body());
                Log.e( "onResponse: ", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<List<RetrofitListModel>> call, @NonNull Throwable t) {
                Toast.makeText(context,"Error",Toast.LENGTH_SHORT).show();
                t.printStackTrace();

            }
        });
    }
}