package com.example.reto1juanosorio.modelo;

import java.util.ArrayList;

public class Factura {

    private String id;
    private ArrayList<ElementoFactura> elementosFactura;
    private double precioTotal;

    public Factura(String id){
        this.id =id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<ElementoFactura> getElementosFactura() {
        return elementosFactura;
    }

    public void setElementoFactura(ElementoFactura item) {
        this.elementosFactura.add(item);
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        double sum = 0.0;
        for(ElementoFactura i : elementosFactura){
            //sum+=i.getTotalValorProducto();
        }
        this.precioTotal = sum;
    }
}
