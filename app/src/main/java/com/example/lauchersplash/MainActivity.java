package com.example.lauchersplash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button hello;
    Button count;
    Button Sianida;
    Button twoactivity;
    Button setalarm;
    Button Maps;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello = findViewById(R.id.hello);
        count = findViewById(R.id.count);
        Sianida = findViewById(R.id.sianida);
        twoactivity = findViewById(R.id.twoactivity);
        setalarm = findViewById(R.id.setalarm);
        Maps = findViewById(R.id.Maps);

        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Buka = new Intent(MainActivity.this, helloactivity.class);
                startActivity(Buka);
            }
        });
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Buka = new Intent(MainActivity.this, countactivity.class);
                startActivity(Buka);
            }
        });
        Sianida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Buka = new Intent(MainActivity.this, sianidaactivity.class);
                startActivity(Buka);
            }
        });
        twoactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Buka = new Intent(MainActivity.this, twoactivity.class);
                startActivity(Buka);
            }
        });
        setalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Buka = new Intent(MainActivity.this, setalarmactivity.class);
                startActivity(Buka);
            }
        });
        Maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Buka = new Intent(MainActivity.this,Mapsactivity.class);
                startActivity(Buka);
            }
        });
    }
}