package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;

import android.app.ProgressDialog;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;




public class MainActivity extends AppCompatActivity {
    EditText correo, password;
    Button btnIngresar, btnRegistrarse;
    ProgressDialog pd;
    FirebaseFirestore db;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correo = findViewById(R.id.correo);
        password = findViewById(R.id.password);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrarse = findViewById(R.id.goRegister);
        pd = new ProgressDialog(this);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();



        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View view) {
              Intent I = new Intent(MainActivity.this, register.class);
              startActivity(I);
            }
        });

//        btnIngresar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String tit = titulo.getText().toString();
//                String des = descripcion.getText().toString();
//                String pes = peso.getText().toString();
//                subirDatos(tit,des,pes);
//            }
//
//            private void subirDatos(String tit, String des, String pes) {
//
//                pd.setTitle("Agregando datos a Firebase");
//                pd.show();
//                String id = UUID.randomUUID().toString();
//                Map<String, Object> registro = new HashMap<String,Object>();
//                registro.put("titulo", tit);
//                registro.put("descripcion", des);
//                registro.put("peso", pes);
//                db.collection("Documentos").document(id).set(registro)
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                pd.dismiss();
//                                Toast.makeText(MainActivity.this,"grabado con exito",Toast.LENGTH_LONG).show();
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                pd.dismiss();
//                                Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
//                            }
//                        });
//            }
//        });



//        btnIngresar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String tit = titulo.getText().toString();
//                String des = descripcion.getText().toString();
//                String pes = peso.getText().toString();
//                subirDatos(tit,des,pes);
//            }
//
//            private void subirDatos(String tit, String des, String pes) {
//
//                pd.setTitle("Agregando datos a Firebase");
//                pd.show();
//                String id = UUID.randomUUID().toString();
//                Map<String, Object> registro = new HashMap<String,Object>();
//                registro.put("titulo", tit);
//                registro.put("descripcion", des);
//                registro.put("peso", pes);
//                db.collection("Documentos").document(id).set(registro)
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                pd.dismiss();
//                                Toast.makeText(MainActivity.this,"grabado con exito",Toast.LENGTH_LONG).show();
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                pd.dismiss();
//                                Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
//                            }
//                        });
//            }
//        });



    }




}
