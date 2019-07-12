package com.qingshangzuo.recyclerviewapplication.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qingshangzuo.recyclerviewapplication.R;

/**
 * Created by yls on 2017/11/1.
 */

public class StuViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivHead;
    private TextView tvName;
    private View view;

    public StuViewHolder(View itemView) {
        super(itemView);
        view = itemView;
        ivHead = (ImageView) itemView.findViewById(R.id.ivHead);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
    }

    public ImageView getIvHead() {
        return ivHead;
    }

    public TextView getTvName() {
        return tvName;
    }

    public View getView() {
        return view;
    }
}
