package com.example.evaluacion2.model;

public class Producto {
    String producto, precio;

    public Producto(String producto, String precio) {
        this.producto = producto;
        this.precio = precio;
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
}
