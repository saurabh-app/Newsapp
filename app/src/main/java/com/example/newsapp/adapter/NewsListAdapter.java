package com.example.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.newsapp.R;
import com.example.newsapp.WebViewActivity;
import com.example.newsapp.fragment.SportsFragment;
import com.example.newsapp.model.Source;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyViewHolder> {
    private Context context;
    List<Source> sourcesmodels;

    public NewsListAdapter(Context mcontext, List<Source> sourcesmodel) {
        this.context=mcontext;
        this.sourcesmodels=sourcesmodel;
    }

    @NonNull
    @Override
    public NewsListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListAdapter.MyViewHolder holder, int position) {

        if (sourcesmodels!=null){
            holder.author.setText(sourcesmodels.get(position).getName());
            holder.content.setText(sourcesmodels.get(position).getCountry());
            holder.description.setText(sourcesmodels.get(position).getCategory());
            holder.maintitle.setText(sourcesmodels.get(position).getDescription());
            holder.card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i =new Intent(context, WebViewActivity.class);
                    i.putExtra("Url",sourcesmodels.get(position).getUrl());
                    context.startActivity(i);
                }
            });

           String url= sourcesmodels.get(position).getUrl();
//           if (url!=null) {
               if (sourcesmodels.get(position).getCategory().equals("health")){
                   Picasso.with(context)
                           .load(url)
                           .placeholder(R.drawable.bgg)
                           .resize(100, 100)
                           .centerCrop()
                           .into(holder.img);
               }else if (sourcesmodels.get(position).getCategory().equals("sports")){
                   Picasso.with(context)
                           .load(url)
                           .placeholder(R.drawable.bg)
                           .resize(100, 100)
                           .centerCrop()
                           .into(holder.img);
               }else if (sourcesmodels.get(position).getCategory().equals("business")){
                   Picasso.with(context)
                           .load("https://www.google.com/url?sa=i&url=https%3A%2F%2Fhelpx.adobe.com%2Fphotoshop%2Fusing%2Fconvert-color-image-black-white.html&psig=AOvVaw29ZYpdak3GYbBRSrCRHMdU&ust=1638194674529000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCICrie-cu_QCFQAAAAAdAAAAABAD")
                           .placeholder(R.drawable.bg).resize(100, 100)
                           .centerCrop()
                           .networkPolicy(NetworkPolicy.NO_CACHE)
//                           .memoryPolicy(MemoryPolicy.NO_CACHE)
//                           .memoryPolicy(MemoryPolicy.NO_STORE)
                           .into(holder.img);
               }else {
                   Picasso.with(context)
                           .load("https://www.google.com/url?sa=i&url=https%3A%2F%2Fhelpx.adobe.com%2Fphotoshop%2Fusing%2Fconvert-color-image-black-white.html&psig=AOvVaw29ZYpdak3GYbBRSrCRHMdU&ust=1638194674529000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCICrie-cu_QCFQAAAAAdAAAAABAD")
                           .placeholder(R.drawable.bg).resize(100, 100)
                           .centerCrop()
                           .networkPolicy(NetworkPolicy.NO_CACHE)
                           .memoryPolicy(MemoryPolicy.NO_CACHE)
                           .memoryPolicy(MemoryPolicy.NO_STORE)
                           .into(holder.img);
               }

        }else {
            Toast.makeText(context, "No Found Data !!", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public int getItemCount() {
        if(this.sourcesmodels != null) {
            return this.sourcesmodels.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

ImageView img;
TextView maintitle,content,author,description;

CardView card_view;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            card_view=(CardView)itemView.findViewById(R.id.card_view);
            maintitle=(TextView)itemView.findViewById(R.id.maintitle);
            content=(TextView)itemView.findViewById(R.id.content);
            author=(TextView)itemView.findViewById(R.id.author);
            description=(TextView)itemView.findViewById(R.id.description);
            img=(ImageView) itemView.findViewById(R.id.img);
        }
    }
}
