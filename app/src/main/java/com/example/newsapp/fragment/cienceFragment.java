package com.example.newsapp.fragment;

import android.os.Bundle;

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


public class cienceFragment extends Fragment {

    private RecyclerView sciencerecycleview;
    private List<Source> sourcesmodel =new ArrayList<>();
    APIInterface apiInterface;
    private NewsListAdapter newsListAdapter;

    private String  category="science";
    private String apiKey="3f76b64497ef4a4aaaa31afa6e6eda8d";
    private String country="us";
    public cienceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cience, null);

        sciencerecycleview = view.findViewById(R.id.sciencerecycleview);
        sciencerecycleview.setLayoutManager(new LinearLayoutManager(getContext()));

        apiInterface = RetroInstance.getRetroClient().create(APIInterface.class);
        newsListAdapter = new NewsListAdapter(getContext(), sourcesmodel);
        getSportnews();
        return view;
    }


        private void getSportnews() {
            apiInterface = RetroInstance.getRetroClient().create(APIInterface.class);
            Call<MasterResponceModel> call = apiInterface.doGetListResources(category, apiKey, country);

            call.enqueue(new Callback<MasterResponceModel>() {
                @Override
                public void onResponse(Call<MasterResponceModel> call, Response<MasterResponceModel> response) {
                    Log.d("TAG", response.code() + "");
                    String status = response.body().getStatus();
                    if (status.equals("ok")) {
                        MasterResponceModel masterResponceModel = response.body();
                        sourcesmodel = masterResponceModel.getSources();
                        newsListAdapter = new NewsListAdapter(getContext(), sourcesmodel);
                        sciencerecycleview.setAdapter(newsListAdapter);

                    }

                }

                @Override
                public void onFailure(Call<MasterResponceModel> call, Throwable t) {

                }
            });
        }}