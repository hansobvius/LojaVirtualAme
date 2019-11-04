package com.android.lodjinhaproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.lodjinhaproject.ui.DetailActivity;
import com.android.lodjinhaproject.R;
import com.android.lodjinhaproject.models.produto.ProdutosModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.android.lodjinhaproject.constants.Constants.INTENT_ID;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.MaisVendidosViewHolder> {

    private Context mContext;
    private List<ProdutosModel> mProdutoModel = new ArrayList<>();

    public ProdutosAdapter(List<ProdutosModel> produtoList, Context context){
        this.mProdutoModel = produtoList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ProdutosAdapter.MaisVendidosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(mContext).inflate(R.layout.mais_vendidos_layout, viewGroup, false);
        return new MaisVendidosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutosAdapter.MaisVendidosViewHolder maisVendidosViewHolder, int i) {
        ProdutosModel produtosModel = mProdutoModel.get(i);
        Picasso.with(mContext).load(produtosModel.getUrlImagem()).into(maisVendidosViewHolder.mProdutoImageView);
        maisVendidosViewHolder.mNomeProduto.setText(produtosModel.getNome());
        maisVendidosViewHolder.mPreco.setText(Integer.toString(produtosModel.getPrecoDe()));
        maisVendidosViewHolder.mPreco.setPaintFlags(maisVendidosViewHolder.mPreco.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        maisVendidosViewHolder.mPrecoDesconto.setText(Double.toString(produtosModel.getPrecoPor()));
        maisVendidosViewHolder.setId(produtosModel.getId());
    }

    @Override
    public int getItemCount() {
        return !mProdutoModel.isEmpty() ? mProdutoModel.size() : 0;
    }

    class MaisVendidosViewHolder extends RecyclerView.ViewHolder {

        ImageView mProdutoImageView;
        TextView mNomeProduto;
        TextView mPreco;
        TextView mPrecoDesconto;
        int id;

        void setId(int id) {
            this.id = id;
        }

        MaisVendidosViewHolder(View itemView) {
            super(itemView);
            mProdutoImageView = itemView.findViewById(R.id.imagem_produto_categoria);
            mNomeProduto = itemView.findViewById(R.id.text_nome_produto);
            mPreco = itemView.findViewById(R.id.text_valor);
            mPrecoDesconto = itemView.findViewById(R.id.text_valor_desconto);

            mProdutoImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("CLICK", Integer.toString(id));
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra(INTENT_ID, id);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
