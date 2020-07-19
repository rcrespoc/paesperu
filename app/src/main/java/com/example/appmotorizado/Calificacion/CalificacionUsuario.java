package com.example.appmotorizado.Calificacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.appmotorizado.R;

public class CalificacionUsuario extends AppCompatActivity {
    private TextView pedido,descripcion;
    private RatingBar rtbEstrellas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion_usuario);
        getSupportActionBar().setTitle(getIntent().getExtras().get("pedido").toString());
        pedido = (TextView)findViewById(R.id.txtPedido);
        descripcion = (TextView)findViewById(R.id.txtDescripcionPedido);
        rtbEstrellas = (RatingBar)findViewById(R.id.rtbEstrellas);
        pedido.setText(getIntent().getExtras().get("pedido").toString());
        descripcion.setText(getIntent().getExtras().get("descripcion").toString());
        rtbEstrellas.setRating(Integer.parseInt(getIntent().getExtras().get("calificacion").toString()));
    }
}
