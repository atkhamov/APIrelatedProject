package com.example.hometaskapi2.allDeals;

import com.example.hometaskapi2.rest.entities.Deal;
import com.example.hometaskapi2.rest.entities.MainDeal;

import java.util.List;


/**Example for
 * Pattern MVP - Model, View, Presenter*/

public interface DealContract {
    interface View{
        void showLoading();
        void hideLoading();
        void addNewDeals(List<Deal> newDeal);
        void showError(Throwable throwable);
    }

    interface Presenter{
        void load(int page);
        void loadingFinished(MainDeal mainDeal);
        void loadingFailed(Throwable throwable);
    }

    interface Model{
        void getDealList(int page);
    }
}
