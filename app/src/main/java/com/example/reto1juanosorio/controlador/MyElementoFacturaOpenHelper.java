package com.example.reto1juanosorio.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.reto1juanosorio.datos.ListaPlatosPrincipales;
import com.example.reto1juanosorio.modelo.ElementoFactura;
import com.example.reto1juanosorio.modelo.Producto;

import java.util.ArrayList;


public class MyElementoFacturaOpenHelper extends SQLiteOpenHelper {
    public static int VERSION = 1;

    public MyElementoFacturaOpenHelper(@Nullable Context context) {
        super(context, DBLocal.DATABASE_NAME_FACTURA, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        crearTablaElementosFactura(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newVersion) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + DBLocal.TABLE_ELEMENTO_FACTURA);
    }

    public void crearTablaElementosFactura(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+DBLocal.TABLE_ELEMENTO_FACTURA+"(id TEXT PRIMARY KEY, nombre_producto TEXT, precio INTEGER, cantidad INTEGER, total_precio INTEGER, imagen INTEGER)");
    }

    public void insertarElementoFactura(ElementoFactura ef , SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(DBLocal.TB_ELEMENTO_FACTURA.ID, ""+Math.random());
        cv.put(DBLocal.TB_ELEMENTO_FACTURA.NOMBRE_PRODUCTO, ef.getNombre_producto());
        cv.put(DBLocal.TB_ELEMENTO_FACTURA.PRECIO, ef.getPrecio());
        cv.put(DBLocal.TB_ELEMENTO_FACTURA.CANTIDAD, ef.getCantidad());
        cv.put(DBLocal.TB_ELEMENTO_FACTURA.TOTAL_PRECIO, ef.getId());
        cv.put(DBLocal.TB_ELEMENTO_FACTURA.IMAGEN, ef.getId());
        db.insert(DBLocal.TABLE_ELEMENTO_FACTURA, null, cv);
    }

    public void actualizarElementoFactura(int cantidad, String id, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(DBLocal.TB_ELEMENTO_FACTURA.CANTIDAD, cantidad);
        cv.put(DBLocal.TB_ELEMENTO_FACTURA.ID, id);
        String[] arg = new String[]{""+id};
        db.update(DBLocal.TABLE_ELEMENTO_FACTURA, cv, "id=?", arg);
        //db.insert(DBLocal.TABLE_PRODUCTOS, null, cv);
    }

    public void eliminarElementoFactura(String id, SQLiteDatabase db){
        String[] arg = new String[]{""+id};
        db.delete(DBLocal.TABLE_ELEMENTO_FACTURA,"id=?", arg);
    }

    public Cursor leerElementosFactura(SQLiteDatabase db){
        return db.query(DBLocal.TABLE_ELEMENTO_FACTURA, null, null, null, null, null, null);
    }

    public Cursor select_all_elementos_factura(SQLiteDatabase db){
        String sql = "Select * from "+DBLocal.TABLE_ELEMENTO_FACTURA;
        return db.rawQuery(sql, null,null);
    }

    public void delete_all_elementos_factura(SQLiteDatabase db){
        db.delete(DBLocal.TABLE_ELEMENTO_FACTURA,null, null);
    }

}