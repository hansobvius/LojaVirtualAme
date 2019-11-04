package com.android.lodjinhaproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.lodjinhaproject.ui.ProdutoListActivity;
import com.android.lodjinhaproject.R;
import com.android.lodjinhaproject.models.categoria.CategoriaModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.android.lodjinhaproject.constants.Constants.INTENT_ID_EXRA;

public class CategoriasAdapter extends RecyclerView.Adapter<CategoriasAdapter.CategoriasViewHolder> {

    private List<CategoriaModel> mCategoriaModel = new ArrayList<>();
    private Context mContext;

    public CategoriasAdapter(List<CategoriaModel> categoria, Context context){
        this.mCategoriaModel = categoria;
        this.mContext = context;
    }

    @NonNull
    @Override
    public CategoriasAdapter.CategoriasViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.categorias_layout, viewGroup, false);
        return new CategoriasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriasAdapter.CategoriasViewHolder categoriasViewHolder, int i) {
        CategoriaModel categoriaModel = mCategoriaModel.get(i);
        Picasso.with(mContext).load(categoriaModel.getUrlImage()).into(categoriasViewHolder.mProdutoImagem);
        Picasso.with(mContext).setLoggingEnabled(true);
        categoriasViewHolder.mProdutoCategoria.setText(categoriaModel.getDescricao());
        categoriasViewHolder.setId(categoriaModel.getId());
    }

    @Override
    public int getItemCount() {
        return !mCategoriaModel.isEmpty() ? mCategoriaModel.size() : 0;
    }

    class CategoriasViewHolder extends RecyclerView.ViewHolder {

        ImageView mProdutoImagem;
        TextView mProdutoCategoria;
        int mId;

        void setId(int id){
            this.mId = id;
        }

        CategoriasViewHolder(View itemView){
            super(itemView);
            mProdutoImagem = itemView.findViewById(R.id.imagem_produto_categoria);
            mProdutoCategoria = itemView.findViewById(R.id.text_produto_categoria);

            mProdutoImagem.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(mContext, ProdutoListActivity.class);
                    intent.putExtra(INTENT_ID_EXRA, mId);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
