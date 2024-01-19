package com.zagloss.recyclerviewdivisas;

public class DvModel {
    public String name;
    public float cantidad;
    public String moneda;

    public DvModel(String name, float cantidad, String moneda) {
        this.name = name;
        this.cantidad = cantidad;
        this.moneda = moneda;
    }

    public String getName() {
        return name;
    }

    public float getCantidad() {
        return cantidad;
    }

    public String getMoneda(){return moneda;}
}
