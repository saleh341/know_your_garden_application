package com.example.knowyourgarden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class LocalGallery extends AppCompatActivity {

    CardView cv,secondCard,thirdCard,fourCard,fiveCard,sixCard,
                sevenCard,
                eightCard,
                nineCard,
                thenCard;


    Integer[] imgid={
            R.drawable.d1,R.drawable.d2,
            R.drawable.d3,R.drawable.d4,
            R.drawable.d5,
            R.drawable.d6,R.drawable.d7,
            R.drawable.d8,R.drawable.d9,
            R.drawable.d10,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_gallery);
        getSupportActionBar().hide();

        cv=(CardView) findViewById(R.id.firstCard);
        secondCard=(CardView) findViewById(R.id.secondCard);
        thirdCard=(CardView) findViewById(R.id.thirdCard);
        fourCard=(CardView) findViewById(R.id.fourCard);
        fiveCard=(CardView) findViewById(R.id.fiveCard);
        sixCard=(CardView) findViewById(R.id.sixCard);
        sevenCard=(CardView) findViewById(R.id.sevenCard);
        eightCard=(CardView) findViewById(R.id.eightCard);
        nineCard=(CardView) findViewById(R.id.nineCard);
        thenCard=(CardView) findViewById(R.id.thenCard);



        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String imgurl = bundle.getString("imgurl");
            String plantname = bundle.getString("plantname");


        }



        cv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(LocalGallery.this, scanpic.class);
                i.putExtra("img",imgid[0]);

                startActivity(i);

            }
        });



        secondCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(LocalGallery.this, scanpic.class);
                i.putExtra("img",imgid[1]);

                startActivity(i);

            }
        });


        thirdCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(LocalGallery.this, scanpic.class);
                i.putExtra("img",imgid[2]);
                startActivity(i);

            }
        });


        fourCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(LocalGallery.this, scanpic.class);
                i.putExtra("img",imgid[3]);
                startActivity(i);

            }
        });



        fiveCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(LocalGallery.this, scanpic.class);
                i.putExtra("img",imgid[4]);
                startActivity(i);

            }
        });


        sixCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(LocalGallery.this, scanpic.class);
                i.putExtra("img",imgid[5]);
                startActivity(i);

            }
        });



        sevenCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(LocalGallery.this, scanpic.class);
                i.putExtra("img",imgid[6]);
                startActivity(i);

            }
        });



        eightCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(LocalGallery.this, scanpic.class);
                i.putExtra("img",imgid[7]);
                startActivity(i);

            }
        });



        nineCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(LocalGallery.this, scanpic.class);
                i.putExtra("img",imgid[8]);
                startActivity(i);

            }
        });


        thenCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(LocalGallery.this, scanpic.class);
                i.putExtra("img",imgid[9]);
                startActivity(i);

            }
        });

    }

}