package com.example.yls.demoa;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yls on 2018/5/17.
 */

class MyViewHolder extends RecyclerView.ViewHolder{
    View itemView;
    ImageView newsHeadImg;
    TextView tvTitle;
    TextView tvAuthor;
    TextView tvTime;

    public MyViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        newsHeadImg = itemView.findViewById(R.id.iv_head);
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvAuthor = itemView.findViewById(R.id.tv_author);
        tvTime = itemView.findViewById(R.id.tv_time);

    }
}
