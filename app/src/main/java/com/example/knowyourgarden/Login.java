package com.example.knowyourgarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText editName, editPassword;
    TextView result;
    Button buttonSubmit, buttonReset;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();


        editName = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);



        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String email = editName.getText().toString();
                String password = editPassword.getText().toString();

                FirebaseFirestore db = FirebaseFirestore.getInstance();

                Map<String, Object> user = new HashMap<>();
                user.put("first", email);
              user.put("password", password);
                mAuth = FirebaseAuth.getInstance();


//                 ---------- Here sign Up code for new user
//               mAuth.createUserWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
//
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    // Sign in success, update UI with the signed-in user's information
//                                    Toast.makeText(Login.this, "New user created with "+email, Toast.LENGTH_LONG).show();
//                                    Toast.makeText(Login.this, email.toString(), Toast.LENGTH_SHORT).show();
//
//                                    // This method will be executed once the timer is over
//                                    Intent i = new Intent(Login.this, MainActivity.class);
//                                    startActivity(i);
//                                } else {
//                                    // If sign in fails, display a message to the user.
//                                    Toast.makeText(Login.this, "Registration Failed" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
//
//
//                                }
//                            }
//                        });


                // --------------------------Here end the signup user ------------------- //



//                Sign In With Email & Password
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent i = new Intent(Login.this, MainActivity.class);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(Login.this, "Incorret Detail", Toast.LENGTH_LONG).show();
                                }
                            }
                        });





            }
        });
    }

    //  User Must used the login to move to the Dashboard page
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(this, Login.class));
        Toast.makeText(Login.this, "Login Required !", Toast.LENGTH_LONG).show();
        finish();
    }
}