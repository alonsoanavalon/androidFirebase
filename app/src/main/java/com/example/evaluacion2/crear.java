package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    TextView displayName;
    EditText precio, producto;
    Button buttonCrear;
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
        String nombre = datos.getString("nombre");
        displayName = findViewById(R.id.displayName);
        displayName.setText(nombre);
        precio = findViewById(R.id.precioGasto);
        producto = findViewById(R.id.productoGasto);
        buttonCrear = findViewById(R.id.btnIngresarGasto);

        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String parsedProducto = producto.getText().toString();
                String parsedPrecio = precio.getText().toString();
                subirDatos(parsedProducto, parsedPrecio);
            }
        });
    }


                private void subirDatos(String producto, String precio) {

                pd.setTitle("Agregando datos a Firebase");
                pd.show();
                String id = UUID.randomUUID().toString();
                Map<String, Object> registro = new HashMap<String,Object>();
                registro.put("producto", producto);
                registro.put("precio", precio);
                db.collection("Documentos").document(id).set(registro)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                pd.dismiss();
                                Toast.makeText(crear.this,"grabado con exito",Toast.LENGTH_LONG).show();
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