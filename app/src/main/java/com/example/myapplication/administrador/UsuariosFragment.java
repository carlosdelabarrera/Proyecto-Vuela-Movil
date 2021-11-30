package com.example.myapplication.administrador;

import android.content.ContentValues;
import android.database.Cursor;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UsuariosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsuariosFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UsuariosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UsuariosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UsuariosFragment newInstance(String param1, String param2) {
        UsuariosFragment fragment = new UsuariosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    View view;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_usuarios, container, false);
        button1= view.findViewById(R.id.UsuariosAgregar);
        button1.setOnClickListener(v -> {
            EditText editText1 = (EditText) view.findViewById(R.id.Usuarios1);
            EditText editText2 = (EditText) view.findViewById(R.id.Usuarios2);
            EditText editText3 = (EditText) view.findViewById(R.id.Usuarios3);
            EditText editText4 = (EditText) view.findViewById(R.id.Usuarios4);
            EditText editText5 = (EditText) view.findViewById(R.id.Usuarios5);

            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(view.getContext(), "base_datos2", null, 1);
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

            Toast.makeText(view.getContext(), "Se cargaron los datos del artículo",
                    Toast.LENGTH_SHORT).show();
        });
        button2= view.findViewById(R.id.UsuariosConsultar);
        button2.setOnClickListener(v -> {
            EditText editText1 = (EditText) view.findViewById(R.id.Usuarios1);
            EditText editText2 = (EditText) view.findViewById(R.id.Usuarios2);
            EditText editText3 = (EditText) view.findViewById(R.id.Usuarios3);
            EditText editText4 = (EditText) view.findViewById(R.id.Usuarios4);
            EditText editText5 = (EditText) view.findViewById(R.id.Usuarios5);

            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(view.getContext(), "base_datos2", null, 1);

            SQLiteDatabase bd = admin.getWritableDatabase();
            Integer codigo = Integer.parseInt(editText1.getText().toString());

            Cursor fila = bd.rawQuery("select nombre,edad,correo,telefono from usuario_agencia where CC =" + codigo, null);

            if (fila.moveToFirst()) {
                editText2.setText(fila.getString(0));
                editText3.setText(fila.getString(1));
                editText4.setText(fila.getString(2));
                editText5.setText(fila.getString(3));
            } else
                Toast.makeText(view.getContext(), "No existe un artículo con dicho código",
                        Toast.LENGTH_SHORT).show();
            bd.close();
        });
        button3= view.findViewById(R.id.UsuariosEliminar);
        button3.setOnClickListener(v -> {

                EditText editText1 = (EditText) view.findViewById(R.id.Usuarios1);
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(view.getContext(),
                        "base_datos2", null, 1);

                SQLiteDatabase bd = admin.getWritableDatabase();
                Integer codigo = Integer.parseInt(editText1.getText().toString());
                int cant = bd.delete("usuario_agencia", "CC=" + codigo, null);
                bd.close();
                editText1.setText("");

                if (cant == 1)
                    Toast.makeText(view.getContext(), "Se borró el artículo con dicho código",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(view.getContext(), "No existe un artículo con dicho código",
                            Toast.LENGTH_SHORT).show();
        });
        button4= view.findViewById(R.id.UsuariosModificar);
        button4.setOnClickListener(v -> {

            EditText editText1 = (EditText) view.findViewById(R.id.Usuarios1);
            EditText editText2 = (EditText) view.findViewById(R.id.Usuarios2);
            EditText editText3 = (EditText) view.findViewById(R.id.Usuarios3);
            EditText editText4 = (EditText) view.findViewById(R.id.Usuarios4);
            EditText editText5 = (EditText) view.findViewById(R.id.Usuarios5);

            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(view.getContext(), "base_datos2", null, 1);


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

            try {
                int cant = bd.update("usuario_agencia", registro, "CC=" + codigo, null);
                bd.close();
                Toast.makeText(view.getContext(), "se modificaron los datos"+ String.valueOf(cant), Toast.LENGTH_SHORT)
                        .show();

            }catch (Exception e){
                Toast.makeText(view.getContext(), "no existe un artículo con el código ingresado"+ e,
                        Toast.LENGTH_SHORT).show();
            }

            //if (cant == 1)
            //else
            // Toast.makeText(view.getContext(), "no existe un artículo con el código ingresado",
            //    Toast.LENGTH_SHORT).show();
        });





        return view;
    }
}