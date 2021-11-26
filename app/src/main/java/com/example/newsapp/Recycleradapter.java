package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Recycleradapter extends RecyclerView.Adapter<Recycleradapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    public Recycleradapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,webView.class);
                intent.putExtra("url",modelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.published.setText("Published At:-" +modelClassArrayList.get(position).getPublishedAt());
        holder.author.setText(modelClassArrayList.get(position).getAuthor());
        holder.title.setText(modelClassArrayList.get(position).getTitle());
        holder.body.setText(modelClassArrayList.get(position).getDescription());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,body,author,mcategory,published;
        CardView cardview;
        ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title =(itemView).findViewById(R.id.heading);
            body = (itemView).findViewById(R.id.content);
            author= (itemView).findViewById(R.id.author);
            published= (itemView).findViewById(R.id.publish);
            cardview= (itemView).findViewById(R.id.cardview);
            image= (itemView).findViewById(R.id.image);

        }
    }
}


