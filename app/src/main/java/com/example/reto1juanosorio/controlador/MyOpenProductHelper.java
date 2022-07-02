package com.example.reto1juanosorio.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.reto1juanosorio.datos.ListaPlatosPrincipales;
import com.example.reto1juanosorio.modelo.Producto;

import java.util.ArrayList;


public class MyOpenProductHelper extends SQLiteOpenHelper {
    public static int VERSION = 1;

    public MyOpenProductHelper(@Nullable Context context) {
        super(context, DBLocal.DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        crearTablaProductos(db);
        ArrayList<Producto> platosPrincipales = ListaPlatosPrincipales.listadoProductos();
        for(Producto p : platosPrincipales){
            insertarProducto(p,db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newVersion) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + DBLocal.TABLE_PRODUCTO);
    }

    public void crearTablaProductos(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+DBLocal.TABLE_PRODUCTO+"(id TEXT PRIMARY KEY, nombre TEXT, descripcion TEXT, precio INTEGER, imagen INTEGER, favorito INTEGER, categoria TEXT)");
    }

    public void insertarProducto(Producto p , SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(DBLocal.TB_PRODUCTO.ID, p.getId());
        cv.put(DBLocal.TB_PRODUCTO.NOMBRE, p.getNombre());
        cv.put(DBLocal.TB_PRODUCTO.DESCRIPCION, p.getDescripcion());
        cv.put(DBLocal.TB_PRODUCTO.PRECIO, p.getPrecio());
        cv.put(DBLocal.TB_PRODUCTO.IMAGEN, p.getImagen());
        cv.put(DBLocal.TB_PRODUCTO.FAVORITO, p.isFavorito());
        cv.put(DBLocal.TB_PRODUCTO.CATEGORIA, p.getCategoria());

        db.insert(DBLocal.TABLE_PRODUCTO, null, cv);
    }

    public void actualizarFavoritoProducto(int favorito, String id, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(DBLocal.TB_PRODUCTO.FAVORITO, favorito);
        cv.put(DBLocal.TB_PRODUCTO.ID, id);
        String[] arg = new String[]{""+id};
        db.update(DBLocal.TABLE_PRODUCTO, cv, "id=?", arg);
        //db.insert(DBLocal.TABLE_PRODUCTOS, null, cv);
    }

    public void eliminarProducto(String id, SQLiteDatabase db){
        String[] arg = new String[]{""+id};
        db.delete(DBLocal.TABLE_PRODUCTO,"id=?", arg);
    }

    public Cursor leerProductos(SQLiteDatabase db){
        return db.query(DBLocal.TABLE_PRODUCTO, null, null, null, null, null, null);
    }

    public Cursor select_all_favorite_products(SQLiteDatabase db){
        String sql = "Select * from "+DBLocal.TABLE_PRODUCTO+" where " + DBLocal.TB_PRODUCTO.FAVORITO +"="+ 1;
        return db.rawQuery(sql, null,null);
    }

    public Cursor select_by_id(String id, SQLiteDatabase db){
        String sql = "Select * from "+DBLocal.TABLE_PRODUCTO+" where " + DBLocal.TB_PRODUCTO.ID +"='"+ id +"'" ;
        return db.rawQuery(sql, null,null);
    }


}