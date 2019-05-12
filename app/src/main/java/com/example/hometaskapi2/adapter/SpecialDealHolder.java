package com.example.hometaskapi2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hometaskapi2.R;
import com.example.hometaskapi2.allDeals.DealContract;
import com.example.hometaskapi2.rest.entities.Deal;


public class SpecialDealHolder extends RecyclerView.ViewHolder {

    private ImageView ivSpecial;

    public SpecialDealHolder(@NonNull View itemView){
        super((itemView));
        ivSpecial = itemView.findViewById(R.id.ivSpecial);
    }

    public void bind(Deal deal){
        Glide.with(itemView)
                .load(deal.getImage_url())
                .placeholder(R.drawable.placeholder)
                .into(ivSpecial);
    }
}
