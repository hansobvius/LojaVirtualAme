package com.android.lodjinhaproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.lodjinhaproject.R;
import com.android.lodjinhaproject.ui.WebActivity;
import com.android.lodjinhaproject.models.banner.BannerModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PageViewAdapter extends PagerAdapter {

    private Context context;
    private List<BannerModel> mBanner = new ArrayList<>();


    public PageViewAdapter(List<BannerModel> bannerList, Context context) {
        this.mBanner = bannerList;
        this.context = context;

    }

    @NonNull
    @Override
    public View instantiateItem(@NonNull ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.banner_layout, collection, false);
        final BannerModel bannerModel = mBanner.get(position);
        String urlImage = bannerModel.getUrlImagem();
        final ImageView imageView= view.findViewById(R.id.banner_image);
        Picasso.with(context).load(urlImage).into(imageView);
        collection.addView(view);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("URL_KEY", bannerModel.getLinkUrl());
                context.startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public int getCount() {
        return !mBanner.isEmpty() ? mBanner.size() : 0;
    }
}