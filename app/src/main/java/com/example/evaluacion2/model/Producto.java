package com.example.evaluacion2.model;

public class Producto {
    String producto, precio, categoria;

    public Producto(String producto, String precio, String categoria) {
        this.producto = producto;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto() {

    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
