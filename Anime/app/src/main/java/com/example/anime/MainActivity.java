package com.example.anime;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private String nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreUsuario = getIntent().getStringExtra("nombreUsuario");

        BottomNavigationView navegacion =
                findViewById(R.id.bottomNavigation);

        navegacion.setOnItemSelectedListener(item -> {
            Fragment fragmento;

            if (item.getItemId() == R.id.nav_inicio) {
                fragmento = new HomeFragment();

            } else if (item.getItemId() == R.id.nav_configuracion) {
                fragmento = new SettingsFragment();

                Bundle datos = new Bundle();
                datos.putString("nombreUsuario", nombreUsuario);
                fragmento.setArguments(datos);

            } else {
                return false;
            }

            mostrarFragmento(fragmento);
            return true;
        });

        navegacion.setSelectedItemId(R.id.nav_inicio);
    }

    private void mostrarFragmento(Fragment fragmento) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor, fragmento)
                .commit();
    }
}