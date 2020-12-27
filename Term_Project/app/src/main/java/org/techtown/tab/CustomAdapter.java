package org.techtown.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{
    //유저정보 담기
    private ArrayList<Article> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<Article> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    //뷰 홀더 생성
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // list item이랑 연결
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    // item들을 여기서 매칭
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        //여기에 정보를 담아 배출
        //Glide.with(holder.itemView).load(arrayList.get(position).getPropile()).into(holder.iv_profile);
        holder.title1.setText(arrayList.get(position).getTitle1());
        holder.context1.setText(arrayList.get(position).getContext1());

    }

    @Override
    public int getItemCount() {
        //삼항연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
       // ImageView iv_profile;
        TextView title1;
        TextView context1;



        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            // xml꺼 불러오기
            //this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.title1 = itemView.findViewById(R.id.title1);
            this.context1 = itemView.findViewById(R.id.context1);
        }
    }
}
