package com.example.appmotorizado.Calificacion;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

public class Pedido  implements Parcelable  {
    private String idPedido;
    private String Nombre;
    private String Descripcion;
    private int Puntuacion;
    private int Precio;
    private String telefono;
    private Double latitud;
    private Double longitud;
    private boolean estado;
    public Pedido(){};
    protected Pedido(Parcel in) {
        idPedido = in.readString();
        Nombre = in.readString();
        Descripcion = in.readString();
        Puntuacion = in.readInt();
        Precio = in.readInt();
        telefono = in.readString();
        if (in.readByte() == 0) {
            latitud = null;
        } else {
            latitud = in.readDouble();
        }
        if (in.readByte() == 0) {
            longitud = null;
        } else {
            longitud = in.readDouble();
        }
        estado = in.readByte() != 0;
    }
    public static final Creator<Pedido> CREATOR = new Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel in) {
            return new Pedido(in);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };
    public Double getLatitud() {
        return latitud;
    }
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    public Double getLongitud() {
        return longitud;
    }
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
    public Pedido(String idPedido, String nombre, String descripcion, int puntuacion, int Precio, String telefono, Double latitud, Double longitud, boolean estado) {
        this.idPedido = idPedido;
        Nombre = nombre;
        Descripcion = descripcion;
        Puntuacion = puntuacion;
        this.Precio = Precio;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estado = estado;
        if(estado) {
            this.setPuntuacion(new Random().nextInt(6));
        }
    }
    public String getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
    public String getNombre() {
        return Nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public int getPrecio() {
        return Precio;
    }
    public void setPrecio(int precio) {
        Precio = precio;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    public int getPuntuacion() {
        return Puntuacion;
    }
    public void setPuntuacion(int puntuacion) {
        Puntuacion = puntuacion;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idPedido);
        parcel.writeString(Nombre);
        parcel.writeString(Descripcion);
        parcel.writeInt(Puntuacion);
        parcel.writeInt(Precio);
        parcel.writeString(telefono);
        if (latitud == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(latitud);
        }
        if (longitud == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(longitud);
        }
        parcel.writeByte((byte) (estado ? 1 : 0));
    }
    @Override
    public String toString() {
        return Nombre;
    }
}
