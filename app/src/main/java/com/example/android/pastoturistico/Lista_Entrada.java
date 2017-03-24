package com.example.android.pastoturistico;

/**
 * Created by W7 on 14/03/2017.
 */

public class Lista_Entrada {
    private int idImage;
    private String nombre,descrip;

    public Lista_Entrada(int idImage, String nombre, String descrip) {
        this.idImage = idImage;
        this.nombre = nombre;
        this.descrip = descrip;
    }

    public int getIdImage() {
        return idImage;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

}
