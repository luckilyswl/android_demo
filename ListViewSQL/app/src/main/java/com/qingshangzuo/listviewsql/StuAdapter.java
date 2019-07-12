package com.qingshangzuo.listviewsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

/**
 * 自定义适配器
 */

public class StuAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Student> stuData;

    public StuAdapter(Context context, ArrayList<Student> stuData){
        this.context = context;
        this.stuData = stuData;
    }

    @Override
    public int getCount() {
        return stuData.size();
    }

    @Override
    public Object getItem(int position) {
        return stuData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return stuData.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if(convertView == null){
           convertView = LayoutInflater.from(context).inflate(R.layout.stu_item, parent, false);

           StuViewHolder holder = new StuViewHolder();
           holder.tvID = (TextView) convertView.findViewById(R.id.tv_id);
           holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
           holder.tvAge = (TextView) convertView.findViewById(R.id.tv_age);
           holder.ivDel = (ImageView) convertView.findViewById(R.id.iv_del);

           convertView.setTag(holder);
       }

        final Student s = stuData.get(position);
        StuViewHolder holder  = (StuViewHolder) convertView.getTag();

        holder.tvID.setText(String.valueOf(s.getId()));
        holder.tvName.setText(s.getName());
        holder.tvAge.setText(String.valueOf(s.getAge()));
        holder.ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 去执行删除当前位置学生的操作
                int id = s.getId();
                delFromSQlite(id);
            }
        });

        return convertView;
    }

    //  从数据库中删除id的学生
    private void delFromSQlite(int id) {
        String path = context.getFilesDir().getAbsolutePath() + File.separator + "my.db";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(path,null);
        String where = "id = " + id;
        db.delete("student", where, null);


    }


    class StuViewHolder{
        TextView tvID;
        TextView tvName;
        TextView tvAge;
        ImageView ivDel;
    }
}






















