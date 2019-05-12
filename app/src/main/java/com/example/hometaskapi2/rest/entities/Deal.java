package com.example.hometaskapi2.rest.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deal {
    @Expose
    @SerializedName("discount")
    private int discount;

    @Expose
    @SerializedName("image_kind")
    private String deal_kind;

    @Expose
    @SerializedName("price")
    private int price;

    @Expose
    @SerializedName("title_short")
    private String title_short;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("reviews_rate")
    private double reviews_rate;

    @Expose
    @SerializedName("bought")
    private int bought;

    @Expose
    @SerializedName("image_url")
    private String image_url;


    /**Due to the fact that Retrofit will deal with the all the Constructor related tasks,
     * we do not need to have Constructor. Therefore, I commented the constuctor part of this code*/
//    public Deal(String image_url,int discount, int price, String title_short, String title, double reviews_rate, int bought) {
//        this.discount = discount;
//        this.price = price;
//        this.title_short = title_short;
//        this.title = title;
//        this.reviews_rate = reviews_rate;
//        this.bought = bought;
//        this.image_url = image_url;
//    }

    public boolean isSpecial(){
        return this.deal_kind.equals("special");
    }

    public String getImage_url() {
        return image_url;
    }

    public int getDiscount() {
        return discount;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle_short() {
        return title_short;
    }

    public String getTitle() {
        return title;
    }

    public double getReviews_rate() {
        return reviews_rate;
    }

    public int getBought() {
        return bought;
    }

    public String getDeal_kind() {
        return deal_kind;
    }
}
