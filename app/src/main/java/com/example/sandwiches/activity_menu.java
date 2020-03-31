package com.example.sandwiches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class activity_menu extends AppCompatActivity {

    LinearLayout contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setTitle(R.string.navbar_sandwiches);
        contenedor = (LinearLayout) findViewById(R.id.contenedor);

        final ArrayList<Sandwich> lista = new ArrayList<Sandwich>();
        lista.add(new Sandwich(getString(R.string.str_italiano_nombre),Integer.parseInt(getString(R.string.int_italiano_img_id)),getString(R.string.str_italiano_descripcion),Integer.parseInt(getString(R.string.int_italiano_precio))));
        lista.add(new Sandwich(getString(R.string.str_chacarero_nombre),Integer.parseInt(getString(R.string.int_chacarero_img_id)),getString(R.string.str_chacarero_descripcion),Integer.parseInt(getString(R.string.int_chacarero_precio))));
        lista.add(new Sandwich(getString(R.string.str_barrosluco_nombre),Integer.parseInt(getString(R.string.int_barrosluco_img_id)),getString(R.string.str_barrosluco_descripcion),Integer.parseInt(getString(R.string.int_barrosluco_precio))));
        lista.add(new Sandwich(getString(R.string.str_barrosjarpa_nombre),Integer.parseInt(getString(R.string.int_barrosjarpa_img_id)),getString(R.string.str_barrosjarpa_descripcion),Integer.parseInt(getString(R.string.int_barrosjarpa_precio))));
        lista.add(new Sandwich(getString(R.string.str_vegetariano_nombre),Integer.parseInt(getString(R.string.int_vegetariano_img_id)),getString(R.string.str_vegetariano_descripcion),Integer.parseInt(getString(R.string.int_vegetariano_precio))));

        for(final Sandwich s:lista){
            Button btn = (Button) new Button(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(900,250);
            params.setMargins(0,0,0,50);
            btn.setLayoutParams(params);
            btn.setPadding(0,0,0,0);
            //btn.setId(s.id_imagen);
            btn.setText(s.nombre);
            btn.setTextSize(28);

            //btn.setId(s.id_imagen);
            btn.setBackgroundResource(R.color.colorButton);



            //btn.setBackgroundColor(this.getResources().getColor(R.color.colorButton));
            btn.setTextColor(this.getResources().getColor(R.color.colorText));
            contenedor.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity_menu.this, activity_detallesandwich.class);
                    intent.putExtra("id", s.id);
                    intent.putExtra("nombre", s.nombre);
                    intent.putExtra("descripcion", s.descripcion);
                    intent.putExtra("precio", s.precio);
                    startActivity(intent);
                }
            });

            //btnsContainer.addView(buttonContainer);

        }
        //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(900, 250, Gravity.CENTER);
        //Agrega contenedor con botones.
        //buttonContainer.addContentView(btnsContainer);
    }

    public class Sandwich implements Serializable {

        //private int id;
        private String nombre;
        private int id;
        private String descripcion;
        private int precio;

        public Sandwich(/*int id,*/ String nombre, int id, String descripcion, int precio){
            //this.id = id;
            this.nombre = nombre;
            this.id = id;
            this.descripcion = descripcion;
            this.precio = precio;
        }

       /* public int getId(){
            return this.id;
        }*/

        public String getNombre(){
            return this.nombre;
        }

        public int getId(){
            return this.id;
        }

        public String getDescripcion(){
            return this.descripcion;
        }

        public int getPrecio(){
            return this.precio;
        }
    }
}
