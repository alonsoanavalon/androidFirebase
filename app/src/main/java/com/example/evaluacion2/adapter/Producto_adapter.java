package com.example.evaluacion2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacion2.R;
import com.example.evaluacion2.model.Producto;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class Producto_adapter extends FirestoreRecyclerAdapter<Producto, Producto_adapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Producto_adapter(@NonNull FirestoreRecyclerOptions<Producto> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int i, @NonNull Producto Producto) {
        holder.producto.setText(Producto.getProducto());
        holder.precio.setText(Producto.getPrecio());
        holder.categoria.setText(Producto.getCategoria());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_producto_single, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView producto, precio, categoria;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoria =  itemView.findViewById(R.id.categoriaProducto);
            producto = itemView.findViewById(R.id.nombreProducto);
            precio = itemView.findViewById(R.id.precioProducto);
        }
    }
}
