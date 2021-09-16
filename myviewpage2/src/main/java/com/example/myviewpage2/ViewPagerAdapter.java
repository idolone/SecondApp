package com.example.myviewpage2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPageHolder> {
    private List<String> titles = new ArrayList<>();
    private List<Integer> colors = new ArrayList<>();
    public ViewPagerAdapter() {
        titles.add("hello");
        titles.add("kitty");
        titles.add("you");
        titles.add("are");
        titles.add("best");

        colors.add(R.color.white);
        colors.add(R.color.black);
        colors.add(R.color.red);
        colors.add(R.color.green);
        colors.add(R.color.blue);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewPageHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return new ViewPageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pager,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewPageHolder holder, int position) {
           holder.mTv.setText(titles.get(position));
           holder.mContainer.setBackgroundResource(colors.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ViewPageHolder extends RecyclerView.ViewHolder{
        TextView mTv;
        RelativeLayout mContainer;
        public ViewPageHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            mContainer = itemView.findViewById(R.id.container);
            mTv = itemView.findViewById(R.id.tvTitle);
        }
    }
}
