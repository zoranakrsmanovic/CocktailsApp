/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/24/19 5:13 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.example.coctails.view.category;

import androidx.annotation.NonNull;

import com.example.coctails.Utils;
import com.example.coctails.model.Drinks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter {
    private CategoryView view;

    public CategoryPresenter(CategoryView view) {
        this.view = view;
    }
    
    void getCoctailByCategory(String category) {
        
        view.showLoading();
        Call<Drinks> drinksCall= Utils.getApi().getCoctailByCategory(category);
        drinksCall.enqueue(new Callback<Drinks>() {
            @Override
            public void onResponse(@NonNull Call<Drinks> call, @NonNull Response<Drinks> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.setDrinks(response.body().getDrinks());
                } else {
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
}
