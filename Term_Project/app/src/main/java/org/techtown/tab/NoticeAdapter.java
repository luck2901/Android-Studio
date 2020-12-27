package org.techtown.tab;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder>{
    ArrayList<NoticeList> items = new ArrayList<NoticeList>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.notice_item, parent, false);

        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        NoticeList item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(NoticeList item) {
        items.add(item);
    }

    public void setItems(ArrayList<NoticeList> items) {
        this.items = items;
    }

    public NoticeList getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, NoticeList item) {
        items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView30);
            textView2 = itemView.findViewById(R.id.textView31);
        }

        public void setItem(NoticeList item) {
            textView.setText(item.getTitle());
            textView2.setText(item.getContent());
        }

    }

}
