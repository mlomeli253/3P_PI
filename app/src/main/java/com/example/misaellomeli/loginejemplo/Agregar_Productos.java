package com.example.misaellomeli.loginejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Agregar_Productos extends AppCompatActivity {

    private EditText descripcion, precio, vendedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar__productos);
        descripcion=(EditText)findViewById(R.id.txt_cliente_add_name);
        precio=(EditText)findViewById(R.id.txt_cliente_add_phone);
        vendedor=(EditText)findViewById(R.id.txt_cliente_add_email);
    }

    public void AgregarP (View view){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.1.72:8080/api/vendedores/login",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response!=null){
                            Toast.makeText(Agregar_Productos.this,response,Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Agregar_Productos.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("descripcion", descripcion.getText().toString().trim());
                params.put("precio", precio.getText().toString().trim());
                params.put("vendedor", vendedor.getText().toString().trim());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
