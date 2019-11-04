package com.android.lodjinhaproject.models.produtodetalhe;

import com.google.gson.annotations.SerializedName;

public class ProdutoCategoriaModel {

    @SerializedName("id")
    private int id;

    @SerializedName("descricao")
    private String descricao;

    @SerializedName("urlImage")
    private String urlImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
