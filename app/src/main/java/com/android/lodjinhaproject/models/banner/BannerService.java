package com.android.lodjinhaproject.models.banner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BannerService {

    @SerializedName("data")
    @Expose
    private List<BannerModel> banner;

    public List<BannerModel> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerModel> banner) {
        this.banner = banner;
    }
}
