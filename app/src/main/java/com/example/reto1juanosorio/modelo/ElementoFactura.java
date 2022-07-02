package com.example.reto1juanosorio.modelo;

public class ElementoFactura {

    private String id;
    private String nombre_producto;
    private int precio;
    private int cantidad;
    private int total_precio;
    private int imagen;

    public ElementoFactura(String id, String nombre_producto, int precio, int cantidad, int imagen){
        this.id = id;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
        this.total_precio = cantidad*precio;
    }

    public ElementoFactura(String nombre_producto, int precio, int cantidad, int imagen){
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
        this.total_precio = cantidad*precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal_precio() {
        return total_precio;
    }

    public void setTotal_precio(int total_precio) {
        this.total_precio = total_precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
