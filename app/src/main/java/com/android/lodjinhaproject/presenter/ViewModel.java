package com.android.lodjinhaproject.presenter;

import com.android.lodjinhaproject.models.ProdutoComprado.StatusCompraModel;
import com.android.lodjinhaproject.models.banner.BannerModel;
import com.android.lodjinhaproject.models.categoria.CategoriaModel;
import com.android.lodjinhaproject.models.produto.ProdutosModel;
import com.android.lodjinhaproject.models.produtodetalhe.ProdutoDetalheModel;

import java.util.List;

public interface ViewModel {

    void bannerView(List<BannerModel> banner);

    void categoriaView(List<CategoriaModel> categoria);

    void produtoView(List<ProdutosModel> produtos);

    void produtoPorCategoriaView(ProdutoDetalheModel produto);

    void produtoPost(StatusCompraModel statusPost);
}
