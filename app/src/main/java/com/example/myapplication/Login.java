package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();


    }


    public void Volver (View view){


            Intent intent = new Intent(this, Bienvanida.class);
            startActivity(intent);
    }




    public void admin (View view){

        EditText name = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText password = (EditText) findViewById (R.id.editTextNumberPassword);
        int a = 0;


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "base_datos2", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();




            try {
                Integer contraseña = Integer.parseInt(password.getText().toString());
                String nombre = name.getText().toString();


                Cursor fila = bd.rawQuery("SELECT * FROM usuario_agencia WHERE nombre = " + '"' + nombre + '"' + " and  CC = " + contraseña,null);

                if(fila.moveToFirst()){

                    Integer pass = fila.getInt(0);
                    String usua = fila.getString(1);


                    if(nombre.equals(usua)&&contraseña.equals(pass)){

                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                    }



                }
                else if(nombre.equals("usuario") && contraseña.equals(1234)){
                    Intent intent = new Intent(this, Main_Activity_admin.class);
                    startActivity(intent);
                }
                else if(nombre.equals("usuario") && contraseña.equals(1)){
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }

                else{
                    Toast toast=Toast.makeText(this,"Datos incorrectos",Toast.LENGTH_LONG);
                    toast.show();
                }

            } catch (Exception e) {
                Toast toast=Toast.makeText(this,"Error" + e.getMessage(), Toast.LENGTH_LONG);

                toast.show();
            }

    /*    if (name.getText().toString().equals("usuario") && password.getText().toString().equals("usuario") ){

            Intent intent = new Intent(this, Main_Activity_admin.class);
            startActivity(intent);
        }*/

    }

    public void registro (View view){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
        }


    }
