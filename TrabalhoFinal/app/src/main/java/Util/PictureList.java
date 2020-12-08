package Util;

import android.app.Application;

import java.util.ArrayList;

import Model.Pictures;

public class PictureList extends Application {
    private static ArrayList<Pictures> listaFotos;
    private static PictureList foto;

    private PictureList() {
    }

    public static PictureList getInstance() {
        if (foto == null) {
            foto = new PictureList();
            listaFotos = new ArrayList<>();
        }
        return foto;
    }

    public static ArrayList<Pictures> getListPictures() {
        if (foto == null) {
            foto = new PictureList();
            listaFotos = new ArrayList<>();
        }
        return listaFotos;
    }

    public static void setListaFotos(ArrayList<Pictures> listaFotos) {
        PictureList.listaFotos = listaFotos;
    }
}
