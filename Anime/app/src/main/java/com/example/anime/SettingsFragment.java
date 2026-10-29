package com.example.anime;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(
                R.layout.fragment_settings, container, false);

        TextView txtUsuario =
                vista.findViewById(R.id.txtUsuario);

        Button btnCerrarSesion =
                vista.findViewById(R.id.btnSalir);

        Bundle datos = getArguments();

        if (datos != null) {
            String nombre = datos.getString("nombreUsuario", "");
            txtUsuario.setText("Usuario: " + nombre);
        }

        btnCerrarSesion.setOnClickListener(v -> {
            Intent intent = new Intent(
                    requireActivity(), LoginActivity.class);

            intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        });

        return vista;
    }
}
