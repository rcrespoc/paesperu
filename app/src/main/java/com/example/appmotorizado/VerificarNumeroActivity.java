package com.example.appmotorizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VerificarNumeroActivity extends AppCompatActivity {
    private EditText numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_numero);

        numero = (EditText)findViewById(R.id.numero);
    }
    public void Regresar(View view){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
    public void Siguiente(View view){
        String num = numero.getText().toString();
        Intent intent = new Intent(this, VerificarCuentaActivity.class);
        intent.putExtra("numero", num);
        startActivity(intent);
    }
}
