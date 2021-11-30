package com.example.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.AdminSQLiteOpenHelper;
import com.example.myapplication.R;


public class AgregarFragment extends Fragment {


    public AgregarFragment() {
        // Required empty public constructor

    }
    View view;
    Button button;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_agregar, container, false);
        button=view.findViewById(R.id.fragment_agregar_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    EditText editText1 = (EditText) view.findViewById(R.id.fragment_agregar_1);
                    EditText editText2 = (EditText) view.findViewById(R.id.fragment_agregar_2);
                    EditText editText3 = (EditText) view.findViewById(R.id.fragment_agregar_3);
                    EditText editText4 = (EditText) view.findViewById(R.id.fragment_agregar_4);
                    EditText editText5 = (EditText) view.findViewById(R.id.fragment_agregar_5);
                    EditText editText6 = (EditText) view.findViewById(R.id.fragment_agregar_6);
                    EditText editText7 = (EditText) view.findViewById(R.id.fragment_agregar_7);


                    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(view.getContext(), "base_datos2", null, 1);
                    SQLiteDatabase bd = admin.getWritableDatabase();
                    Integer id_vuelo = Integer.parseInt(editText1.getText().toString());
                    String ciudad_salida = editText2.getText().toString();
                    String ciudad_llegada = editText3.getText().toString();
                    String fecha_salida= editText4.getText().toString();
                    Integer frecuencia = Integer.parseInt(editText5.getText().toString());
                    Integer precio_ruta = Integer.parseInt(editText6.getText().toString());
                    String tiempo_estimado= editText7.getText().toString();

                    ContentValues registro = new ContentValues();
                    registro.put("id_vuelo", id_vuelo);
                    registro.put("ciudad_salida", ciudad_salida);
                    registro.put("ciudad_llegada", ciudad_llegada);
                    registro.put("fecha_salida",fecha_salida);
                    registro.put("frecuencia",frecuencia);
                    registro.put("precio_ruta",precio_ruta);
                    registro.put("tiempo_estimado",tiempo_estimado);

                    bd.insert("empresa_de_aviacion", null, registro);
                    bd.close();
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText6.setText("");
                    editText7.setText("");

                    Toast.makeText(view.getContext(), "Se cargaron los datos del artículo", Toast.LENGTH_SHORT).show();
            }
        });
        // Inflate the layout for this fragment
        return view;

    }


}