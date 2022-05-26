package com.example.knowyourgarden;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
public class GridAdapter  extends ArrayAdapter {

    ArrayList<Item> plantlist = new ArrayList<Item>();

    public GridAdapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context, textViewResourceId, objects);
        plantlist = objects;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.activity_grid_view_items, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);

        textView.setText(plantlist.get(position).getbName());

        File imgFile = new  File(plantlist.get(position).getbImage());

        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());



        imageView.setImageBitmap(myBitmap);

//        imageView.setImageResource(plantlist.get(position).getbImage());


//        v.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                // This method will be executed once the timer is over
//                Intent i = new Intent(getContext(), postdetail.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                getContext().startActivity(i);
//            }
//        });




        return v;

    }

}