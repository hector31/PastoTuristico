package com.example.android.pastoturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsuario, ePassword;
    Button bIniciar;
    TextView tRegistrarse;
    String usuario="",contraseña="";

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
                if (eUsuario.getText().toString().equals(usuario) && ePassword.getText().toString().equals(contraseña)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK){
            usuario = data.getExtras().getString("usuario");
            contraseña = data.getExtras().getString("contraseña");
            // Toast.makeText(this, data.getExtras().getString("username"),Toast.LENGTH_SHORT).show();
        }
        if (requestCode == 1234 && resultCode==RESULT_CANCELED){
            Toast.makeText(this, "Error en login",Toast.LENGTH_SHORT).show();

        }

    }

}


