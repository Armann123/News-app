package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeClass extends Fragment {

    String api = "2e81c3e3af3144b9984262ce39199968";
    ArrayList<ModelClass> modelClassArrayList;
    Recycleradapter adapter;
    String country = "in";
    private RecyclerView homerecycler;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.homeclass,null);
        homerecycler =v.findViewById(R.id.home);
        modelClassArrayList=new ArrayList<>();
        homerecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Recycleradapter(getContext(),modelClassArrayList);
        homerecycler.setAdapter(adapter);


        showNews();



        return v;
    }

    private void showNews() {
        ApiUtilities.getInterface().getNews(country,100,api).enqueue(new Callback<NewsVariables>() {
            @Override
            public void onResponse(Call<NewsVariables> call, Response<NewsVariables> response) {
             if(response.isSuccessful()){
                 modelClassArrayList.addAll(response.body().getArticles());
                 adapter.notifyDataSetChanged();
             }
            }

            @Override
            public void onFailure(Call<NewsVariables> call, Throwable t) {

            }
        });

    }
}
