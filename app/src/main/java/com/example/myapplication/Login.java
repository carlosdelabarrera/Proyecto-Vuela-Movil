package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();

    }

    public void Volver(View view) {
        Intent intent = new Intent(this, Bienvanida.class);
        startActivity(intent);
    }
    public void registro(View view){
        Intent intent = new Intent(this,Registro.class);
        startActivity(intent);
    }
}
