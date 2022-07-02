package com.example.reto1juanosorio.modelo;

public class Sucursal {

    private String id;
    private String nombre;
    private String direccion;
    private String ubicacionMapa;

    public Sucursal(String id, String nombre, String direccion, String ubicacionMapa){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ubicacionMapa = ubicacionMapa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbicacionMapa() {
        return ubicacionMapa;
    }

    public void setUbicacionMapa(String ubicacionMapa) {
        this.ubicacionMapa = ubicacionMapa;
    }
}
