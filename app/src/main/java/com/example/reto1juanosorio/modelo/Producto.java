package com.example.reto1juanosorio.modelo;

public class Producto {

    private String id;
    private String nombre;
    private String descripcion;
    private String precio;
    private String categoria;
    private int favorito;
    private int imagen;

    public Producto(String id, String nombre, String descripcion, String precio, int imagen, String categoria){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.favorito = 0;
        this.categoria = categoria;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int isFavorito(){return favorito;}

    public void setFavorito(int favorito){this.favorito=favorito;}

    public String getCategoria() { return categoria;}

    public void setCategoria(String categoria) {this.categoria = categoria;}

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio='" + precio + '\'' +
                ", categoria='" + categoria + '\'' +
                ", favorito=" + favorito +
                ", imagen=" + imagen +
                '}';
    }
}
