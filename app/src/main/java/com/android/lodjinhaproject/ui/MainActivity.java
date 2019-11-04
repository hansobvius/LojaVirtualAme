package com.android.lodjinhaproject.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.android.lodjinhaproject.HttpRequest.ApiRequest;
import com.android.lodjinhaproject.R;
import com.android.lodjinhaproject.adapters.CategoriasAdapter;
import com.android.lodjinhaproject.adapters.ProdutosAdapter;
import com.android.lodjinhaproject.adapters.PageViewAdapter;
import com.android.lodjinhaproject.models.ProdutoComprado.StatusCompraModel;
import com.android.lodjinhaproject.models.banner.BannerModel;
import com.android.lodjinhaproject.models.categoria.CategoriaModel;
import com.android.lodjinhaproject.models.produto.ProdutosModel;
import com.android.lodjinhaproject.models.produtodetalhe.ProdutoDetalheModel;
import com.android.lodjinhaproject.presenter.ViewModel;

import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

public class MainActivity extends AppCompatActivity implements ViewModel {

    private LinearLayout mLinearLayout;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionToogle;
    private NavigationView mNavigationView;
    private ConstraintLayout mProgressBar;

    private RecyclerView mRecyclerCategorias;
    private RecyclerView mRecyclerMaisVendidos;
    private ViewPager mViewPagerBanner;
    private PageViewAdapter mPageViewAdapter;
    private CategoriasAdapter mCategoriasAdapter;
    private ProdutosAdapter mMaisVendidoAdapter;

    private ApiRequest mApiRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mLinearLayout = findViewById(R.id.activity_main);
        mLinearLayout.setVisibility(View.GONE);
        mNavigationView = findViewById(R.id.nv);
        mProgressBar = findViewById(R.id.progress_view);

        mViewPagerBanner = findViewById(R.id.viewpager);

        mRecyclerCategorias = findViewById(R.id.recycler_view_categorias);
        mRecyclerCategorias.setHasFixedSize(true);
        mRecyclerCategorias.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));

        mRecyclerMaisVendidos = findViewById(R.id.recycler_view_mais_vendidos);
        mRecyclerMaisVendidos.setHasFixedSize(true);
        mRecyclerMaisVendidos.setLayoutManager(new LinearLayoutManager(this));

        mApiRequest = new ApiRequest(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        initDataRequest();
        initDrawerNavigation();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        this.finish();
    }

    public void initDataRequest(){
        mApiRequest.getBannerRequest();
        mApiRequest.getCategoriaRequest();
        mApiRequest.getProdutosRequest();
    }

    @Override
    public void bannerView(List<BannerModel> banner) {
        mPageViewAdapter = new PageViewAdapter(banner, this);
        mViewPagerBanner.setAdapter(mPageViewAdapter);
    }

    @Override
    public void categoriaView(List<CategoriaModel> categoria) {
        mCategoriasAdapter = new CategoriasAdapter(categoria, this);
        mRecyclerCategorias.setAdapter(mCategoriasAdapter);
    }

    @Override
    public void produtoView(List<ProdutosModel> produtos) {
        if(produtos != null || !produtos.isEmpty()){
            mProgressBar.setVisibility(View.GONE);
            mLinearLayout.setVisibility(View.VISIBLE);
        }
        mMaisVendidoAdapter = new ProdutosAdapter(produtos, this);
        mRecyclerMaisVendidos.setAdapter(mMaisVendidoAdapter);
    }

    @Override
    public void produtoPorCategoriaView(ProdutoDetalheModel produto) {}

    @Override
    public void produtoPost(StatusCompraModel statusPost) {}

    private void initDrawerNavigation(){
        mActionToogle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close);
        mDrawerLayout.addDrawerListener(mActionToogle);
        mActionToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id) {
                    case R.id.home:
                        break;
                    case R.id.about:
                        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                        startActivity(intent);
                    default:
                        return true;
                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mActionToogle.onOptionsItemSelected(item)) return true;

        return super.onOptionsItemSelected(item);
    }
}
