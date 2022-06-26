package com.example.actividad2_ejer4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // declaracion de variables
    int contador = 1;
    double valorProducto;
    double totalproductos = 0;
    double compraAlta = 0;
    double totalIvaDes = 0;
    double descuento = 0;
    double iva = 0;

    //declaracion de elementos
    EditText txtProducto;
    TextView txtTotal;
    TextView txtIva;
    TextView txtDescuento;
    TextView txtCompraAlta;
    TextView txtTolatIvaDes;
    Button btnAgregar;

    public void facturacion(View view) {


        inicializarElementos();


        if (contador <= 5) {

            valorProducto = Double.parseDouble(txtProducto.getText().toString());
            totalproductos = totalproductos + valorProducto;
            txtTotal.setText("Total compra ---> " + totalproductos);



            if (valorProducto >= compraAlta) {
                compraAlta = valorProducto;
            }

            if (contador == 5) {
                btnAgregar.setText("Imprimir Factura");
                txtProducto.setEnabled(false);
            }

        } else {

            iva = (totalproductos * 0.19);
            descuento = totalproductos * 0.10;
            totalIvaDes = (totalproductos + iva) - descuento;

            txtTotal.setText("Total compra ---> " + totalproductos);
            txtIva.setText("Total iva ---> " + iva);

            if (totalproductos >= 100000) {
                txtDescuento.setText("Descuento 10% ---> " + descuento);
            } else {
                txtDescuento.setText("No aplica Descuento");
            }
            txtCompraAlta.setText("Compra mas Alta ---> " + compraAlta);
            txtTolatIvaDes.setText("Total A pagar ---> " + totalIvaDes);

            btnAgregar.setText("Agregar");


        }

        contador++;
        txtProducto.setText("");

    }

    public void inicializarElementos() {

        txtProducto = findViewById(R.id.txtProducto);
        txtTotal = findViewById(R.id.txtTotal);
        txtIva = findViewById(R.id.txtIva);
        txtDescuento = findViewById(R.id.txtdescuento);
        txtCompraAlta = findViewById(R.id.txtCompraAlta);
        txtTolatIvaDes = findViewById(R.id.txtTotalIvaDes);
        btnAgregar = findViewById(R.id.btnAgregar);

    }

    public void limpiarRegistro(View view){
        btnAgregar.setText("agregar");
        txtProducto.setText("");
        txtTotal.setText("");
        txtIva.setText("");
        txtDescuento.setText("");
        txtTolatIvaDes.setText("");
        txtCompraAlta.setText("");

        txtProducto.setEnabled(true);

        contador = 1;
        valorProducto =0;
        totalproductos = 0;
        compraAlta = 0;
        totalIvaDes = 0;
        descuento = 0;
        iva = 0;
    }


}