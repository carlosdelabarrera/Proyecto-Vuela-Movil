package com.example.myapplication.admin;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class admin {

    @PrimaryKey
    @NonNull
    private Integer CC;
    @NonNull
    private  String nombre;
    @NonNull
    private  String edad;
    @NonNull
    private  String correo;
    @NonNull
    private  String telefono;

    public admin(@NonNull Integer CC, @NonNull String nombre, @NonNull String edad, @NonNull String correo, @NonNull String telefono) {
        this.CC = CC;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
    }

    @NonNull
    public Integer getCC() {
        return CC;
    }

    public void setCC(@NonNull Integer CC) {
        this.CC = CC;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getEdad() {
        return edad;
    }

    public void setEdad(@NonNull String edad) {
        this.edad = edad;
    }

    @NonNull
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(@NonNull String correo) {
        this.correo = correo;
    }

    @NonNull
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NonNull String telefono) {
        this.telefono = telefono;
    }
}
