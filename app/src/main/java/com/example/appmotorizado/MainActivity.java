package com.example.appmotorizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appmotorizado.Calificacion.CalificacionActivity;
import com.example.appmotorizado.Calificacion.Pedido;
import com.example.appmotorizado.pedidosentregar.pedidos_por_entregar;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView txtNomUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNomUsuario = (TextView)findViewById(R.id.txtNomUser);
        String usuario = getIntent().getStringExtra("user");
        txtNomUsuario.setText("Bienvenido "+ usuario);
    }
    public void abrirPedidos(View view){
        Intent i = new Intent (this, pedidos_por_entregar.class);
        startActivity(i);
    }
    public void abrirCalificaciones(View view){
        Intent i = new Intent(this, CalificacionActivity.class);
        startActivity(i);
    }
}
