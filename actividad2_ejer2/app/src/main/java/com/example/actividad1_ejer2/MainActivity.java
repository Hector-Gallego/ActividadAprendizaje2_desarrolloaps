package com.example.actividad1_ejer2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzarDados(View view){

        TextView dado1 = findViewById(R.id.dado1);
        TextView dado2 = findViewById(R.id.dado2);

        int numDado1  = (int) (Math.random()*6)+1;
        int numDado2  = (int) (Math.random()*6)+1;

        dado1.setText(""+numDado1);
        dado2.setText(""+numDado2);


    }
}