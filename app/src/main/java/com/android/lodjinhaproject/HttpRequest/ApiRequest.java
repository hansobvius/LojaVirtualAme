package com.android.lodjinhaproject.HttpRequest;

import android.support.annotation.NonNull;
import android.util.Log;

import com.android.lodjinhaproject.constants.Constants;
import com.android.lodjinhaproject.models.ProdutoComprado.StatusCompraModel;
import com.android.lodjinhaproject.models.produtodetalhe.ProdutoDetalheModel;
import com.android.lodjinhaproject.presenter.ViewModel;
import com.android.lodjinhaproject.models.banner.BannerService;
import com.android.lodjinhaproject.models.categoria.CategoriaService;
import com.android.lodjinhaproject.models.produto.ProdutoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRequest {

    private ServiceApi mServiceApi;
    private ViewModel mViewModel;

    public ApiRequest(ViewModel viewModel){
        this.mViewModel = viewModel;
        if(this.mServiceApi == null){
            this.mServiceApi = new ServiceApi();
        }
    }

    public void getBannerRequest(){

        mServiceApi
                .getAPI()
                .getBanner()
                .enqueue(new Callback<BannerService>() {
                    @Override
                    public void onResponse(@NonNull Call<BannerService> call, @NonNull Response<BannerService> response) {
                        if(response.body() != null){
                            Log.i("NEW_API_REQUEST", Integer.toString(response.body().getBanner().size()) );
                            mViewModel.bannerView(response.body().getBanner());

                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<BannerService> call, @NonNull Throwable t) {

                    }
                });
    }

    public void getCategoriaRequest(){

        mServiceApi
                .getAPI()
                .getCategoria()
                .enqueue(new Callback<CategoriaService>() {
                    @Override
                    public void onResponse(@NonNull Call<CategoriaService> call, @NonNull Response<CategoriaService> response) {
                        if(response.body() != null){
                            mViewModel.categoriaView(response.body().getCategoria());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<CategoriaService> call, @NonNull Throwable t) {}
                });
    }

    public void getProdutosRequest(){

        mServiceApi
                .getAPI()
                .getProdutosMaisVendidos()
                .enqueue(new Callback<ProdutoService>() {
                    @Override
                    public void onResponse(@NonNull Call<ProdutoService> call, @NonNull Response<ProdutoService> response) {
                        if(response.body() != null){
                            mViewModel.produtoView(response.body().getProdutos());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ProdutoService> call, @NonNull Throwable t) {}
                });
    }

    public void getProdutoPorCategoria(int id){

        mServiceApi
                .getAPI()
                .getProdutoPorCategoria(id)
                .enqueue(new Callback<ProdutoService>(){
            @Override
            public void onResponse(@NonNull Call<ProdutoService> call, @NonNull Response<ProdutoService> response){
                if(response.body() != null){
                    mViewModel.produtoView(response.body().getProdutos());
                }
            }
            @Override
            public void onFailure(@NonNull Call<ProdutoService> call, @NonNull Throwable t){}
        });
    }

    public void getProdutoDetalheId(int id){

        mServiceApi
                .getAPI()
                .getProduto(id)
                .enqueue(new Callback<ProdutoDetalheModel>() {
                    @Override
                    public void onResponse(@NonNull Call<ProdutoDetalheModel> call, @NonNull Response<ProdutoDetalheModel> response) {
                        if(response.body() != null){
                           mViewModel.produtoPorCategoriaView(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ProdutoDetalheModel> call, @NonNull Throwable t) {}
                });
    }

    public void setPostProduto(int id){

        mServiceApi
                .getAPI()
                .setStatus(id)
                .enqueue(new Callback<StatusCompraModel>() {
                    @Override
                    public void onResponse(@NonNull Call<StatusCompraModel> call, @NonNull Response<StatusCompraModel> response) {
                        if(response.body().getResult().equals(Constants.SUCCESS)){
                            mViewModel.produtoPost(response.body());
                            Log.i("POST_PRODUTO", response.body().getResult());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<StatusCompraModel> call, @NonNull Throwable t) {}
                });
    }
}
