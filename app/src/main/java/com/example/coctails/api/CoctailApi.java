package com.example.coctails.api;

import com.example.coctails.model.Categories;
import com.example.coctails.model.Drinks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoctailApi {
    @GET("random.php")
    Call<Drinks> getDrink();

    @GET("list.php?c=list")
    Call<Categories> getCategories();

    @GET("filter.php")
    Call<Drinks> getCoctailByCategory(@Query("c") String category);

    @GET("search.php")
    Call<Drinks> getDrinkByName(@Query("s")String drinkName);
}
