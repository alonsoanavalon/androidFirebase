package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class crear extends AppCompatActivity {

    TextView displayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("nombre");
        displayName = findViewById(R.id.displayName);
        displayName.setText(nombre);
    }




}