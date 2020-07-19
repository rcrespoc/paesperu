package com.example.appmotorizado.pedidosentregar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ListView;


import com.example.appmotorizado.Calificacion.Pedido;
import com.example.appmotorizado.R;
import com.example.appmotorizado.pedidosentregar.adaptadorpxe.ListPedidosxEntregar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class pedidos_por_entregar extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Pedido> Pedidos = new ArrayList<Pedido>();
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ListPedidosxEntregar listPedidosxEntregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_por_entregar);
        listView = (ListView)findViewById(R.id.list_pedidos);
        iniciarFirebase();
        listarDatos();

    }
    private void listarDatos() {
        databaseReference.child("Pedido").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Pedidos.clear();
                for (DataSnapshot objDataSnapshot:dataSnapshot.getChildren()){
                    Pedido p = objDataSnapshot.getValue(Pedido.class);
                    if (!p.isEstado()){
                        Pedidos.add(p);
                    }
                    listPedidosxEntregar = new ListPedidosxEntregar(Pedidos,pedidos_por_entregar.this);
                    listView.setAdapter(listPedidosxEntregar);
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
