package com.example.android.pastoturistico;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaActivity extends AppCompatActivity {
  //  String [] parques = new String[] {"Bolivar ","infantil","lajas","San Fransisco"};
    private Lista_Entrada[] datos =new Lista_Entrada[]{
          new Lista_Entrada(R.drawable.volcancumbal,"Parque Bolivar","parque compartir con familia","cra 15#16-50"),
          new Lista_Entrada(R.drawable.lajas,"Parque las lajas","parque compartir con familia","cra 15#44-30"),
          new Lista_Entrada(R.drawable.pasto,"Parque pasto","parque compartir ","cra 25#34-10"),
          new Lista_Entrada(R.drawable.pasto2,"Parque pasto2","parque compartir dos ","cra 115#24-40")};


    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        list = (ListView) findViewById(R.id.list);
        Adapter adapter = new Adapter(this, datos);
        //    ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,parques);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = ((Lista_Entrada) parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ListaActivity.this, DrawerActivity.class);
                startActivity(intent);

            }

             });
    }


    class Adapter extends ArrayAdapter<Lista_Entrada>{


        public Adapter(@NonNull Context context, Lista_Entrada[] datos) {

            super(context, R.layout.list_item,datos);

        }


        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater= LayoutInflater.from(getContext());
            View item=inflater.inflate(R.layout.list_item,null);

            TextView nombre=(TextView) item.findViewById(R.id.nombre);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.descrip);
            descrip.setText(datos[position].getDescrip());

            TextView direc = (TextView) item.findViewById(R.id.dir);
            direc.setText(datos[position].getDireccion());

            ImageView imagen= (ImageView) item.findViewById(R.id.foto);
            imagen.setImageResource(datos[position].getIdImage());


            return item;
        }
    }



}
