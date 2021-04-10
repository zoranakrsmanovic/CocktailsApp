package com.example.coctails.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coctails.R;
import com.example.coctails.model.Drinks;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewCoctailByCategory extends RecyclerView.Adapter<RecyclerViewCoctailByCategory.RecyclerViewHolder> {

    private List<Drinks.Drink> drinks;
    private Context context;
    private static ClickListener clickListener;

    public RecyclerViewCoctailByCategory(Context context, List<Drinks.Drink> drinks) {
        this.drinks = drinks;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewCoctailByCategory.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_drink,
                viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewCoctailByCategory.RecyclerViewHolder viewHolder, int i) {

        String strDrinkThumb = drinks.get(i).getStrDrinkThumb();
        Picasso.get().load(strDrinkThumb).placeholder(R.drawable.shadow_bottom_to_top).into(viewHolder.mealThumb);

        String strDrinkName = drinks.get(i).getStrDrink();
        viewHolder.mealName.setText(strDrinkName);
    }


    @Override
    public int getItemCount() {
        return drinks.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.drinkThumb)
        ImageView mealThumb;
        @BindView(R.id.drinkName)
        TextView mealName;
        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }


    public void setOnItemClickListener(ClickListener clickListener) {
        RecyclerViewCoctailByCategory.clickListener = clickListener;
    }


    public interface ClickListener {
        void onClick(View view, int position);
    }
}

