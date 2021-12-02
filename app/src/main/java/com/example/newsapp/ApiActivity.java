package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.newsapp.adapter.NewsListAdapter;
import com.example.newsapp.model.MasterResponceModel;
import com.example.newsapp.model.Source;
import com.example.newsapp.network.APIInterface;
import com.example.newsapp.network.RetroInstance;

import java.util.ArrayList;
import java.util.List;

public class ApiActivity extends AppCompatActivity {
    private List<Source> sourcesmodel =new ArrayList<>();
    APIInterface apiInterface;
    private RecyclerView sport_recycleview;
    private NewsListAdapter newsListAdapter;
    private String  category="sports";
    private String apiKey="3f76b64497ef4a4aaaa31afa6e6eda8d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        sport_recycleview = findViewById(R.id.sportrecycleview);
        sport_recycleview.setLayoutManager(new LinearLayoutManager(this));
        apiInterface = RetroInstance.getRetroClient().create(APIInterface.class);
        Call<MasterResponceModel> call = apiInterface.doGetListResources(category, category,apiKey);

        call.enqueue(new Callback<MasterResponceModel>() {
            @Override
            public void onResponse(Call<MasterResponceModel> call, Response<MasterResponceModel> response) {
                Log.d("TAG",response.code()+"");
                Toast.makeText(ApiActivity.this, "ddf"+response.body().getSources().toString(), Toast.LENGTH_LONG).show();
                String status=  response.body().getStatus();
                Log.d("hbgjh","ffdf"+  "      "  + status);
                if (status.equals("ok")){
                    MasterResponceModel masterResponceModel= response.body();
                    sourcesmodel=  masterResponceModel.getSources();
                    newsListAdapter =new NewsListAdapter(getApplicationContext(),sourcesmodel);
                    sport_recycleview.setAdapter(newsListAdapter);

                }

            }

            @Override
            public void onFailure(Call<MasterResponceModel> call, Throwable t) {

            }
        });

    }
}