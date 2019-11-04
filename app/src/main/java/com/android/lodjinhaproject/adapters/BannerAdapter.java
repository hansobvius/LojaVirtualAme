package com.android.lodjinhaproject.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    @NonNull
    @Override
    public BannerAdapter.BannerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapter.BannerViewHolder bannerViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{

        BannerViewHolder(View itemView){
            super(itemView);
        }
    }
}
