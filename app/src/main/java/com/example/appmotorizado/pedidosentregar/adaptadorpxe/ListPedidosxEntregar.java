package com.example.appmotorizado.pedidosentregar.adaptadorpxe;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmotorizado.Calificacion.Pedido;
import com.example.appmotorizado.MapaActivity;
import com.example.appmotorizado.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListPedidosxEntregar extends BaseAdapter {
    public ArrayList<Pedido> list;
    private LayoutInflater inflater;
    private Activity activity;
    private ImageButton btnWhatsapp, btnMapa, btnPedidoEntregado;
    private Pedido pedidoSeleccionado;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public ListPedidosxEntregar(ArrayList<Pedido> list, Activity activity) {
        super();
        this.list = list;
        this.activity = activity;
        iniciarFirebase();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Pedido getItem(int i) {
        return list.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null){
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null){
            view = inflater.inflate(R.layout.list_pedidos_por_entregar,null);
        }
        final Pedido pedido = list.get(i);

        TextView usuario = (TextView)view.findViewById(R.id.txtPedidoEntregar);
        TextView descripcion = (TextView)view.findViewById(R.id.txtDescripcionPedidoE);
        final TextView precio = (TextView)view.findViewById(R.id.txtPedidoPrecio);
        btnWhatsapp = (ImageButton)view.findViewById(R.id.btnChatPedido);
        btnMapa = (ImageButton)view.findViewById(R.id.btnMapaPedido);
        btnPedidoEntregado = (ImageButton)view.findViewById(R.id.btnEntregado);
        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent _intencion = new Intent("android.intent.action.MAIN");
                _intencion.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
                _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators("51" + pedido.getTelefono())+"@s.whatsapp.net");
                activity.startActivity(_intencion);
            }
        });
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, MapaActivity.class);
                i.putExtra("latitud",pedido.getLatitud());
                i.putExtra("longitud",pedido.getLongitud());
                activity.startActivity(i);
            }
        });
        btnPedidoEntregado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pedido.setEstado(true);
                databaseReference.child("Pedido").child(pedido.getIdPedido()).setValue(pedido);
                Toast.makeText(activity, pedido.getNombre()+" entregado.", Toast.LENGTH_SHORT).show();
            }
        });
        usuario.setText(pedido.getNombre());
        descripcion.setText(pedido.getDescripcion());
        precio.setText(pedido.getPrecio()+" soles."); // Se concatena con "" para que el label lo tome como String

        return view;
    }
    private void iniciarFirebase() {
        FirebaseApp.initializeApp(activity);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
