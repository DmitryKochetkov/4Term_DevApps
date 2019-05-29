package com.dimedrol.lab3_2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Student> list;

    public StudentAdapter(ArrayList<Student> list, Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Student student = list.get(i);
        viewHolder.idTextView.setText("ID: " + student.id);
        viewHolder.fioTextView.setText(student.first_name + " " + student.second_name + " " + student.last_name);
        viewHolder.dateTextView.setText("Created: " + student.date);
        if (i % 2 == 0)
            viewHolder.itemView.setBackgroundResource(R.color.grey);
        else viewHolder.itemView.setBackgroundResource(R.color.white);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView idTextView;
        private final TextView fioTextView;
        private final TextView dateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.field_id);
            fioTextView = itemView.findViewById(R.id.field_fio);
            dateTextView = itemView.findViewById(R.id.field_date);
        }

    }

}
