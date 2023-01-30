package com.example.testebd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridView extends BaseAdapter {

    Context context;
    String[] nomefruta;
    int[] image;

    LayoutInflater layoutInflater;

    public GridView(Context context, String[] nomefruta, int[] image) {
        this.context = context;
        this.nomefruta = nomefruta;
        this.image = image;
    }


    @Override
    public int getCount() {
        return nomefruta.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        if(layoutInflater == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertview == null)
        {
            convertview = layoutInflater.inflate(R.layout.grid_item, null);
        }

        ImageView imageView = convertview.findViewById(R.id.grid_image);
        TextView textView = convertview.findViewById(R.id.item_name);

        imageView.setImageResource(image[position]);
        textView.setText(nomefruta[position]);


        return convertview;
    }
}
