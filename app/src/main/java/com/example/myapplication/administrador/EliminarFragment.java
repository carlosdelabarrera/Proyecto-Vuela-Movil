package com.example.myapplication.administrador;

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
 * Use the {@link EliminarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EliminarFragment extends Fragment {
    View view;
    Button button;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EliminarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EliminarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EliminarFragment newInstance(String param1, String param2) {
        EliminarFragment fragment = new EliminarFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_eliminar, container, false);
        button = view.findViewById(R.id.fragment_eliminar_button);
        button.setOnClickListener(v -> {
            EditText editText1 = (EditText) view.findViewById(R.id.fragment_eliminar_1);
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(view.getContext(),
                    "base_datos2", null, 1);

            SQLiteDatabase bd = admin.getWritableDatabase();
            Integer id_vuelo = Integer.parseInt(editText1.getText().toString());
            int cant = bd.delete("empresa_de_aviacion", "id_vuelo=" + id_vuelo, null);
            bd.close();
            editText1.setText("");

            if (cant == 1)
                Toast.makeText(view.getContext(), "Se borró el artículo con dicho código",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(view.getContext(), "No existe un artículo con dicho código",
                        Toast.LENGTH_SHORT).show();
        });
        // Inflate the layout for this fragment
        return view;
    }
}