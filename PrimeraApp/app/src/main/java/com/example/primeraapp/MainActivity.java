package com.example.primeraapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtCaja1, edtCaja2;
    Button btnCalcular, btnLimpiar;
    Spinner spnOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCaja1 = findViewById(R.id.edtCaja1);
        edtCaja2 = findViewById(R.id.edtCaja2);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        spnOperacion = findViewById(R.id.spnOperacion);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCaja1.setText("");
                edtCaja2.setText("");
            }
        });
    }
    private void calcular(){


        String caja1 = edtCaja1.getText().toString();
        String caja2 = edtCaja2.getText().toString();

        if (caja1.isEmpty() || caja2.isEmpty()){
            Toast.makeText(MainActivity.this, "Por favor llenar todos los campos", Toast.LENGTH_LONG).show();
        }else {
            int num1 = Integer.parseInt(caja1);
            int num2 = Integer.parseInt(caja2);
            String operacion = spnOperacion.getSelectedItem().toString();

            int resultado = 0;

            switch (operacion) {

                case "+":
                    resultado = num1 + num2;
                    break;

                case "-":
                    resultado = num1 - num2;
                    break;

                case "*":
                    resultado = num1 * num2;
                    break;

                case "/":

                    if (num2 == 0) {
                        Toast.makeText(MainActivity.this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
                        return;
                    }

                    resultado = num1 / num2;
                    break;
            }
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("resultado", resultado);
            startActivity(intent);
        }
    }
}