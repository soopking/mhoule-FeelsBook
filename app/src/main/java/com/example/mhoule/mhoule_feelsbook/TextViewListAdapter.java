package com.example.mhoule.mhoule_feelsbook;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

import java.util.ArrayList;

// Partially from https://developer.android.com/guide/topics/ui/layout/recyclerview

public class TextViewListAdapter<T extends EmotionMessage> extends RecyclerView.Adapter<TextViewListAdapter.TextViewHolder> {
    private ArrayList<T> tArrayList;

    public TextViewListAdapter(ArrayList<T> tArrayList) {
        this.tArrayList = tArrayList;
    }

    static public class TextViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public TextViewHolder(TextView itemView) {
            super(itemView);
            textView = itemView;
            textView.setLongClickable(true);
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return false;
                }
            });
        }
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.message_item, viewGroup, false);
        TextViewHolder viewHolder = new TextViewHolder(textView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder textViewHolder, int i) {
        textViewHolder.textView.setText(tArrayList.get(i).toString());
    }

    @Override
    public int getItemCount() {
        return tArrayList.size();
    }
}
