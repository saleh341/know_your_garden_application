package com.example.knowyourgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.Random;

public class view_plant extends AppCompatActivity {

    Button scan;
    ImageView imageView;
    TextView healthcondition,plant_name;

    final int persetange = new Random().nextInt(((99) - 70) + 1) + 70;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_plant);

        getSupportActionBar().hide();
        String imageurl=null;
        String Plant_name=null;
        imageView=(ImageView)findViewById(R.id.scan_image);
        healthcondition=(TextView)findViewById(R.id.healthcondition);
        plant_name=(TextView)findViewById(R.id.plant_name);

        healthcondition.setText("Health Condition  :  "+persetange+"%");



        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            imageurl = bundle.getString("key");
            Plant_name= bundle.getString("plantName");

            plant_name.setText("Name :  "+Plant_name);


            //Toast.makeText(this, imageurl, Toast.LENGTH_LONG).show();
            File imgFile = new  File(imageurl);
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(myBitmap);


        }





        //button
        scan=(Button) findViewById(R.id.button);
        scan.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // This method will be executed once the timer is over
                Intent i = new Intent(view_plant.this, camera.class);
                startActivity(i);

            }
        });
    }
}