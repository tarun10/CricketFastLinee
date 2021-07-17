package com.learning.cricketfastline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.learning.cricketfastline.model.news.Article;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    Context context;
    private ArrayList<Article> article;

    public NewsAdapter(Context context, ArrayList<Article> article) {
        this.context = context;
        this.article = article;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context).load(article.get(position).getUrlToImage()).error(R.drawable.logo_icon).into(holder.imageViewNews);
        holder.textViewTitle.setText(article.get(position).getTitle());
        holder.textViewMainNews.setText(article.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return article.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewNews;
        TextView textViewTitle, textViewMainNews, textViewTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewNews = itemView.findViewById(R.id.imageViewNews);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewMainNews = itemView.findViewById(R.id.textViewMainNews);
            textViewTime = itemView.findViewById(R.id.textViewTime);
        }
    }
}
