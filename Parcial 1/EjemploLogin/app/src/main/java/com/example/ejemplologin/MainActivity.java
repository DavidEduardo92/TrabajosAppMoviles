package com.example.ejemplologin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtCaja1, edtCaja2;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCaja1 = findViewById(R.id.edtCaja1);
        edtCaja2 = findViewById(R.id.edtCaja2);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });
    }
    private void ingresar(){


        String caja1 = edtCaja1.getText().toString();
        String caja2 = edtCaja2.getText().toString();

        if (caja1.equals("uac123") && caja2.equals("12345678")){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.putExtra("usuario", caja1);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "Datos incorrectos, intentelo otra vez", Toast.LENGTH_LONG).show();
            }

    }
}