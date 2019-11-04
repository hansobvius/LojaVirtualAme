package com.android.lodjinhaproject.models.banner;

import com.google.gson.annotations.SerializedName;

public class BannerModel {

    @SerializedName("id")
    private int id;

    @SerializedName("urlImagem")
    private String urlImagem;

    @SerializedName("linkUrl")
    private String linkUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
