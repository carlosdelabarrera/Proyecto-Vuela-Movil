package com.example.myapplication.administrador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.administrador.adapters.VuelosAdapter;
import com.example.myapplication.administrador.adapters.vuelosdatos;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaFragment newInstance(String param1, String param2) {
        ListaFragment fragment = new ListaFragment();
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
    private VuelosAdapter mAdapter=new VuelosAdapter();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_lista, container, false);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_lista);


        RecyclerView mRecyclerview=view.findViewById(R.id.myrecycler_view);
        mRecyclerview.setHasFixedSize(true);


        // Nuestro RecyclerView usará linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerview.setLayoutManager(mLayoutManager);

        ArrayList<vuelosdatos> myVuelos = new ArrayList<>();
        myVuelos.add(new vuelosdatos("Bogota,Cali,4:00,50000,45"));
        myVuelos.add(new vuelosdatos("Medellin,Cartagena,8:00,90000,89"));
        myVuelos.add(new vuelosdatos("Cali,Santa Marta,14:00,85000,90"));
        myVuelos.add(new vuelosdatos("Bucaramanga,Armenia,18:00,56000,60"));
        mAdapter.setmDataSet(myVuelos);

        //asociamos un Adapter(ver mas adelante como definirlo)
        //mAdapter = new VuelosAdapter();
        mRecyclerview.setAdapter(mAdapter);





        return view;
    }
}