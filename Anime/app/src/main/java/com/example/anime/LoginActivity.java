package com.example.anime;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsuario, edtContrasena;
    Button btnIngresar;
    
    private final String usuarioCorrecto = "David";
    private final String contrasenaCorrecta = "12345678";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtContrasena = findViewById(R.id.edtContrasena);
        btnIngresar = findViewById(R.id.btnEntrar);

        btnIngresar.setOnClickListener(v -> {
            String usuario = edtUsuario.getText().toString();
            String password = edtContrasena.getText().toString();

            if (usuario.isEmpty() || password.isEmpty()) {
                Toast.makeText(this,
                        "Completa ambos campos",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (usuario.equals(usuarioCorrecto)
                    && password.equals(contrasenaCorrecta)) {

                Intent intent = new Intent(
                        LoginActivity.this, MainActivity.class);

                intent.putExtra("nombreUsuario", usuario);
                startActivity(intent);
                finish();

            } else {
                Toast.makeText(this,
                        "Usuario o contraseña incorrectos",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}