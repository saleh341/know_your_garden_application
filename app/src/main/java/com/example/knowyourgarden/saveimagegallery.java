package com.example.knowyourgarden;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class saveimagegallery extends AppCompatActivity {
    Button save;
    Bitmap bitmap;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saveimagegallery);

        Drawable drawable = getResources().getDrawable(R.drawable.d1);
        bitmap = ((BitmapDrawable) drawable).getBitmap();
        Map<String, Object> user = new HashMap<>();
        save = findViewById(R.id.btnCapture);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContextWrapper cw = new ContextWrapper(getApplicationContext());
                File directory = cw.getDir("Demo", Context.MODE_PRIVATE);


                directory.mkdir();
                File file = new File(directory, System.currentTimeMillis()+".jpg");

                if (!file.exists()) {

                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                        fos.flush();
                        fos.close();
                        Toast.makeText(getApplicationContext(), file.toString(), Toast.LENGTH_LONG).show();

                        File imgFile = new  File( file.toString());

                        user.put("imgurl",file.toString());
                        if(imgFile.exists()){

//                            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//
//                            ImageView myImage = (ImageView) findViewById(R.id.imageviewTest);
//
//                            myImage.setImageBitmap(myBitmap);


                            FirebaseFirestore db = FirebaseFirestore.getInstance();

                            mAuth = FirebaseAuth.getInstance();

                            db.collection("users")
                                    .add(user)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Context context = getApplicationContext();
                                            CharSequence text = "Data Saved";
                                            int duration = Toast.LENGTH_LONG;

                                            Toast toast = Toast.makeText(context, text, duration);
                                            toast.show();
                                      }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Context context = getApplicationContext();
                                            CharSequence text = "Error Saved!";
                                            int duration = Toast.LENGTH_LONG;

                                            Toast toast = Toast.makeText(context, text, duration);
                                            toast.show();


                                        }
                                    });



                        }

                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}