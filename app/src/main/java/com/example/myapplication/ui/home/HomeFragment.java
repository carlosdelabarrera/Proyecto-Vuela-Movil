package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Login;
import com.example.myapplication.MainActivity;
import com.example.myapplication.Main_Activity_admin;
import com.example.myapplication.R;
import com.example.myapplication.Registro;
import com.example.myapplication.administrador.adapters.VuelosAdapter;
import com.example.myapplication.administrador.adapters.vuelosdatos;
import com.example.myapplication.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    Button button;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Intent intent = new Intent(getContext(), MainActivity.class);
        //startActivity(intent);
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }
    private VuelosAdapter mAdapter=new VuelosAdapter();
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        button = view.findViewById(R.id.button14);
//        button.setOnClickListener(v -> {
//            Intent intent = new Intent(getContext(), Registro.class);
//            startActivity(intent);
//        });
        // Inflate the layout for this fragment

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_lista);


        RecyclerView mRecyclerview=view.findViewById(R.id.RecycleFragmentHome);
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
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}