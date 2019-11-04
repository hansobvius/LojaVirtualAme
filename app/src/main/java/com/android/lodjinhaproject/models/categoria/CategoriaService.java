package com.android.lodjinhaproject.models.categoria;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriaService {

    @SerializedName("data")
    @Expose
    private List<CategoriaModel> categoria;

    public List<CategoriaModel> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<CategoriaModel> ingredients) {
        this.categoria = ingredients;
    }
}
