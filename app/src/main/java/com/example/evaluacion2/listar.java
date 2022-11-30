package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class listar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
    }


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