package com.example.actividad2_ejer2v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularCubo(View view){

        EditText entrada = findViewById(R.id.numero);
        TextView salida = findViewById(R.id.txtResultado);



        int numero = Integer.parseInt(entrada.getText().toString()) ;
        numero = (int) Math.pow(numero,3);
        String strNumero = String.valueOf(numero);

        salida.setText(strNumero);

        if(numero >= 100){

            Toast.makeText(this, "Eres muy afortunado", Toast.LENGTH_SHORT).show();
        }
    }
}