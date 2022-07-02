package com.example.reto1juanosorio.datos;

import com.example.reto1juanosorio.R;
import com.example.reto1juanosorio.modelo.Producto;

import java.util.ArrayList;

public class ListaPlatosPrincipales {

    private static final ArrayList<Producto> platos = new ArrayList<>();

    public static ArrayList<Producto> listadoProductos(){
        platos.add(
                new Producto(
                        "1001",
                        "Pasta",
                        "Rica pasta con bolognesa",
                        "10000",
                        R.drawable.pasta,
                        "Plato principal"
                        ));

        platos.add(
                new Producto(
                        "1002",
                        "Pollo",
                        "Pollo asado a la perfeccion",
                        "11000",
                        R.drawable.pollo,
                        "Plato principal"
                )
        );

        platos.add(
                new Producto(
                        "1003",
                        "Pizza",
                        "Pizza con peperoni, la mejor del mercado",
                        "12000",
                        R.drawable.pizza,
                        "Plato principal"
                )
        );

        platos.add(
                new Producto(
                        "1004",
                        "Hamburguesa",
                        "Hamburguesa con carne al carbon",
                        "13000",
                        R.drawable.hamburguesa,
                        "Plato principal"
                )
        );

        platos.add(
                new Producto(
                        "1005",
                        "Fideos chinos",
                        "Fideos chinos al mejor estilo oriental",
                        "14000",
                        R.drawable.fideos_chinos,
                        "Plato principal"
                )
        );

        platos.add(
                new Producto(
                        "1006",
                        "Huevos con tocino",
                        "Huevos fritos con el tocino de la mejor calidad",
                        "15000",
                        R.drawable.huevos_tocino,
                        "Plato principal"
                )
        );

        platos.add(
                new Producto(
                        "1007",
                        "Papas a la francesa",
                        "Papas a la francesa al estilo clasico con un toque modernoa",
                        "16000",
                        R.drawable.papas_francesa,
                        "Plato principal"
                )
        );
        platos.add(
                new Producto(
                        "2001",
                        "Cupcake",
                        "Ponque sencillo con crema de muchos colores",
                        "6000",
                        R.drawable.cupcake,
                        "Postre"
                )
        );
        platos.add(
                new Producto(
                        "2002",
                        "Dulce leche",
                        "Como lo hacia la abuela",
                        "7000",
                        R.drawable.dulce_leche,
                        "Postre"
                )
        );
        platos.add(
                new Producto(
                        "2003",
                        "Helado",
                        "El mejor helado del pais!",
                        "8000",
                        R.drawable.helado,
                        "Postre"
                )
        );
        platos.add(
                new Producto(
                        "2004",
                        "Flurry Oreo",
                        "Helado de vainilla con trocitos de galleta Oreo",
                        "9000",
                        R.drawable.mc_flurry_oreo,
                        "Postre"
                )
        );
        platos.add(
                new Producto(
                        "2005",
                        "Postre brownie",
                        "Torta de brownie con arequipe",
                        "10000",
                        R.drawable.postre_brownie,
                        "Postre"
                )
        );
        return platos;
    }
}
