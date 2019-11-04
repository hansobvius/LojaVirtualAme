package com.android.lodjinhaproject.models.ProdutoComprado;

import com.android.lodjinhaproject.models.produtodetalhe.ProdutoCategoriaModel;
import com.google.gson.annotations.SerializedName;

public class StatusCompraModel {

    @SerializedName("result")
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
