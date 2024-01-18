package com.zagloss.recyclerviewdivisas;

public class DvModel {
    public String name;
    public float cantidad;

    public DvModel(String name, float cantidad) {
        this.name = name;
        this.cantidad = cantidad;
    }

    public String getName() {
        return name;
    }

    public float getCantidad() {
        return cantidad;
    }
}
