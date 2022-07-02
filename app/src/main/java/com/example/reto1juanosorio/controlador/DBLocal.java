package com.example.reto1juanosorio.controlador;

import android.provider.BaseColumns;

public class DBLocal {

    public static final String DATABASE_NAME = "restaurante2.db";
    public static final String DATABASE_NAME_FACTURA = "factura3.db";
    public static final String TABLE_PRODUCTO = "producto";
    public static final String TABLE_ELEMENTO_FACTURA = "factura";
    public static final String TABLE_CLIENTE = "cliente";
    public static final String TABLE_SUCURSAL = "sucursal";

    public static class TB_PRODUCTO implements BaseColumns {
        public static String ID = "id";
        public static String NOMBRE = "nombre";
        public static String DESCRIPCION = "descripcion";
        public static String PRECIO = "precio";
        public static String IMAGEN = "imagen";
        public static String FAVORITO = "favorito";
        public static String CATEGORIA = "categoria";
    }

    public static class TB_ELEMENTO_FACTURA implements BaseColumns {
        public static String ID = "id";
        public static String NOMBRE_PRODUCTO = "nombre_producto";
        public static String PRECIO = "precio";
        public static String CANTIDAD = "cantidad";
        public static String TOTAL_PRECIO = "total_precio";
        public static String IMAGEN = "imagen";
    }

    public static class TB_SUCURSAL implements BaseColumns {
        public  static String ID = "id";
        public static String NOMBRE = "nombre";
        public static String DIRECCION = "direccion";
        public static String UBICACION_MAPA = "ubicacion_mapa";
    }
}