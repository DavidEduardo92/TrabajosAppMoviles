package com.example.dcapi;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private ImageView detailImage;

    private TextView detailName;
    private TextView detailRealName;
    private TextView detailPublisher;
    private TextView detailAlignment;

    private TextView detailIntelligence;
    private TextView detailStrength;
    private TextView detailSpeed;
    private TextView detailPower;
    private TextView detailBiography;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImage = findViewById(R.id.detailImage);

        detailName = findViewById(R.id.detailName);
        detailRealName = findViewById(R.id.detailRealName);
        detailPublisher = findViewById(R.id.detailPublisher);
        detailAlignment = findViewById(R.id.detailAlignment);

        detailIntelligence = findViewById(R.id.detailIntelligence);
        detailStrength = findViewById(R.id.detailStrength);
        detailSpeed = findViewById(R.id.detailSpeed);
        detailPower = findViewById(R.id.detailPower);
        detailBiography = findViewById(R.id.detailBiography);

        Bundle data = getIntent().getExtras();

        if (data != null) {

            detailName.setText(data.getString("name"));
            detailRealName.setText(
                    "Nombre real: " + data.getString("realName")
            );

            detailPublisher.setText(
                    "Editorial: " + data.getString("publisher")
            );

            detailAlignment.setText(
                    "Alineación: " + data.getString("alignment")
            );

            detailIntelligence.setText(
                    "Inteligencia: " + data.getString("intelligence")
            );

            detailStrength.setText(
                    "Fuerza: " + data.getString("strength")
            );

            detailSpeed.setText(
                    "Velocidad: " + data.getString("speed")
            );

            detailPower.setText(
                    "Poder: " + data.getString("power")
            );

            detailBiography.setText(
                    data.getString("biography")
            );

            Glide.with(this)
                    .load(data.getString("image"))
                    .centerCrop()
                    .into(detailImage);
        }
    }
}
