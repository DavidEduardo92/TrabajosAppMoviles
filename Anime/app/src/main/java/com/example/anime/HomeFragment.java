package com.example.anime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(
                R.layout.fragment_home, container, false);

        RecyclerView recycler =
                vista.findViewById(R.id.recyclerAnime);

        recycler.setLayoutManager(
                new LinearLayoutManager(requireContext()));

        List<Anime> personajes = new ArrayList<>();

        personajes.add(new Anime(
                "Rick Sanchez",
                "Científico genio y aventurero.",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        ));

        personajes.add(new Anime(
                "Morty Smith",
                "Acompaña a Rick en sus aventuras.",
                "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
        ));

        personajes.add(new Anime(
                "Summer Smith",
                "Hermana de Morty.",
                "https://rickandmortyapi.com/api/character/avatar/3.jpeg"
        ));

        personajes.add(new Anime(
                "Beth Smith",
                "Madre de Morty y Summer.",
                "https://rickandmortyapi.com/api/character/avatar/4.jpeg"
        ));

        personajes.add(new Anime(
                "Jerry Smith",
                "Padre de Morty y Summer.",
                "https://rickandmortyapi.com/api/character/avatar/5.jpeg"
        ));

        personajes.add(new Anime(
                "Abadango Cluster Princess",
                "Personaje del universo de Rick y Morty.",
                "https://rickandmortyapi.com/api/character/avatar/6.jpeg"
        ));

        AnimeAdapter adapter = new AnimeAdapter(personajes);
        recycler.setAdapter(adapter);

        return vista;
    }
}
