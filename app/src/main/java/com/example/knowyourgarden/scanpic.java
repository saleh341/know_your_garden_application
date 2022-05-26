package com.example.knowyourgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class scanpic extends AppCompatActivity {


    Button scan;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanpic);
        getSupportActionBar().hide();
      String imageurl=null;
        String Plant_name=null;
        //button
        scan=(Button) findViewById(R.id.button);
        imageView=(ImageView)findViewById(R.id.scan_image);
        // This method will be executed once the timer is over
        Intent intentmain = new Intent(scanpic.this, view_plant.class);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

             imageurl = bundle.getString("key");
             Plant_name= bundle.getString("plantName");


            intentmain.putExtra("key",imageurl);
            intentmain.putExtra("plantName",Plant_name);

            //Toast.makeText(this, imageurl, Toast.LENGTH_LONG).show();
            File imgFile = new  File(imageurl);
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(myBitmap);


        }

        scan.setOnClickListener(new View.OnClickListener() {

         @Override
            public void onClick(View view) {
                // hit the API -> Volley
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                ProgressDialog progressDialog = new ProgressDialog(scanpic.this);
                        progressDialog.setMessage("Loading..."); // Setting Message
                        progressDialog.setTitle("Loading Model Result"); // Setting Title
                        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                        progressDialog.show(); // Display Progress Dialog
                        progressDialog.setCancelable(false);
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    Thread.sleep(10000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();

                        startActivity(intentmain);



                    }
                }).start();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }){

                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("file",imageurl.getText().toString());
                        return params;
                    }

                };
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(stringRequest);
            }
        });
    }
        });
    }
}