package com.example.misaellomeli.loginejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragmento_productos extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_fragmento_productos, container, false);
        FloatingActionButton btnAgregar = (FloatingActionButton) view.findViewById(R.id.btn_clientes_producto);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarP(v);
            }
        });
        return view;
    }

    public void agregarP(View view){
        Intent i = new Intent(getActivity(), Agregar_Productos.class);
        startActivity(i);
    }

    public void buscar(View view){
        Intent i = new Intent(getActivity(), Busqueda.class);
        startActivity(i);
    }

    public void ventas(View view){
        Intent i = new Intent(getActivity(), Agregar_ventas.class);
        startActivity(i);
    }
}
