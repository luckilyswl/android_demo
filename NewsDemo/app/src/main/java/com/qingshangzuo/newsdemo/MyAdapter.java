package com.qingshangzuo.newsdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private NewsData newsData;
    private Context context;

    public MyAdapter(Context context, NewsData newsData) {
        this.context = context;
        this.newsData = newsData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_list_item, parent,
                false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final NewsData.ResultBean.DataBean dataBean = newsData.getResult().getData().get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent();
                intent.setClass(context, NewsViewActivity.class);
                intent.putExtra("NEWS_URL", dataBean.getUrl());
                context.startActivity(intent);
            }
        });
        holder.tvTitle.setText(dataBean.getTitle());
        holder.tvAuthor.setText(dataBean.getAuthor_name());
        holder.tvTime.setText(dataBean.getDate());
        Glide.with(context).load(Uri.parse(dataBean.getThumbnail_pic_s())).into(holder.newsHeadImg);

    }

    @Override
    public int getItemCount() {
        if(newsData == null){
            return 0;
        }

        if(newsData.getResult() == null){
            return 0;
        }

        if(newsData.getResult().getData() == null){
            return 0;
        }

        int count = newsData.getResult().getData().size();

        Log.e("MyAdapter", "count = " + count);

        return count;
    }

    public void changData(NewsData newsData) {
        Log.e("MyAdapter", "changData");
        this.newsData = newsData;
        notifyDataSetChanged();
    }
}

