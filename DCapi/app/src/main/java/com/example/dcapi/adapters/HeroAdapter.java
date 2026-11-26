package com.example.dcapi.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dcapi.DetailActivity;
import com.example.dcapi.R;
import com.example.dcapi.models.Hero;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {

    private Context context;
    private List<Hero> heroes;

    public HeroAdapter(Context context, List<Hero> heroes) {
        this.context = context;
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_hero, parent, false);

        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull HeroViewHolder holder, int position) {

            Hero hero = heroes.get(position);

            holder.txtName.setText(hero.getName());
            holder.txtRealName.setText(hero.getRealName());

            Glide.with(context)
                    .load(hero.getImage())
                    .centerCrop()
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .into(holder.imgHero);

            holder.itemView.setOnClickListener(v -> {

                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("name", hero.getName());
                intent.putExtra("realName", hero.getRealName());
                intent.putExtra("image", hero.getImage());
                intent.putExtra("publisher", hero.getPublisher());
                intent.putExtra("alignment", hero.getAlignment());
                intent.putExtra("intelligence", hero.getIntelligence());
                intent.putExtra("strength", hero.getStrength());
                intent.putExtra("speed", hero.getSpeed());
                intent.putExtra("power", hero.getPower());
                intent.putExtra("biography", hero.getBiography());

                context.startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return heroes.size();
        }

        public static class HeroViewHolder extends RecyclerView.ViewHolder {

            ImageView imgHero;
            TextView txtName, txtRealName;

            public HeroViewHolder(@NonNull View itemView) {
                super(itemView);

                imgHero = itemView.findViewById(R.id.imgHero);
                txtName = itemView.findViewById(R.id.txtName);
                txtRealName = itemView.findViewById(R.id.txtRealName);
            }
    }
}

