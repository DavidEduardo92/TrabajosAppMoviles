package com.example.imagenes;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv_Anime;
    List<Anime> listaAnime = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_Anime = findViewById(R.id.rcv_Anime);

        CargarInformacion();


    }

    private void CargarInformacion() {
        String url = "https://rickandmortyapi.com/";

        StringRequest myRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try{
                    procesarRespuesta(new JSONObject(s));
                } catch(JSONException e){
                    Toast.makeText(MainActivity.this,"Error en el servidor",Toast.LENGTH_LONG).show();
                }
            }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this,"Error en el servidor",Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
        rq.add(myRequest);

    }

    private void procesarRespuesta(JSONObject respuesta) {
        try{
            for(int i = 0; i<respuesta.getJSONArray("results").length();i++){
                String nombre = respuesta.getJSONArray("results").getJSONObject(i).getString("name");
                String especie = respuesta.getJSONArray("results").getJSONObject(i).getString("species");
                String genero = respuesta.getJSONArray("results").getJSONObject(i).getString("gender");
                String estatus = respuesta.getJSONArray("results").getJSONObject(i).getString("status");

                Anime anime = new Anime (nombre,especie,genero,estatus);

                listaAnime.add(anime);

                rcv_Anime.setLayoutManager(new LinearLayoutManager(this));
                rcv_Anime.setAdapter(new AnimeAdaptador(listaAnime));

            }
        }catch(JSONException e){
            Toast.makeText(MainActivity.this,"Error en el servidor",Toast.LENGTH_LONG).show();
        }
    }

}