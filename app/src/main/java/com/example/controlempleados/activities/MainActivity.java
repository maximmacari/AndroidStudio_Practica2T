package com.example.controlempleados.activities;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.controlempleados.R;
import com.example.controlempleados.bean.Empleado;
import com.example.controlempleados.dao.DataBaseWorkers;
import com.example.controlempleados.utiles.AdapterEmpleados;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private RecyclerView recView;
    private ArrayList<Empleado> datos;
    private AdapterEmpleados adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO HAY QUE CONVERTIR el fichero 'Workers.sql' que se encuentra en la raiz del proyecto a .db  ;; Creo que se puede de csv a SQLite
        /*
           - Modelo Usuario Registrarse y entrar.
        * 1. Recycler view: handleview, modelo,
        * 2. BBDD
        * 3.
        * */

        recView = (RecyclerView) findViewById(R.id.lista_empleados);

        DataBaseWorkers dbw = new DataBaseWorkers(this, "Prueba", null, 1);


    }

    //ESTE MÉTODO SE INVOCA AL TOCAR UNA OPCIÓN DEL MENÚ
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_anhadir_empleado:
                Intent intent = new Intent(this, AnhadirEmpleadoActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_borrar_empleado:
                //TODO puede que sea mejor opción hacer un slide sobre una empleado
                break;
            case R.id.menu_acerca_de:
                Intent intent1 = new Intent(this, AcercaDeActivity.class);
                startActivity(intent1);
                break;
            case R.id.menu_salir:
                // Eliminamos preferencias de login
                SharedPreferences prefs;
                prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = prefs.edit();
                edit.putString("name", "");
                edit.putString("password", "");
                edit.commit();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //debo sobreescribir este método para cargar mi menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();//este objeto será el encargado de cargar/inlfar mi menú
        mi.inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
