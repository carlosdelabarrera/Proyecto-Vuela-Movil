package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper  extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuario_agencia ( CC int not null,nombre varchar(50),edad varchar(50),correo varchar(50),telefono varchar (50),primary key (CC))");
        db.execSQL("CREATE TABLE empresa_de_aviacion(id_vuelo int not null,ciudad_salida varchar(30),ciudad_llegada varchar(30),fecha_salida varchar(12),frecuencia int not null,precio_ruta int not null,tiempo_estimado varchar(40),primary key (Id_vuelo))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
