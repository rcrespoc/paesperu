package com.example.appmotorizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    private EditText usuario;
    private EditText contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        usuario = (EditText) findViewById(R.id.usuario);
        contraseña = (EditText) findViewById(R.id.contraseña);
    }
    //Botón Iniciar Sesión
    public void IniciarSesion(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user", usuario.getText().toString());
        intent.putExtra("pass", contraseña.getText().toString());
        startActivity(intent);
    }
    public void Registro(View view){
        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);
    }
}
