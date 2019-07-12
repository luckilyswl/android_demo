package com.qingshangzuo.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class StuAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Student> mStudentList;

    public StuAdapter(List<Student> studentList) {
        mStudentList = studentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stu_item,
                parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.stuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Student student = mStudentList.get(position);
                Toast.makeText(view.getContext(), "you clicked image" + student.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        holder.stuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Student student = mStudentList.get(position);
                Toast.makeText(view.getContext(), "you clicked" + student.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });


        holder.stuDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();

                mStudentList.remove(position);

                StuAdapter.this.notifyDataSetChanged();
            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = mStudentList.get(position);
        holder.stuImage.setImageResource(student.getHeadImage());
        holder.stuName.setText(student.getName());

    }


    @Override
    public int getItemCount() {

        return mStudentList.size();
    }
}

