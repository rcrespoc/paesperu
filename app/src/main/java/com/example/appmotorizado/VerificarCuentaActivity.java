package com.example.appmotorizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class VerificarCuentaActivity extends AppCompatActivity {
    private EditText codValidacion;
    private TextView numUser;
    private String numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_cuenta);

        numUser = (TextView)findViewById(R.id.txtNumero);
        numero = getIntent().getExtras().getString("numero");
        int num = Integer.parseInt(numero);
        numUser.setText("Se le ha enviado un código de confirmación al número +51 "+num);
        codValidacion = (EditText)findViewById(R.id.codigoValidacion);
    }
    public void Regresar(View view){
        Intent intent = new Intent(this, VerificarNumeroActivity.class);
        startActivity(intent);
    }
    public void CompletarRegistro(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
