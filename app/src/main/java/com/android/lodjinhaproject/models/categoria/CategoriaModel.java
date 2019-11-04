package com.android.lodjinhaproject.models.categoria;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriaModel {

    @SerializedName("id")
    private int id;

    @SerializedName("descricao")
    private String descricao;

    @SerializedName("urlImagem")
    private String urlImage;

    public int getId() {
        return id;
    }

    public CategoriaModel(int id, String urlImagem, String descricao){
        this.id = id;
        this.urlImage = urlImagem;
        this.descricao = descricao;
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
