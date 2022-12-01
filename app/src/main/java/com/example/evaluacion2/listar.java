package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.evaluacion2.adapter.Producto_adapter;
import com.example.evaluacion2.model.Producto;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.Task;

import java.util.HashMap;
import java.util.Map;

public class listar extends AppCompatActivity {

    ProgressDialog pd;
    FirebaseFirestore db;
    RecyclerView mRecycler;
    Producto_adapter mAdapter;

    private static final String TAG = "DocSnippets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        pd = new ProgressDialog(this);
        db = FirebaseFirestore.getInstance();
        mRecycler = findViewById(R.id.reciclerViewProductos);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = db.collection("Documentos");

        FirestoreRecyclerOptions<Producto> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Producto>().setQuery(query, Producto.class).build();

        mAdapter = new Producto_adapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);
        System.out.println("Se nos viene");

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
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