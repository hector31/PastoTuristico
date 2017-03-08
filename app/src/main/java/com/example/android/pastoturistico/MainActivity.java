package com.example.android.pastoturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
//1-splash
// 2-LoginActivity
// 3-registro
// 4-MainActivity
///verison V.2 agregar bares,restaurantes,hoteles,mi perfil,cerrar cesion en el menu de despliegue
// los menus de desbordes en cada uno como bares ,restaurantes,hoteles deben tener los mismo menus
    String usuario="",correo="";
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        usuario=extras.getString("usuario");
        correo=extras.getString("correo");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
    return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.mPerfil:
                intent = new Intent(MainActivity.this, PerfilActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();

                break;
            case R.id.mLogOut:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mhoteles:
                intent = new Intent(MainActivity.this, HotelesActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();

                break;
            case R.id.mbares:
                intent = new Intent(MainActivity.this, BaresActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();

                break;
            case R.id.mrestaurante:
                intent = new Intent(MainActivity.this, RestaurantesActivity.class);
                intent.putExtra("usuario", usuario);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;

        }
        return true;
    }
}
