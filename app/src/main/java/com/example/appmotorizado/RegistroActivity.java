package com.example.appmotorizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {
    private EditText nomApe;
    private EditText user;
    private EditText email;
    private EditText pass;
    private EditText confPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nomApe = (EditText) findViewById(R.id.nomApe_Usuario);
        user = (EditText) findViewById(R.id.user);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        confPass = (EditText) findViewById(R.id.confPass);
    }
    public void Siguiente(View view){
        Intent intent = new Intent(this, VerificarNumeroActivity.class);
        startActivity(intent);
    }
}
