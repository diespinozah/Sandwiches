package com.example.sandwiches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_detallesandwich extends AppCompatActivity {

    public int imagen;
    String nombre;
    String descripcion;
    int precio;

    private ImageView img_sandwich;
    private TextView txt_nombre;
    private TextView txt_descripcion;
    private TextView txt_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallesandwich);
        Intent intent = getIntent();
        imagen = intent.getIntExtra("id",-1);
        nombre = intent.getStringExtra("nombre");
        descripcion = intent.getStringExtra("descripcion");
        precio = intent.getIntExtra("precio",0);
        img_sandwich = (ImageView) findViewById(R.id.img_sandwich);
        txt_nombre = (TextView) findViewById(R.id.txt_nombre);
        txt_descripcion = (TextView) findViewById(R.id.txt_descripcion);
        txt_precio = (TextView) findViewById(R.id.txt_precio);
        getSupportActionBar().setTitle(nombre);
        txt_nombre.setText(nombre);
        txt_descripcion.setText(descripcion);
        txt_precio.setText("Precio: $" + String.valueOf(precio));



       switch(imagen){

            case 1: img_sandwich.setImageResource(R.drawable.italiano);
            break;
            case 2: img_sandwich.setImageResource(R.drawable.chacarero);
            break;
            case 3: img_sandwich.setImageResource(R.drawable.barrosluco);
            break;
            case 4: img_sandwich.setImageResource(R.drawable.barrosjarpa);
            break;
            case 5: img_sandwich.setImageResource(R.drawable.vegetariano);
            break;
        }


        //activity_menu.Sandwich sandwich = (activity_menu.Sandwich) intent.getSerializableExtra("sandwich");
        //getSupportActionBar().setTitle(sandwich.getNombre());

    }
}
