package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import android.widget.Toast;
import androidx.annotation.NonNull;
import java.util.UUID;


public class crear extends AppCompatActivity {
    Spinner spinnerCategorias;
    EditText precio, producto;
    Button buttonCrear, buttonVolver;
    //btn
    ProgressDialog pd;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        pd = new ProgressDialog(this);
        db = FirebaseFirestore.getInstance();
        Bundle datos = getIntent().getExtras();
        precio = findViewById(R.id.precioGasto);
        spinnerCategorias = findViewById(R.id.spinnerCategorias);
        producto = findViewById(R.id.productoGasto);
        buttonCrear = findViewById(R.id.btnIngresarGasto);
        buttonVolver = findViewById(R.id.btnVolver);

        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String parsedCategoria = spinnerCategorias.getSelectedItem().toString();
                String parsedProducto = producto.getText().toString();
                String parsedPrecio = precio.getText().toString();
                subirDatos(parsedProducto, parsedPrecio, parsedCategoria);
            }
        });

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(crear.this, dashboard.class);
                startActivity(I);
            }
        });
    }


                private void subirDatos(String producto, String precio, String categoria) {

                pd.setTitle("Agregando datos a Firebase");
                pd.show();
                String id = UUID.randomUUID().toString();
                Map<String, Object> registro = new HashMap<String,Object>();
                registro.put("producto", producto);
                registro.put("precio", precio);
                registro.put("categoria", categoria);
                db.collection("Documentos").document(id).set(registro)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                pd.dismiss();
                                Toast.makeText(crear.this,"grabado con exito",Toast.LENGTH_LONG).show();
                                Intent I = new Intent(crear.this, dashboard.class);
                                startActivity(I);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                pd.dismiss();
                                Toast.makeText(crear.this,e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });
            }




}