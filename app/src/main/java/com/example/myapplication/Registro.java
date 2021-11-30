package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Button button = findViewById(R.id.ButtonRegistro);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = (EditText) findViewById(R.id.Registro1);
                EditText editText2 = (EditText) findViewById(R.id.Registro2);
                EditText editText3 = (EditText) findViewById(R.id.Registro3);
                EditText editText4 = (EditText) findViewById(R.id.Registro4);
                EditText editText5 = (EditText) findViewById(R.id.Registro5);

                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "base_datos2", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                Integer codigo = Integer.parseInt(editText1.getText().toString());
                String nombre = editText2.getText().toString();
                String edad = editText3.getText().toString();
                String correo= editText4.getText().toString();
                String telefono= editText5.getText().toString();

                ContentValues registro = new ContentValues();
                registro.put("CC", codigo);
                registro.put("nombre", nombre);
                registro.put("edad", edad);
                registro.put("correo",correo);
                registro.put("telefono",telefono);

                bd.insert("usuario_agencia", null, registro);
                bd.close();
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");

                Toast.makeText(getApplicationContext(), "Se cargaron los datos del artículo",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Volver(View view) {
        Intent intent = new Intent(this, Bienvanida.class);
        startActivity(intent);
    }


}