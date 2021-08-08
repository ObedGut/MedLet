package com.example.medlet.model;

import android.widget.EditText;

public class MedicineInfo {

    private String uid;
    private String Nombre;
    private String Precio;
    private String PrecioUnidad;

   public MedicineInfo(String nombre, String precio, String precioUnidad){
       this.Nombre = nombre;
       this.Precio = precio;
       this.PrecioUnidad = precioUnidad;
   }

    public MedicineInfo(EditText nombremed, EditText preciomed) {
    }

    public String getUid(){return uid;}
    public String getNombre(){return Nombre;}
    public String getPrecio(){return Precio;}
    public String getPrecioUnidad(){return PrecioUnidad;}

   public void setUid(String uid){this.uid = uid;}
   public void setNombre(String nombre){this.Nombre = nombre;}
   public void setPrecio(String precio){this.Precio = precio;}
   public void setPrecioUnidad(String precioUnidad){this.PrecioUnidad = precioUnidad;}

}
