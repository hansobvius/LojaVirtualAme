package com.android.lodjinhaproject.models.produtodetalhe;

import com.google.gson.annotations.SerializedName;

public class ProdutoDetalheModel {

    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("urlImagem")
    private String urlImage;

    @SerializedName("descricao")
    private String descricao;

    @SerializedName("precoDe")
    private int precoDe;

    @SerializedName("precoPor")
    private Double precoPor;

    @SerializedName("categoria")
    private ProdutoCategoriaModel produtoCategoriaModel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public ProdutoCategoriaModel getProdutoCategoriaModel() {
        return produtoCategoriaModel;
    }

    public void setProdutoCategoriaModel(ProdutoCategoriaModel produtoCategoriaModel) {
        this.produtoCategoriaModel = produtoCategoriaModel;
    }
}
