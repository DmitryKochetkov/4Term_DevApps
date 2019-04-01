package com.dimedrol.lab1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

public class NumAdapter extends RecyclerView.Adapter<NumAdapter.NumViewHolder> {

    private int length;
    RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.forLanguageTag("ru"), RuleBasedNumberFormat.SPELLOUT);

    public NumAdapter(int count)
    {
        length = count;
    }

    @NonNull
    @Override
    public NumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        NumViewHolder viewHolder = new NumViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumViewHolder numViewHolder, int i) {
        String s = nf.format(i+1);
        numViewHolder.bind(s);

        if (i % 2 == 0)
            numViewHolder.itemView.setBackgroundResource(R.color.grey);
    }

    @Override
    public int getItemCount() {
        return length;
    }

    class NumViewHolder extends RecyclerView.ViewHolder {

        TextView numView;
        ImageView imageView;

        public NumViewHolder(@NonNull View itemView) {
            super(itemView);
            numView = itemView.findViewById(R.id.tv_num_item);
            imageView = itemView.findViewById(R.id.im_item);
        }

        void bind(int listIndex) {
            numView.setText(String.valueOf(listIndex));
        }

        void bind(String s)
        {
            numView.setText(s);
        }
    }
}
