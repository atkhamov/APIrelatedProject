package com.example.hometaskapi2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hometaskapi2.R;
import com.example.hometaskapi2.rest.entities.Deal;

public class DealViewHolder extends RecyclerView.ViewHolder {
    private TextView price;
    private TextView bought;
    private TextView rate;
    private TextView shortTitle;
    private TextView titleRV;
    private ImageView dealImage;


    /**DealViewHolder was created in order to create the item in the list of discounts on the screen
     * In other words DealViewHolder builds up the Item's layout*/
    public DealViewHolder(@NonNull View itemView) {
        super(itemView);
        this.price = itemView.findViewById(R.id.price);
        this.bought = itemView.findViewById(R.id.bought);
        this.rate = itemView.findViewById(R.id.rate);
        this.shortTitle = itemView.findViewById(R.id.title_short);
        this.titleRV = itemView.findViewById(R.id.titleRV);
        this.dealImage = itemView.findViewById(R.id.dealImage);
    }


    public void bind(Deal deal){
        String priceHolder = itemView.getResources().getString(R.string.price);

        shortTitle.setText(deal.getTitle_short());
        price.setText(String.format(priceHolder, deal.getPrice()));
        titleRV.setText(deal.getTitle());
        bought.setText(String.valueOf(deal.getBought()));
        rate.setText(String.valueOf(deal.getReviews_rate()));

        Glide.with(itemView)
                .load(deal.getImage_url())
                .into(dealImage);
    }
}
