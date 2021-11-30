package com.example.myapplication.administrador.adapters;

public class vuelosdatos {

    private String ciudad_origen;

    public vuelosdatos(String ciudad_origen) {
        this.setCiudad_origen(ciudad_origen);
    }

    public String getCiudad_origen() {
        return ciudad_origen;
    }

    public void setCiudad_origen(String ciudad_origen) {
        this.ciudad_origen = ciudad_origen;
    }
}
