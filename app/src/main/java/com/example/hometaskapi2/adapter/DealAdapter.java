package com.example.hometaskapi2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hometaskapi2.R;
import com.example.hometaskapi2.rest.entities.Deal;

import java.util.ArrayList;
import java.util.List;

public class DealAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Deal> dealList;
    private View view;
    private ReachEndListener reachEndListener;

    private final static int REGULAR_DEAL = 0;
    private final static int SPECIAL_DEAL = 1;

    public void setReachEndListener(ReachEndListener reachEndListener) {
        this.reachEndListener = reachEndListener;
    }

    public DealAdapter() {
        this.dealList = new ArrayList<>();
    }

    public void setDealList(List<Deal> dealList) {
        this.dealList.clear();
        this.dealList.addAll(dealList);
        notifyDataSetChanged();
    }

    public void addDealList(List<Deal> dealList) {
        this.dealList.addAll(dealList);
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        if(dealList.get(position).isSpecial()){
            return SPECIAL_DEAL;
        }else {
            return REGULAR_DEAL;
        }
    }

    /**onCreateViewHolder has the int parameter named 'type' - this parameter by default uses the
     * method called getItemViewType, and consequently it gets returned value of this method*/
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        if(type == SPECIAL_DEAL){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item_special, viewGroup, false);
            return new SpecialDealHolder(view);
        }else{
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item, viewGroup, false);
            return new DealViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof SpecialDealHolder){
            ((SpecialDealHolder)viewHolder).bind(dealList.get(position));
        }else {
            ((DealViewHolder) viewHolder).bind(dealList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dealList.size();
    }

//    @Override
//    public void onBindViewHolder(@NonNull DealViewHolder dealViewHolder, int position) {
//        dealViewHolder.bind(dealList.get(position));
//        if(position >= dealList.size() - 3){
//            reachEndListener.onReachEnd();
//        }
//    }

}
