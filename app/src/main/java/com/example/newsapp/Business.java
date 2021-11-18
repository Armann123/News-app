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

public class Business extends Fragment {
    String api = "2e81c3e3af3144b9984262ce39199968";
    ArrayList<ModelClass> modelClassArrayList;
    Recycleradapter adapter;
    String country = "in";
    private RecyclerView businessrec;
    private String category ="business";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.businessclass,null);
        businessrec =v.findViewById(R.id.businessrec);
        modelClassArrayList=new ArrayList<>();
        businessrec.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Recycleradapter(getContext(),modelClassArrayList);
        businessrec.setAdapter(adapter);


        showNews();



        return v;
    }

    private void showNews() {
        ApiUtilities.getInterface().getCategoryNews(country,100,category,api).enqueue(new Callback<NewsVariables>() {
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
