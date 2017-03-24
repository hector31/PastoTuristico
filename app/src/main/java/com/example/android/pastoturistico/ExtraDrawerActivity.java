package com.example.android.pastoturistico;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.pastoturistico.R.string.usuario;

public class ExtraDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public Lista_Entrada[] datos =new Lista_Entrada[]{
            new Lista_Entrada(R.drawable.historia_opt,"Historia Pasto","Conozca un poco de la historia de pasto"),
            new Lista_Entrada(R.drawable.artesania,"Artesania ","Los artesanos pastusos son muy conocidos en Colombia "),
            new Lista_Entrada(R.drawable.gastronomia,"Gastronomia","Platos representativos de la gastronomía típica de Pasto")};
    String usuario="",correo="";
    Intent intent;
    TextView tUsername,tCorreo;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        usuario=extras.getString("usuario");
        correo=extras.getString("correo");

        setTitle( getResources().getString(R.string.extras));


        list = (ListView) findViewById(R.id.list);
        final Adapter adapter = new Adapter(this, datos);

        //    ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,parques);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = ((Lista_Entrada) parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        intent = new Intent(ExtraDrawerActivity.this, HistoriaExtraDraweActivity.class);
                        intent.putExtra("usuario", usuario);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(ExtraDrawerActivity.this, ArtesaniaExtraDrawerActivity.class);
                        intent.putExtra("usuario", usuario);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(ExtraDrawerActivity.this, GastronomiaExtraDrawerActivity.class);
                        intent.putExtra("usuario", usuario);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        break;

                }


            }

        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        tUsername = (TextView)header.findViewById(R.id.perfilmenu);
        tCorreo= (TextView)header.findViewById(R.id.correomenu);
        tUsername.setText(extras.getString("usuario"));
        tCorreo.setText(extras.getString("correo"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.mbares:
                intent = new Intent(ExtraDrawerActivity.this, BarDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);

                break;
            case R.id.mrestaurante:
                intent = new Intent(ExtraDrawerActivity.this, RestauranteDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);
                startActivity(intent);
                break;
            case R.id.mhoteles:
                intent = new Intent(ExtraDrawerActivity.this, HotelDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);

                break;
            case R.id.mPrincipal:
                intent = new Intent(ExtraDrawerActivity.this, MainDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);
                break;
            case R.id.mextras:
                intent = new Intent(ExtraDrawerActivity.this, ExtraDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);
                finish();
                break;

            case R.id.mPerfil:
                intent = new Intent(ExtraDrawerActivity.this, PerfilDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);

                break;
            case R.id.mLogOut:
                intent = new Intent(ExtraDrawerActivity.this, LoginActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;

        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }




    class Adapter extends ArrayAdapter<Lista_Entrada> {


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

            ImageView imagen= (ImageView) item.findViewById(R.id.foto);
            imagen.setImageResource(datos[position].getIdImage());


            return item;
        }
    }

}
