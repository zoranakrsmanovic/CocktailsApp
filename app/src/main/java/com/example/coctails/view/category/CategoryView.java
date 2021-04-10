
package com.example.coctails.view.category;

import com.example.coctails.model.Drinks;

import java.util.List;

public interface CategoryView {
    void showLoading();
    void hideLoading();
    void setDrinks(List<Drinks.Drink> drinks);
    void onErrorLoading(String message);
}
