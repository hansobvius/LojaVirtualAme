package com.android.lodjinhaproject.HttpRequest;

import com.android.lodjinhaproject.models.ProdutoComprado.StatusCompraModel;
import com.android.lodjinhaproject.models.banner.BannerService;
import com.android.lodjinhaproject.models.categoria.CategoriaService;
import com.android.lodjinhaproject.models.produto.ProdutoService;
import com.android.lodjinhaproject.models.produtodetalhe.ProdutoDetalheModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataEndpoint {

    @GET("banner")
    Call<BannerService> getBanner();

    @GET("categoria")
    Call<CategoriaService> getCategoria();

    @GET("produto/maisvendidos")
    Call<ProdutoService> getProdutosMaisVendidos();

    @GET("produto")
    Call<ProdutoService> getProdutoPorCategoria(
            @Query("categoriaId") int id);

    @GET("produto/{produtoId}")
    Call<ProdutoDetalheModel> getProduto(
            @Path("produtoId") int id);

    @POST("produto/{produtoId}")
    Call<StatusCompraModel> setStatus(
            @Path("produtoId") int id);

}
