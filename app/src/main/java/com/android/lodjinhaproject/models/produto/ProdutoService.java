package com.android.lodjinhaproject.models.produto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProdutoService {

    @SerializedName("data")
    @Expose
    private List<ProdutosModel> produtos;

    public List<ProdutosModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutosModel> produtos) {
        this.produtos = produtos;
    }
}
