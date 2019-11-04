package com.android.lodjinhaproject.ui;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.lodjinhaproject.HttpRequest.ApiRequest;
import com.android.lodjinhaproject.R;
import com.android.lodjinhaproject.adapters.ProdutosAdapter;
import com.android.lodjinhaproject.models.ProdutoComprado.StatusCompraModel;
import com.android.lodjinhaproject.models.banner.BannerModel;
import com.android.lodjinhaproject.models.categoria.CategoriaModel;
import com.android.lodjinhaproject.models.produto.ProdutosModel;
import com.android.lodjinhaproject.models.produtodetalhe.ProdutoDetalheModel;
import com.android.lodjinhaproject.presenter.ViewModel;

import java.util.List;

import static com.android.lodjinhaproject.constants.Constants.INTENT_ID_EXRA;

public class ProdutoListActivity extends AppCompatActivity implements ViewModel {

    private TextView mNoDataText;
    private ConstraintLayout mProgressBar;
    private ProdutosAdapter mProdutosAdapter;
    private RecyclerView mRecyclerView;
    private ApiRequest mApiRequest;
    private int mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_categoria_list);

        mNoDataText = findViewById(R.id.no_data_text);
        mProgressBar = findViewById(R.id.progress);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        mId = intent.getIntExtra(INTENT_ID_EXRA, 0);

        mRecyclerView = findViewById(R.id.produtos_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ProdutoListActivity.this));

        mApiRequest = new ApiRequest(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        initDataRequest();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        this.finish();
    }

    private void initDataRequest(){
        mApiRequest.getProdutoPorCategoria(mId);
    }

    @Override
    public void bannerView(List<BannerModel> banner) {}

    @Override
    public void categoriaView(List<CategoriaModel> categoria) {}

    @Override
    public void produtoView(List<ProdutosModel> produtos) {
        if(!produtos.isEmpty() || produtos.size() > 0){
            mProgressBar.setVisibility(View.GONE);
            initLIstData(produtos);
        }else{
            mProgressBar.setVisibility(View.GONE);
            mNoDataText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void produtoPorCategoriaView(ProdutoDetalheModel produto) {}

    @Override
    public void produtoPost(StatusCompraModel statusPost) {}

    private void initLIstData(List<ProdutosModel> produtos){
        mProdutosAdapter = new ProdutosAdapter(produtos, ProdutoListActivity.this);
        mRecyclerView.setAdapter(mProdutosAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
            return true;
        }
        return true;
    }
}
