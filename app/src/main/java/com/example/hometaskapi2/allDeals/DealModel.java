package com.example.hometaskapi2.allDeals;

import com.example.hometaskapi2.rest.NetworkService;
import com.example.hometaskapi2.rest.entities.MainDeal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealModel implements DealContract.Model {
    DealContract.Presenter presenter;
    public DealModel(DealContract.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void getDealList(int page) {

        Call<MainDeal> call = NetworkService.getInstance().getChocoApi().getDealList(1,1, page);
        call.enqueue(new Callback<MainDeal>() {
            @Override
            public void onResponse(Call<MainDeal> call, Response<MainDeal> response) {
                presenter.loadingFinished(response.body());
            }

            @Override
            public void onFailure(Call<MainDeal> call, Throwable t) {
                presenter.loadingFailed(t);
            }
        });

    }
}
