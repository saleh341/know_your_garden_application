package com.example.knowyourgarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class camera extends AppCompatActivity {
    // views for button
    private Button btnSelect, btnUpload;
EditText plantname;
    // view for image view
    private ImageView imageView;

    // Uri indicates, where the image will be picked from
    private Uri filePath;

    // request code
    private final int PICK_IMAGE_REQUEST = 22;
    private static final int CAMERA_REQUEST=1888;
    Bitmap bitmapsaver;
    private FirebaseAuth mAuth;

    // instance for firebase storage and StorageReference
    FirebaseStorage storage;
    StorageReference storageReference;

//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == CAMERA_REQUEST) {
//            Bitmap photo=(Bitmap) data.getExtras().get("data");
//            imageView.setImageBitmap(photo);
//        }
//    }
//
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        getSupportActionBar().hide();
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(
                Color.parseColor("#0F9D58"));
        actionBar.setBackgroundDrawable(colorDrawable);

        // initialise views
        btnSelect = findViewById(R.id.btnChoose);
        btnUpload = findViewById(R.id.btnUpload);
        imageView = findViewById(R.id.imgView);
        Button photoButton=(Button) this.findViewById(R.id.button1);
        plantname=(EditText)findViewById(R.id.plantname);
        btnUpload.setVisibility(View.GONE);

        // get the Firebase  storage reference
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();



        // on pressing btnSelect SelectImage() is called
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SelectImage();
            }
        });


        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

//        // on pressing btnUpload uploadImage() is called
//        btnUpload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                uploadImage();
//            }
//        });


        Drawable drawable = getResources().getDrawable(R.drawable.d1);
        bitmapsaver = ((BitmapDrawable) drawable).getBitmap();
        Map<String, Object> user = new HashMap<>();


        btnUpload.setOnClickListener(new View.OnClickListener() {
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
                        bitmapsaver.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                        fos.flush();
                        fos.close();
//                        Toast.makeText(getApplicationContext(), file.toString(), Toast.LENGTH_LONG).show();

                        Toast.makeText(getApplicationContext(), "Uploading Wait !", Toast.LENGTH_LONG).show();
                        File imgFile = new  File( file.toString());

                        user.put("imgurl",file.toString());
                        user.put("plantname",plantname.getText().toString());

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
                                            CharSequence text = "Uploaded!";
                                            int duration = Toast.LENGTH_LONG;

                                            Toast toast = Toast.makeText(context, text, duration);
                                            toast.show();


                                            Intent i = new Intent(getApplicationContext(), GridView.class);

                                            startActivity(i);
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Context context = getApplicationContext();
                                            CharSequence text = "Facing Some Error Restart App!";
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

    // Select Image method
    private void SelectImage()
    {

        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);





    }

    // Override onActivityResult method
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data)
    {

        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo=(Bitmap) data.getExtras().get("data");
            // Get the Uri of data
            bitmapsaver=photo;
            imageView.setImageBitmap(photo);
            btnUpload.setVisibility(View.VISIBLE);
        }

        super.onActivityResult(requestCode,
                resultCode,
                data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            filePath = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filePath);

                bitmapsaver=bitmap;
                imageView.setImageBitmap(bitmap);

                btnUpload.setVisibility(View.VISIBLE);
            }

            catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
    }

    // UploadImage method
    private void uploadImage()
    {
        Toast.makeText(camera.this,"Uploading Image fun call uploadimage", Toast.LENGTH_SHORT).show();
        if (false) {

            Toast.makeText(camera.this,"Uploading calling  if", Toast.LENGTH_SHORT).show();

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog= new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();


            StorageReference ref
                    = storageReference
                    .child("images/");

            // adding listeners on upload
            // or failure of image
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast.makeText(camera.this,"Image Uploaded!!",Toast.LENGTH_SHORT).show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast.makeText(camera.this, "Failed " + e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(UploadTask.TaskSnapshot taskSnapshot){
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage("Uploaded " + (int)progress + "%");

                                    // This method will be executed once the timer is over
                                    Intent i = new Intent(camera.this, LocalGallery.class);
                                    startActivity(i);
                                }






                    });
        }
        else {
            Intent i = new Intent(camera.this, LocalGallery.class);
            startActivity(i);
        }
    }
}