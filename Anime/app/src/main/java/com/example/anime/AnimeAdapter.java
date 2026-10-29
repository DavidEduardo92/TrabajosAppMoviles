package com.example.anime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.List;

public class AnimeAdapter
        extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {

    private final List<Anime> listaAnime;

    public AnimeAdapter(List<Anime> listaAnime) {
        this.listaAnime = listaAnime;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_anime, parent, false);

        return new AnimeViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(
            @NonNull AnimeViewHolder holder, int position) {

        Anime anime = listaAnime.get(position);

        holder.txtNombre.setText(anime.getNombre());
        holder.txtDescripcion.setText(anime.getDescripcion());

        Picasso.with(holder.itemView.getContext())
                .load(anime.getImagen())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(holder.imgAnime);
    }

    @Override
    public int getItemCount() {
        return listaAnime.size();
    }

    static class AnimeViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgAnime;
        TextView txtNombre, txtDescripcion;

        AnimeViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAnime = itemView.findViewById(R.id.imgAnime);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
        }
    }
}
