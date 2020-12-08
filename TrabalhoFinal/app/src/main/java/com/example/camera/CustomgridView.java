package com.example.camera;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CustomgridView extends BaseAdapter {

    private Context mContext;

    public CustomgridView(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return PicturesActivity.ListaBitMap.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView gridViewLayout = (ImageView) convertView;

        if (gridViewLayout == null){
            gridViewLayout = new ImageView(mContext);
            gridViewLayout.setLayoutParams(new GridView.LayoutParams(350, 450));
            gridViewLayout.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        gridViewLayout.setImageBitmap(PicturesActivity.ListaBitMap.get(position));

        return gridViewLayout;
    }
}
