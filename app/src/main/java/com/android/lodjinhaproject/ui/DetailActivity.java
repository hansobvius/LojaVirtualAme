package com.android.lodjinhaproject.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.lodjinhaproject.HttpRequest.ApiRequest;
import com.android.lodjinhaproject.R;
import com.android.lodjinhaproject.constants.Constants;
import com.android.lodjinhaproject.models.ProdutoComprado.StatusCompraModel;
import com.android.lodjinhaproject.models.banner.BannerModel;
import com.android.lodjinhaproject.models.categoria.CategoriaModel;
import com.android.lodjinhaproject.models.produto.ProdutosModel;
import com.android.lodjinhaproject.models.produtodetalhe.ProdutoDetalheModel;
import com.android.lodjinhaproject.presenter.ViewModel;
import com.android.lodjinhaproject.utils.DialogMessage;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.android.lodjinhaproject.constants.Constants.INTENT_ID;
import static com.android.lodjinhaproject.constants.Constants.SUCCESS;

public class DetailActivity extends AppCompatActivity implements ViewModel {

    private ConstraintLayout mMainViewLIst;
    private RelativeLayout mRelativeLayout;
    private ConstraintLayout mProgressBar;
    private Context mContext;
    private ImageView mProdutoImagem;
    private TextView mdescricaoProduto;
    private TextView mValorProduto;
    private TextView mValorDesconto;
    private TextView mTituloProduto;
    private int mId;

    private FloatingActionButton mFloatingActionButton;

    private ApiRequest mApiRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mMainViewLIst = findViewById(R.id.main_vew_list);
        mRelativeLayout = findViewById(R.id.relative_layout);
        mRelativeLayout.setVisibility(View.GONE);
        mProgressBar = findViewById(R.id.progress_detail);
        mContext = DetailActivity.this;
        mProdutoImagem = findViewById(R.id.produto_imagem);
        mdescricaoProduto = findViewById(R.id.produto_descricao);
        mValorProduto = findViewById(R.id.produto_valor);
        mValorDesconto = findViewById(R.id.produto_valor_desconto);
        mTituloProduto = findViewById(R.id.produto_titulo);
        mFloatingActionButton = findViewById(R.id.share_fab);

        Intent intent = getIntent();
        mId = intent.getIntExtra(INTENT_ID, 0);
    }

    @Override
    public void onResume(){
        super.onResume();
        mApiRequest = new ApiRequest(this);
        initListener();
        initRequest(mId);
    }

    private void initListener(){
        mFloatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mApiRequest.setPostProduto(mId);
            }
        });
    }

    private void initRequest(int id){
        mApiRequest.getProdutoDetalheId(id);
    }

    @Override
    public void bannerView(List<BannerModel> banner) {}

    @Override
    public void categoriaView(List<CategoriaModel> categoria) {}

    @Override
    public void produtoView(List<ProdutosModel> produtos) { }

    @Override
    public void produtoPorCategoriaView(ProdutoDetalheModel produto) {
        Picasso.with(mContext).load(produto.getUrlImage()).into(mProdutoImagem);
        mTituloProduto.setText(produto.getNome());
        mdescricaoProduto.setText(produto.getDescricao());
        mValorProduto.setText(Integer.toString(produto.getPrecoDe()));
        mValorProduto.setPaintFlags(mValorProduto.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        mValorDesconto.setText(Double.toString(produto.getPrecoPor()));
        if(produto != null){
            mProgressBar.setVisibility(View.GONE);
            mRelativeLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void produtoPost(StatusCompraModel statusPost) {
        if(statusPost.getResult().equals(SUCCESS)){
            dialogView();
        }
    }

    public void dialogView(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        DialogMessage dialog = new DialogMessage();
        dialog.show(fm, Constants.DIALOG_FRAGMENT_KEY);
        ft.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home){
            this.onBackPressed();
            return true;
        }
        return true;
    }
}
