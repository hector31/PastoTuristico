package com.example.android.pastoturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    Button bCancelar,bRegistrarse;
    EditText eusuario, econtraseña, erecontraseña, ecorreo;
    String usuario,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        bCancelar = (Button) findViewById(R.id.cancel);
        bRegistrarse=(Button) findViewById(R.id.registro2);
        eusuario= (EditText)  findViewById(R.id.username2);
        econtraseña=(EditText) findViewById(R.id.contraseña);
        erecontraseña=(EditText) findViewById(R.id.recontraseña);
        ecorreo= (EditText) findViewById(R.id.correo);


        bCancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
        }
        });

        bRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                if(!(econtraseña.getText().toString().equals(erecontraseña.getText().toString()))){
                    Toast.makeText(getApplicationContext(),"las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                }
                if(econtraseña.getText().toString().equals(erecontraseña.getText().toString())) {
                    intent.putExtra("usuario", eusuario.getText().toString());
                    intent.putExtra("contraseña", econtraseña.getText().toString());
                    intent.putExtra("correo", ecorreo.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });

    }
}
