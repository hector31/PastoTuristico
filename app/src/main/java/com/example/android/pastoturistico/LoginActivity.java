package com.example.android.pastoturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsuario, ePassword;
    Button bIniciar;
    TextView tRegistrarse;
    String usuario="",contraseña="",correo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsuario= (EditText) findViewById(R.id.username);
        ePassword=(EditText) findViewById(R.id.password);
        bIniciar= (Button) findViewById(R.id.iniciar);
        tRegistrarse=(TextView) findViewById(R.id.registro);


        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LoginActivity.this,RegistroActivity.class);
                startActivityForResult(intent,1234);
            }
        });

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eUsuario.getText().toString().equals(usuario) && ePassword.getText().toString().equals(contraseña)&&!eUsuario.getText().toString().equals("")&&! ePassword.getText().toString().equals("")){
                    Intent intent = new Intent(LoginActivity.this, MainDrawerActivity.class);
                    intent.putExtra("usuario",usuario);
                    intent.putExtra("correo",correo);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.error),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK){
            usuario = data.getExtras().getString("usuario");
            contraseña = data.getExtras().getString("contraseña");
            correo=data.getExtras().getString("correo");
            Log.d("nombre",data.getExtras().getString("usuario"));//para saber si esta pasando por consola los datos
            //Toast.makeText(this, data.getExtras().getString("usuario"),Toast.LENGTH_SHORT).show();
        }
        if (requestCode == 1234 && resultCode==RESULT_CANCELED){
            Toast.makeText(this, getResources().getString(R.string.errorLogin ),Toast.LENGTH_SHORT).show();

        }

    }

}


