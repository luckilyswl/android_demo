package com.qingshangzuo.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StuAdapter extends BaseAdapter {
    private Student[] mData;
    private Context mContext;

    public StuAdapter(Context mContext,Student[] mData){
        this.mData = mData;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public Object getItem(int position) {
        return mData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.stu_item, parent, false);
        }

        Student s = mData[position];

        TextView nameView = convertView.findViewById(R.id.tv_name);
        nameView.setText(s.getName());

        TextView ageView = convertView.findViewById(R.id.tv_age);
        ageView.setText(String.valueOf( s.getAge()));

        ImageView headView = convertView.findViewById(R.id.headiv);
        headView.setImageResource(s.getHeadimg());

        return convertView;
    }
}
