package com.example.coctails.view.detail;

import androidx.annotation.NonNull;

import com.example.coctails.Utils;
import com.example.coctails.model.Drinks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    void getDrinkById(String drinkName) {

        view.showLoading();


        Utils.getApi().getDrinkByName(drinkName).enqueue(new Callback<Drinks>() {
            @Override
            public void onResponse(@NonNull Call<Drinks> call, @NonNull Response<Drinks> response) {
                view.hideLoading();
                if(response.isSuccessful() && response.body() != null){
                   view.setDrink(response.body().getDrinks().get(0));
                } else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Drinks> call,@NonNull Throwable t) {
                    view.hideLoading();
                    view.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }
}