package com.example.actividad2_ejer5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText eTxtEntrada;
    Button btnAgregra, btnEliminar, btnActualizar;
    ArrayList<String> programas = new ArrayList<String>(); //foods
    ArrayAdapter<String> adapter;

    Integer indexVal;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listaProgramas); // lv
        eTxtEntrada = findViewById(R.id.eTxtEntrada);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnAgregra = findViewById(R.id.btnAgregar);

        // adaptador
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, programas);
        listView.setAdapter(adapter);

//
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();
                indexVal = i;
                eTxtEntrada.setText(item);
                btnEliminar.setEnabled(true);
                btnActualizar.setEnabled(true);
            }
        });

    }

    public void agregar(View view) {


        String nomPrograma = eTxtEntrada.getText().toString();


        if (!nomPrograma.isEmpty() && nomPrograma.length() > 0) {
            programas.add(nomPrograma);
            adapter.notifyDataSetChanged();
            eTxtEntrada.setText("");
            Toast.makeText(this, "Programa Agregado con exito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error, el campo esta vacio", Toast.LENGTH_SHORT).show();
        }
    }


    public void eliminar(View view) {


        String nomPrograma = eTxtEntrada.getText().toString();

        if (!nomPrograma.isEmpty() && nomPrograma.length() > 0) {
            adapter.remove(programas.get(indexVal));
            adapter.notifyDataSetChanged();
            eTxtEntrada.setText("");
            Toast.makeText(this, "Programa Eliminado con exito", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Error, seleccione un programa", Toast.LENGTH_SHORT).show();
        }


    }

    public void actualizar(View view) {
        String nomPrograma = eTxtEntrada.getText().toString();

        if (!nomPrograma.isEmpty() && nomPrograma.length() > 0) {

            programas.set(indexVal, nomPrograma);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Programa Editado con Exito", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Error, seleccione un programa", Toast.LENGTH_SHORT).show();
        }
    }

}

