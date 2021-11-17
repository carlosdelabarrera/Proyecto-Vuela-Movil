package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Vuelos extends AppCompatActivity {

    ListView lista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vuelos);
        getSupportActionBar().hide();

        lista=findViewById(R.id.ListViewId);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayVuelos,
                android.R.layout.simple_list_item_1);

        lista.setAdapter(adaptador);

    }
}