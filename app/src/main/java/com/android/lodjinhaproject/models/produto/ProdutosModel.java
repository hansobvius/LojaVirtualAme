package com.android.lodjinhaproject.models.produto;

import com.android.lodjinhaproject.models.categoria.CategoriaModel;
import com.google.gson.annotations.SerializedName;

public class ProdutosModel {

    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("urlImagem")
    private String urlImagem;

    @SerializedName("descricao")
    private String descricao;

    @SerializedName("precoDe")
    private int precoDe;

    @SerializedName("precoPor")
    private Double precoPor;

    @SerializedName("categoria")
    private CategoriaModel categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrecoDe() {
        return precoDe;
    }

    public void setPrecoDe(int precoDe) {
        this.precoDe = precoDe;
    }

    public Double getPrecoPor() {
        return precoPor;
    }

    public void setPrecoPor(Double precoPor) {
        this.precoPor = precoPor;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }
}
