package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity {

    Button btnIngresar, btnListar, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnIngresar = findViewById(R.id.ingresarGastoBtn);
        btnListar = findViewById(R.id.listarGastosBtn);
        btnSalir = findViewById(R.id.btnSalir);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(dashboard.this, crear.class);
                startActivity(I);
            }


        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(dashboard.this, listar.class);
                startActivity(I);
            }


        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(dashboard.this, MainActivity.class);
                startActivity(I);
            }


        });
    }
}