package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        EditText editText1 = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText editText2 = (EditText) findViewById (R.id.editTextNumberPassword);
        if (editText1.getText().toString().equals("ADMIN") && editText2.getText().toString().equals("ADMIN") ){

            Intent intent = new Intent(this, Adminitrador.class);
            startActivity(intent);
        }

    }

    public void registro (View view){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
        }


    }
