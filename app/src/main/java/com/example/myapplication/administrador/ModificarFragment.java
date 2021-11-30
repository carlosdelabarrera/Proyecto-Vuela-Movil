package com.example.myapplication.administrador;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ModificarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ModificarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ModificarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ModificarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ModificarFragment newInstance(String param1, String param2) {
        ModificarFragment fragment = new ModificarFragment();
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
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_modificar, container, false);
        button= view.findViewById(R.id.fragment_modificar_button);
        button.setOnClickListener(v -> {


            EditText editText1 = (EditText) view.findViewById(R.id.fragment_modificar_1);
            EditText editText2 = (EditText) view.findViewById(R.id.fragment_modificar_2);
            EditText editText3 = (EditText) view.findViewById(R.id.fragment_modificar_3);
            EditText editText4 = (EditText) view.findViewById(R.id.fragment_modificar_4);
            EditText editText5 = (EditText) view.findViewById(R.id.fragment_modificar_5);
            EditText editText6 = (EditText) view.findViewById(R.id.fragment_modificar_6);
            EditText editText7 = (EditText) view.findViewById(R.id.fragment_modificar_7);


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

            try {
                int cant = bd.update("empresa_de_aviacion", registro, "id_vuelo=" + id_vuelo, null);
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