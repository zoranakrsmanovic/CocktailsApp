package com.example.coctails.view.detail;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import com.example.coctails.R;
import com.example.coctails.Utils;
import com.example.coctails.model.Drinks;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.coctails.view.home.HomeActivity.EXTRA_DETAIL;

public class DetailActivity extends AppCompatActivity implements DetailView{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.mealThumb)
    ImageView mealThumb;

    @BindView(R.id.category)
    TextView category;

    @BindView(R.id.country)
    TextView country;

    @BindView(R.id.instructions)
    TextView instructions;

    @BindView(R.id.ingredient)
    TextView ingredients;

    @BindView(R.id.measure)
    TextView measures;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setupActionBar();

        Intent intent = getIntent();
        String drinkName = intent.getStringExtra(EXTRA_DETAIL);

        DetailPresenter presenter = new DetailPresenter(this);
        presenter.getDrinkById(drinkName);

    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorWhite));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    void setupColorActionBarIcon(Drawable favoriteItemColor) {
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if ((collapsingToolbarLayout.getHeight() + verticalOffset) < (2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout))) {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorPrimary),
                        PorterDuff.Mode.SRC_ATOP);

            } else {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorWhite),
                        PorterDuff.Mode.SRC_ATOP);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem favoriteItem = menu.findItem(R.id.favorite);
        Drawable favoriteItemColor = favoriteItem.getIcon();
        setupColorActionBarIcon(favoriteItemColor);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setDrink(Drinks.Drink drink) {
        Picasso.get().load(drink.getStrDrinkThumb()).into(mealThumb);
        collapsingToolbarLayout.setTitle(drink.getStrDrink());
        category.setText(drink.getStrCategory());
        country.setText(drink.getStrAlcoholic());
        instructions.setText(drink.getStrInstructions());
        setupActionBar();

        //===

        if (drink.getStrIngredient1()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient1());
        }
        if (drink.getStrIngredient2()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient2());
        }
        if (drink.getStrIngredient3()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient3());
        }
        if (drink.getStrIngredient4()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient4());
        }
        if (drink.getStrIngredient5()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient5());
        }
        if (drink.getStrIngredient6()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient6());
        }
        if (drink.getStrIngredient7()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient7());
        }
        if (drink.getStrIngredient8()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient8());
        }
        if (drink.getStrIngredient9()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient9());
        }
        if (drink.getStrIngredient10()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient10());
        }
        if (drink.getStrIngredient11()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient11());
        }
        if (drink.getStrIngredient12()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient12());
        }
        if (drink.getStrIngredient13()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient13());
        }
        if (drink.getStrIngredient14()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient14());
        }
        if (drink.getStrIngredient15()!=null) {
            ingredients.append("\n \u2022 " + drink.getStrIngredient15());
        }


        if (drink.getStrMeasure1()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure1());
        }
        if (drink.getStrMeasure2()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure2());
        }
        if (drink.getStrMeasure3()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure3());
        }
        if (drink.getStrMeasure4()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure4());
        }
        if (drink.getStrMeasure5()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure5());
        }
        if (drink.getStrMeasure6()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure6());
        }
        if (drink.getStrMeasure7()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure7());
        }
        if (drink.getStrMeasure8()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure8());
        }
        if (drink.getStrMeasure9()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure9());
        }
        if (drink.getStrMeasure10()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure10());
        }
        if (drink.getStrMeasure11()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure11());
        }
        if (drink.getStrMeasure12()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure12());
        }
        if (drink.getStrMeasure13()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure13());
        }
        if (drink.getStrMeasure14()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure14());
        }
        if (drink.getStrMeasure15()!=null && !Character.isWhitespace(drink.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + drink.getStrMeasure15());
        }

    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this,"Error", message);
    }
}


