package com.example.appmotorizado.Calificacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmotorizado.Calificacion.Adapter.ListAdapterPedidos;
import com.example.appmotorizado.R;
import com.example.appmotorizado.pedidosentregar.adaptadorpxe.ListPedidosxEntregar;
import com.example.appmotorizado.pedidosentregar.pedidos_por_entregar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class CalificacionActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Pedido> Pedidos = new ArrayList<>();
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ListAdapterPedidos listAdapterPedidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);
        listView = (ListView)findViewById(R.id.listcalificaciones);
        iniciarFirebase();
        listarDatos();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pedido pedido = listAdapterPedidos.getItem(i);
                Intent intent = new Intent(CalificacionActivity.this,CalificacionUsuario.class);
                intent.putExtra("pedido",pedido.getNombre());
                intent.putExtra("descripcion",pedido.getDescripcion());
                intent.putExtra("calificacion",pedido.getPuntuacion());
                startActivity(intent);
            }
        });
    }
    private void listarDatos() {
        databaseReference.child("Pedido").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Pedidos.clear();
                for (DataSnapshot objDataSnapshot:dataSnapshot.getChildren()){
                    Pedido p = objDataSnapshot.getValue(Pedido.class);
                    if (p.isEstado()){
                        Pedidos.add(p);
                    }
                    listAdapterPedidos = new ListAdapterPedidos(Pedidos, CalificacionActivity.this);
                    listView.setAdapter(listAdapterPedidos);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void iniciarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
