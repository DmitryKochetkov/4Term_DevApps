package com.dimedrol.lab1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NumAdapter {

    class NumViewHolder extends RecyclerView.ViewHolder {

        TextView numView;

        public NumViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
