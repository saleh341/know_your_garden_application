package com.example.knowyourgarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONObject;

import java.util.ArrayList;

public class GridView extends AppCompatActivity {

    android.widget.GridView simpleList;
    private FirebaseAuth mAuth;
    ArrayList<Item> birdList=new ArrayList<Item>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        getSupportActionBar().hide();
        simpleList =(android.widget.GridView)findViewById(R.id.simpleGridView);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        mAuth = FirebaseAuth.getInstance();
        JSONObject obj=new JSONObject();


        db.collection("PlantDisease")
                .get()
                .addOnCompleteListener(GridView.this,new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            int indexValue=0;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                               
                                birdList.add(new Item(document.getData().get("plantname").toString(),document.getData().get("imgurl").toString()));
                                GridAdapter myAdapter=new GridAdapter(getApplicationContext(),R.layout.activity_grid_view,birdList);
                                simpleList.setAdapter(myAdapter);
                            }
                        } else {
                            Log.w("result", "Error getting documents.", task.getException());
                        }

                    }
                });


        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // This method will be executed once the timer is over
                Intent i = new Intent(GridView.this, scanpic.class);
                // i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                String valarr=birdList.get(position).getbImage();
                String plantName=birdList.get(position).getbName();

                i.putExtra("key",valarr);
                i.putExtra("plantName",plantName);
                startActivity(i);

            }
        });
    }
}