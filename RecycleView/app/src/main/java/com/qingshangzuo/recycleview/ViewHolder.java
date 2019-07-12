package com.qingshangzuo.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView stuImage;
    TextView stuName;
    View stuView;
    ImageView stuDel;

    public ViewHolder(View view) {
        super(view);
        stuImage = view.findViewById(R.id.stu_image);
        stuName = view.findViewById(R.id.stu_name);
        stuView = view;
        stuDel = view.findViewById(R.id.stu_del);

    }
}
