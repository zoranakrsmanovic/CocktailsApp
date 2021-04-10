package com.example.coctails.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.coctails.R;
import com.example.coctails.model.Drinks;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerHeaderAdapter extends PagerAdapter {

    private List<Drinks.Drink> drinks;
    private Context context;
    private static ClickListener clickListener;

    public ViewPagerHeaderAdapter(List<Drinks.Drink> drinks, Context context) {
        this.drinks = drinks;
        this.context = context;
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        ViewPagerHeaderAdapter.clickListener = clickListener;
    }

    @Override
    public int getCount() {
        return drinks.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_view_pager_header,
                container,
                false
        );

        ImageView mealThumb = view.findViewById(R.id.coctailThumb);
        TextView mealName = view.findViewById(R.id.coctailName);

        String strMealThumb = drinks.get(position).getStrDrinkThumb();
        Picasso.get().load(strMealThumb).into(mealThumb);

        String strMealName = drinks.get(position).getStrDrink();
        mealName.setText(strMealName);

        view.setOnClickListener(v -> clickListener.onClick(v, position));

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }


        public interface ClickListener {
            void onClick(View v, int position);
        }

}
