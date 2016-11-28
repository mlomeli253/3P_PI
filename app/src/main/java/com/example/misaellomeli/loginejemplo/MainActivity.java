package com.example.misaellomeli.loginejemplo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    //private EditText correo,contrasena;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView lblSignUp;
    private static final String URL = "http://salesapi2016.azurewebsites.net/api/vendedores/login";
    private static final String KEY_EMAIL = "correo";
    private static final String KEY_PASSWORD = "clave";
    private SharedPreferences data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        txtEmail = (EditText) findViewById(R.id.txt_cliente_add_name);
        txtPassword = (EditText) findViewById(R.id.txt_cliente_add_address);
        lblSignUp = (TextView) findViewById(R.id.lbl_signup);
        lblSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IniciarSesion.class);
                startActivity(intent);
            }
        });
        if (data.contains("email")) {
            txtEmail.setText(data.getString("email", ""));
            txtPassword.requestFocus();
        }
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    login();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        /*correo=(EditText)findViewById(R.id.editText4);
        contrasena=(EditText)findViewById(R.id.editText5);*/

    }

    private void login() throws JSONException {
        /*final String email = txtEmail.getText().toString().trim();
        final String password = txtPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        HashMap<String, String> map = jsonToMap(response);
                        if (map.get("id") != null) {
                            SharedPreferences.Editor editor = data.edit();
                            editor.clear();
                            editor.putString("id", map.get("id"));
                            editor.putString("email", map.get("correo"));
                            editor.putString("firstName", map.get("nombre"));
                            editor.putString("lastName", map.get("apellido"));
                            editor.putString("phone", map.get("telefono"));
                            editor.apply();*/
                            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                            startActivity(intent);
                       /* } else {
                            Toast.makeText(MainActivity.this, "Correo o contraseña inválidos",Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error del servidor, intenta más tarde",Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_EMAIL, email);
                params.put(KEY_PASSWORD, password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public HashMap<String, String> jsonToMap(String jsonString) {

        HashMap<String, String> map = new HashMap<String, String>();
        JSONObject jObject = null;
        try {
            jObject = new JSONObject(jsonString);
            Iterator<?> keys = jObject.keys();
            while(keys.hasNext()) {
                String key = (String)keys.next();
                String value = jObject.getString(key);
                map.put(key, value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;*/
    }
}
