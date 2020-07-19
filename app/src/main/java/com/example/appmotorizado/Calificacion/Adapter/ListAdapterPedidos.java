package com.example.appmotorizado.Calificacion.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.appmotorizado.Calificacion.Pedido;
import com.example.appmotorizado.R;

import java.util.ArrayList;

public class ListAdapterPedidos extends BaseAdapter {
    public ArrayList<Pedido> list;
    private LayoutInflater inflater;
    private Activity activity;
    public ListAdapterPedidos(ArrayList<Pedido> list, Activity activity) {
        super();
        this.list = list;
        this.activity = activity;
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
            view = inflater.inflate(R.layout.listacalificaciones,null);
        }
        Pedido pedido = list.get(i);
        TextView usuario = (TextView)view.findViewById(R.id.usuario_cali);
        TextView descripcion = (TextView)view.findViewById(R.id.descripcion_pedido);
        RatingBar ratingBar = (RatingBar)view.findViewById(R.id.rtbEstrellas2);
        usuario.setText(pedido.getNombre());
        descripcion.setText(pedido.getDescripcion());
        ratingBar.setRating(pedido.getPuntuacion());
        return view;
    }
}
