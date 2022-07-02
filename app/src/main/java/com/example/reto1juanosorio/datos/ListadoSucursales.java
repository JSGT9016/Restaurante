package com.example.reto1juanosorio.datos;

import com.example.reto1juanosorio.modelo.Sucursal;

import java.util.ArrayList;

public class ListadoSucursales {

    private static ArrayList<Sucursal> sucursales;

    public static ArrayList<Sucursal> listadoSucursales(){
        sucursales = new ArrayList<Sucursal>();

        sucursales.add(new Sucursal("3001","Sucursal Palatino","Carrera. 7 No. 138-33","https://www.google.com/maps?ll=4.715602,-74.029573&z=19&t=m&hl=es-ES&gl=ES&mapclient=embed&q=Centro+Comercial+Palatino+Ak.+7+%23138-33+Bogot%C3%A1+Colombia"));
        sucursales.add(new Sucursal("3002","Sucursal Unicentro","Cra. 15 #124-30, Bogotá","https://www.google.com/maps/dir//Ak.+15+%23124-30,+Bogot%C3%A1/@4.7029232,-74.0440883,17z/data=!4m8!4m7!1m0!1m5!1m1!1s0x8e3f9ab26f69ce4f:0xa96d01709864823d!2m2!1d-74.0418996!2d4.7029232"));
        sucursales.add(new Sucursal("3003","Sucursal Santa Fe","Calle 185 No. 45 - 03 Autopista Norte","https://www.google.com/maps?ll=4.762603,-74.046269&z=17&t=m&hl=es-419&gl=CO&mapclient=embed&cid=9084627704985043362"));
        sucursales.add(new Sucursal("3004","Sucursal Portal 80","Transversal 100A #80A - 20","https://www.google.com/maps/place/Portal+80+-+Centro+Comercial/@4.7112259,-74.1137085,17z/data=!3m1!4b1!4m5!3m4!1s0x8e3f84ad891f3a61:0x43f82c4304cc090d!8m2!3d4.7112259!4d-74.1115198"));
        sucursales.add(new Sucursal("3005","Sucursal Titan Plaza","Av. Boyacá #80-94","https://www.google.com/maps/place/Titan+Plaza+Shopping+Mall/@4.694708,-74.0883767,17z/data=!3m1!4b1!4m5!3m4!1s0x8e3f9b25144634c9:0xaa39a3ad6b78b4cb!8m2!3d4.694708!4d-74.086188"));

        return sucursales;
    }
}
