package com.example.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Hero> listHeroes;
    private ArrayList<Hero> getListHeroes() {
        return listHeroes;
    }
    public void setListHeroes(ArrayList<Hero> listHeroes) {
        this.listHeroes = listHeroes;
    }
    public GridHeroAdapter(Context context) {
        this.context = context;
    }
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_hero, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListHeroes().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListHeroes().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
