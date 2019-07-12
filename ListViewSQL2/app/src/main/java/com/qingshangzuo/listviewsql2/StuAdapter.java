package com.qingshangzuo.listviewsql2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StuAdapter extends BaseAdapter {
    private ArrayList<Student> stuList;
    private Context mContext;
    private int count =0;

    public StuAdapter(Context context, ArrayList<Student> stuList){
        this.mContext = context;
        this.stuList = stuList;
    }

    @Override
    public int getCount() {
        return stuList.size();
    }

    @Override
    public Object getItem(int position) {
        return stuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.e("StuAdapter", "getView pos = " + position);
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.stu_item, parent,false);
            count++;
            Log.e("StuAdapter", "inflate pos = " + position + " count = " + count);

            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvAge = (TextView) convertView.findViewById(R.id.tv_age);
            holder.ivDel = (ImageView) convertView.findViewById(R.id.iv_del);
            convertView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stuList.remove(position);
                // 通知adapter 数据集发生了变化 需要刷新
                StuAdapter.this.notifyDataSetChanged();
            }
        });

        Student s = stuList.get(position);
        holder.tvName.setText(s.getName());
        holder.tvAge.setText(String.valueOf(s.getAge()));

        return convertView;
    }

    class ViewHolder{
        TextView tvName;
        TextView tvAge;
        ImageView ivDel;
    }
}

