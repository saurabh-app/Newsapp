package com.example.newsapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.R;
import com.example.newsapp.adapter.NewsListAdapter;
import com.example.newsapp.model.MasterResponceModel;
import com.example.newsapp.model.Source;
import com.example.newsapp.network.APIInterface;
import com.example.newsapp.network.RetroInstance;

import java.util.ArrayList;
import java.util.List;


public class SportsFragment extends Fragment {

    private List<Source> sourcesmodel =new ArrayList<>();
    APIInterface apiInterface;
    private RecyclerView sport_recycleview;
    private NewsListAdapter newsListAdapter;
    private String  category="sports";
    private String apiKey="3f76b64497ef4a4aaaa31afa6e6eda8d";


    public SportsFragment(List<Source> sourcesmodels) {
        this.sourcesmodel=sourcesmodels;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_sports, container, false);
        View view = inflater.inflate(R.layout.fragment_sports, null);
        apiInterface = RetroInstance.getRetroClient().create(APIInterface.class);
        sport_recycleview = view.findViewById(R.id.sport_recycleview);
        sport_recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        newsListAdapter =new NewsListAdapter(getContext() ,sourcesmodel);
        sport_recycleview.setAdapter(newsListAdapter);
        getSportnews();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void getSportnews() {
        apiInterface = RetroInstance.getRetroClient().create(APIInterface.class);
        Call<MasterResponceModel> call = apiInterface.doGetListResources(category,apiKey,"");

        call.enqueue(new Callback<MasterResponceModel>() {
            @Override
            public void onResponse(Call<MasterResponceModel> call, Response<MasterResponceModel> response) {
                Log.d("TAG",response.code()+"");
//                Toast.makeText(ApiActivity.this, "ddf"+response.body().getSources().toString(), Toast.LENGTH_LONG).show();
                String status=  response.body().getStatus();
                Log.d("hbgjh","ffdf"+  "      "  + status);
                if (status.equals("ok")){
                    MasterResponceModel masterResponceModel= response.body();
                    sourcesmodel=  masterResponceModel.getSources();
                    newsListAdapter =new NewsListAdapter(getContext(),sourcesmodel);
                    sport_recycleview.setAdapter(newsListAdapter);

                }

            }

            @Override
            public void onFailure(Call<MasterResponceModel> call, Throwable t) {

            }
        });

    }
}