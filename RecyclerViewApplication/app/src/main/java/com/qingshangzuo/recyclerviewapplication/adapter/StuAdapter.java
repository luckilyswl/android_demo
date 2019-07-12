package com.qingshangzuo.recyclerviewapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qingshangzuo.recyclerviewapplication.R;
import com.qingshangzuo.recyclerviewapplication.model.Student;
import com.qingshangzuo.recyclerviewapplication.view.StuViewHolder;

import java.util.ArrayList;

public class StuAdapter extends RecyclerView.Adapter<StuViewHolder> {
    private ArrayList<Student> stuData;

    public StuAdapter(ArrayList<Student> stuData){
        this.stuData = stuData;
    }

    @Override
    public StuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stu_item, parent,false);

        StuViewHolder holder = new StuViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final StuViewHolder holder, int position) {
        final Student s = stuData.get(position);
        holder.getIvHead().setImageResource(s.getHeadImg());
        holder.getTvName().setText(s.getName());


        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.getView().getContext(), "您点击了 " + s.getName() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return stuData.size();
    }
}
