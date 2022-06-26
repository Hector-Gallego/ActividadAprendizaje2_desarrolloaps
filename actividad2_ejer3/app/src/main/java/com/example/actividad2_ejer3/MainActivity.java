package com.example.actividad2_ejer3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void personalizarTexto(View view){

        EditText txtEntrada = findViewById(R.id.txtEntrada);
        RadioButton rNormal = findViewById(R.id.rNormal);
        TextView txtSalida = findViewById(R.id.txtSalida);

        if(rNormal.isChecked()){
            txtSalida.setText(txtEntrada.getText().toString());

        }else{

            String texto = txtEntrada.getText().toString();
            StringBuilder invertido = new StringBuilder(texto);
            String textoInvertido = invertido.reverse().toString();
            txtSalida.setText(textoInvertido);

        }
    }
}