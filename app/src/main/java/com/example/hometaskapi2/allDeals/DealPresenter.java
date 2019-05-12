package com.example.hometaskapi2.allDeals;

import com.example.hometaskapi2.rest.entities.MainDeal;

public class DealPresenter implements DealContract.Presenter {

    private DealContract.Model model;
    private DealContract.View view;

    /**We need Constructor in order to transfer what Model and View we have*/
    public DealPresenter(DealContract.View view){
        this.model = new DealModel(this);
        this.view = view;
    }

    @Override
    public void load(int page) {
        //view.showLoading();
        model.getDealList(page);
    }

    @Override
    public void loadingFinished(MainDeal mainDeal) {
        /**Presenter sends the data to View*/
        view.addNewDeals(mainDeal.getResultList());
    }

    @Override
    public void loadingFailed(Throwable throwable) {
        view.hideLoading();
        view.showError(throwable);
    }
}
