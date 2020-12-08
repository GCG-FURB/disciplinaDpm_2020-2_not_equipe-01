package com.example.camera;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import Util.PictureList;

public class PicturesActivity extends AppCompatActivity {
    GridView gridView;
    public static ArrayList<Bitmap> ListaBitMap;
    Bitmap bitMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos);
        gridView = (GridView) findViewById(R.id.gridViewFotos);

        ListaBitMap = new ArrayList();

        showSavedPictures();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bitMap = ListaBitMap.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(PicturesActivity.this);
                ImageView imageView = new ImageView(PicturesActivity.this);
                bitMap = RotateBitmap(bitMap, 0);
                imageView.setImageBitmap(bitMap);
                builder.setView(imageView).show();
            }
        });
    }

    private void showSavedPictures() {
        for (int idx = 0; idx < PictureList.getListPictures().size(); ++idx) {
            ListaBitMap.add(PictureList.getListPictures().get(idx).arq_pic);
        }
        CustomgridView gridAdapter = new CustomgridView(this);
        gridView.setAdapter(gridAdapter);
    }

    public static Bitmap RotateBitmap(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }
}
