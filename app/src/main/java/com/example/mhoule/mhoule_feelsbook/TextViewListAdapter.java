package com.example.mhoule.mhoule_feelsbook;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.Toast;

import java.util.ArrayList;

// Partially from https://developer.android.com/guide/topics/ui/layout/recyclerview

public class TextViewListAdapter<T extends EmotionMessage> extends RecyclerView.Adapter<TextViewListAdapter.TextViewHolder> {
    private ArrayList<T> tArrayList;

    public TextViewListAdapter(ArrayList<T> tArrayList) {
        this.tArrayList = tArrayList;
    }

    static public class TextViewHolder<T extends EmotionMessage> extends RecyclerView.ViewHolder {
        public TextView textView;

        public TextViewHolder(TextView itemView, final ArrayList<T> arrayList) {
            super(itemView);
            textView = itemView;
            textView.setLongClickable(true);
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();
                    EmotionMessage emotionMessage = arrayList.get(position);
                    Toast.makeText(v.getContext(), emotionMessage.toString(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.message_item, viewGroup, false);
        TextViewHolder viewHolder = new TextViewHolder<>(textView, tArrayList);
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
