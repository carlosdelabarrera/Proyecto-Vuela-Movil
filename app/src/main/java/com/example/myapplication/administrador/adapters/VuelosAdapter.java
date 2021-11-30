package com.example.myapplication.administrador.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class VuelosAdapter extends RecyclerView.Adapter<VuelosAdapter.ViewHolder> {
    private ArrayList<vuelosdatos> mDataSet=new ArrayList<>();


    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        public TextView textView6;
        public ViewHolder(TextView tv) {
            super(tv);
            textView6 = tv;
        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)


    public VuelosAdapter() {
        this.mDataSet = new ArrayList<>();
    }

    public void setmDataSet(ArrayList<vuelosdatos> dataSet)
    {   mDataSet=dataSet;
        notifyDataSetChanged();
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // Creamos una nueva vista
        TextView tv = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vuelos_view, parent, false);

        // Aquí podemos definir tamaños, márgenes, paddings, etc
        return new ViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.textView6.setText(mDataSet.get(i).getCiudad_origen());
    }

    // Este método asigna valores para cada elemento de la lista
    

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejem, si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
