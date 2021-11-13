package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Adminitrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminitrador);
    }
    public void Volver_login (View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void agregar_usuario(View view) {
        EditText editText1 = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText editText2 = (EditText) findViewById(R.id.editTextTextPersonName3);
        EditText editText3 = (EditText) findViewById(R.id.editTextTextPersonName4);
        EditText editText4 = (EditText) findViewById(R.id.editTextTextPersonName5);
        EditText editText5 = (EditText) findViewById(R.id.editTextTextPersonName6);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "base_datos", null, 1);
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

        Toast.makeText(this, "Se cargaron los datos del artículo",
                Toast.LENGTH_SHORT).show();

    }
    public void consultaporcodigo(View v) {

        EditText editText1 = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText editText2 = (EditText) findViewById(R.id.editTextTextPersonName3);
        EditText editText3 = (EditText) findViewById(R.id.editTextTextPersonName4);
        EditText editText4 = (EditText) findViewById(R.id.editTextTextPersonName5);
        EditText editText5 = (EditText) findViewById(R.id.editTextTextPersonName6);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "base_datos", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();
        Integer codigo = Integer.parseInt(editText1.getText().toString());

        Cursor fila = bd.rawQuery("select nombre,edad,correo,telefono from usuario_agencia where CC =" + codigo, null);

        if (fila.moveToFirst()) {
            editText2.setText(fila.getString(0));
            editText3.setText(fila.getString(1));
            editText4.setText(fila.getString(2));
            editText5.setText(fila.getString(3));
        } else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
}