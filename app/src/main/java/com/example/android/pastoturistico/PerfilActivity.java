package com.example.android.pastoturistico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    TextView tUsername,tCorreo;
    Intent intent;
    String usuario="",correo="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        tUsername = (TextView) findViewById(R.id.tUsename);
        tCorreo= (TextView) findViewById(R.id.tCorreoo);
        Bundle extras= getIntent().getExtras();
        usuario=extras.getString("usuario");
        correo=extras.getString("correo");
        tUsername.setText(extras.getString("usuario"));
        tCorreo.setText(extras.getString("correo"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu2) {
        getMenuInflater().inflate(R.menu.menu2, menu2);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.mPrincipal:
                intent = new Intent(PerfilActivity.this, MainActivity.class);
                intent.putExtra("usuario",usuario);
                intent.putExtra("correo",correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mLogOut:
                intent = new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }
}
