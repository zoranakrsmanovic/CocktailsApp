package com.example.coctails.view.home;

import com.example.coctails.model.Categories;
import com.example.coctails.model.Drinks;

import java.util.List;

public interface HomeView {


    void showLoading();
    void hideLoading();
    void setDrinks(List<Drinks.Drink> drink);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
