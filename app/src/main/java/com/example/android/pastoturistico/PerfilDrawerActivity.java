package com.example.android.pastoturistico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
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

public class PerfilDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView tUsername,tCorreo,t2Username,t2Correo;
    Intent intent;
    String usuario="",correo="";
    SharedPreferences prefers;
    SharedPreferences.Editor editor;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle( getResources().getString(R.string.perfil));

        tUsername = (TextView) findViewById(R.id.tUsename);
        tCorreo= (TextView) findViewById(R.id.tCorreoo);
        Bundle extras= getIntent().getExtras();
        usuario=extras.getString("usuario");
        correo=extras.getString("correo");
        tUsername.setText(extras.getString("usuario"));
        tCorreo.setText(extras.getString("correo"));

        prefers= getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor= prefers.edit();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        t2Username = (TextView)header.findViewById(R.id.perfilmenu);
        t2Correo= (TextView)header.findViewById(R.id.correomenu);
        t2Username.setText(extras.getString("usuario"));
        t2Correo.setText(extras.getString("correo"));
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
                intent = new Intent(PerfilDrawerActivity.this, BarDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);

                break;
            case R.id.mrestaurante:
                intent = new Intent(PerfilDrawerActivity.this, RestauranteDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);
                startActivity(intent);

                break;
            case R.id.mhoteles:
                intent = new Intent(PerfilDrawerActivity.this, HotelDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);

                break;
            case R.id.mPrincipal:
                intent = new Intent(PerfilDrawerActivity.this, MainDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);
                break;
            case R.id.mextras:
                intent = new Intent(PerfilDrawerActivity.this, ExtraDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);
                break;

            case R.id.mPerfil:
                intent = new Intent(PerfilDrawerActivity.this, PerfilDrawerActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);

                startActivity(intent);
                finish();
                break;

            case R.id.mLogOut:
                intent = new Intent(PerfilDrawerActivity.this, LoginActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                editor.putInt("login",-1);//1 loggeado 0 sin loggear nadie
                editor.commit();
                startActivity(intent);
                finish();
                break;

        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
