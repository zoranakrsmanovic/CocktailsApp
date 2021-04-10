package com.example.coctails.view.detail;

import com.example.coctails.model.Drinks;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setDrink (Drinks.Drink drink);
    void onErrorLoading(String message);
}
