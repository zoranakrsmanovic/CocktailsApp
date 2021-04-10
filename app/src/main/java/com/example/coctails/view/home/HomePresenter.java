package com.example.coctails.view.home;

import androidx.annotation.NonNull;

import com.example.coctails.Utils;
import com.example.coctails.model.Categories;
import com.example.coctails.model.Drinks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    void getDrinks(){

        view.showLoading();
        Call<Drinks> drinksCall = Utils.getApi().getDrink();
        drinksCall.enqueue(new Callback<Drinks>() {
            @Override
            public void onResponse(@NonNull Call<Drinks> call, @NonNull Response<Drinks> response) {
                view.hideLoading();
                if(response.isSuccessful() && response.body() != null){
                    view.setDrinks(response.body().getDrinks());
                }else{
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Drinks> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });


    }

    void getCategories(){
        view.showLoading();
        Call<Categories> categoriesCall = Utils.getApi().getCategories();
        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(@NonNull Call<Categories> call, @NonNull Response<Categories> response) {
                view.hideLoading();
                if(response.isSuccessful() && response.body() !=null){
                    view.setCategory(response.body().getCategories());
                }else{
                    view.onErrorLoading(response.message());
                }

            }

            @Override
            public void onFailure(@NonNull Call<Categories> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });



    }
}
