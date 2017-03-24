package com.example.android.pastoturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class HistoriaExtraDraweActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String usuario="",correo="";
    Intent intent;
    TextView tUsername,tCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia_extra_drawe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        usuario=extras.getString("usuario");
        correo=extras.getString("correo");

        setTitle( getResources().getString(R.string.historia));
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
                intent = new Intent(HistoriaExtraDraweActivity.this, BarDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);

                break;
            case R.id.mrestaurante:
                intent = new Intent(HistoriaExtraDraweActivity.this, RestauranteDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);
                startActivity(intent);
                break;
            case R.id.mhoteles:
                intent = new Intent(HistoriaExtraDraweActivity.this, HotelDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);

                break;
            case R.id.mPrincipal:
                intent = new Intent(HistoriaExtraDraweActivity.this, MainDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);
                break;
            case R.id.mextras:
                intent = new Intent(HistoriaExtraDraweActivity.this, ExtraDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);
                finish();
                break;

            case R.id.mPerfil:
                intent = new Intent(HistoriaExtraDraweActivity.this, PerfilDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);

                break;
            case R.id.mLogOut:
                intent = new Intent(HistoriaExtraDraweActivity.this, LoginActivity.class);
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
}
