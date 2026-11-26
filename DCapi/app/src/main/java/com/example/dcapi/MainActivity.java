
package com.example.dcapi;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.example.dcapi.adapters.HeroAdapter;
import com.example.dcapi.models.Hero;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerHeroes;
    private ProgressBar progressBar;
    private TextView txtStatus;

    private ArrayList<Hero> heroList;
    private HeroAdapter adapter;

    private final String API_URL =
            "https://akabab.github.io/superhero-api/api/all.json";

    // Personajes seleccionados mediante sus ID
    private final List<Integer> selectedHeroIds = Arrays.asList(
            70,
            644,
            720,
            263,
            38,
            306
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerHeroes = findViewById(R.id.recyclerHeroes);
        progressBar = findViewById(R.id.progressBar);
        txtStatus = findViewById(R.id.txtStatus);

        heroList = new ArrayList<>();

        recyclerHeroes.setLayoutManager(
                new LinearLayoutManager(this)
        );

        adapter = new HeroAdapter(this, heroList);
        recyclerHeroes.setAdapter(adapter);

        loadHeroes();
    }

    private void loadHeroes() {

        progressBar.setVisibility(View.VISIBLE);
        txtStatus.setText("Cargando personajes de DC...");

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                API_URL,
                null,

                response -> {

                    heroList.clear();

                    try {

                        for (int i = 0; i < response.length(); i++) {

                            JSONObject obj = response.getJSONObject(i);

                            int heroId = obj.optInt("id");

                            // Filtrar únicamente los seis personajes
                            if (!selectedHeroIds.contains(heroId)) {
                                continue;
                            }

                            JSONObject bio =
                                    obj.optJSONObject("biography");

                            if (bio == null) continue;

                            String publisher =
                                    bio.optString("publisher", "");

                            if (!selectedHeroIds.contains(heroId)) {
                                continue;
                            }

                            JSONObject images =
                                    obj.optJSONObject("images");

                            JSONObject stats =
                                    obj.optJSONObject("powerstats");

                            if (images == null || stats == null) {
                                continue;
                            }

                            String name =
                                    obj.optString("name", "");

                            if (heroId == 306) {
                                name = "Green Lantern";
                            }

                            String image =
                                    images.optString("md", "");

                            if (image.isEmpty()) continue;

                            String realName =
                                    bio.optString(
                                            "fullName",
                                            "Identidad desconocida"
                                    );

                            String alignment =
                                    bio.optString(
                                            "alignment",
                                            "Desconocido"
                                    );

                            String intelligence =
                                    stats.optString(
                                            "intelligence",
                                            "0"
                                    );

                            String strength =
                                    stats.optString(
                                            "strength",
                                            "0"
                                    );

                            String speed =
                                    stats.optString(
                                            "speed",
                                            "0"
                                    );

                            String power =
                                    stats.optString(
                                            "power",
                                            "0"
                                    );

                            String biography =
                                    bio.optString(
                                            "firstAppearance",
                                            "Sin información"
                                    );

                            Hero hero = new Hero(
                                    heroId,
                                    name,
                                    realName,
                                    image,
                                    publisher,
                                    alignment,
                                    intelligence,
                                    strength,
                                    speed,
                                    power,
                                    biography
                            );

                            heroList.add(hero);
                        }

                        // Ordenar según la lista seleccionada
                        heroList.sort((h1, h2) ->
                                Integer.compare(
                                        selectedHeroIds.indexOf(h1.getId()),
                                        selectedHeroIds.indexOf(h2.getId())
                                )
                        );

                        adapter.notifyDataSetChanged();

                        if (heroList.isEmpty()) {

                            txtStatus.setText(
                                    "No se encontraron personajes."
                            );

                        } else {

                            txtStatus.setText(
                                    "Personajes encontrados: "
                                            + heroList.size()
                            );
                        }

                    } catch (Exception e) {

                        txtStatus.setText(
                                "Error procesando los personajes."
                        );

                        Toast.makeText(
                                MainActivity.this,
                                e.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }

                    progressBar.setVisibility(View.GONE);
                },

                error -> {

                    progressBar.setVisibility(View.GONE);

                    txtStatus.setText(
                            "Error de conexión. Intenta nuevamente."
                    );

                    Toast.makeText(
                            MainActivity.this,
                            "No se pudo conectar con la API",
                            Toast.LENGTH_LONG
                    ).show();
                }
        );

        queue.add(request);
    }
}
