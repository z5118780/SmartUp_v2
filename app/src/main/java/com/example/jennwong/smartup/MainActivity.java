package com.example.jennwong.smartup;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jennwong.smartup.Sign_in.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

    //for sign up
    MaterialEditText edtNewUserName, edtNewPassword, edtNewEmail;

    //for sign in
    MaterialEditText edtUser, edtPassword;

    Button btnSignUp, btnSignIn;

    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Firebase database
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        edtUser = (MaterialEditText) findViewById(R.id.edtUser);
        edtPassword = (MaterialEditText) findViewById(R.id.edtPassword);

        //Initiate view

        btnSignIn = (Button) findViewById(R.id.btn_sign_in);
        btnSignUp = (Button) findViewById(R.id.btn_sign_up);

        //Perform click on event

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignUpDialog();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = edtUser.getText().toString();
                final String password = edtPassword.getText().toString();

                // Empty username
                if (username.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your user name", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Empty password
                if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Attach a listener to read the data at users reference
                users.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(username).exists()) {
                            User user = dataSnapshot.child(username).getValue(User.class);
                            System.out.println(user);
                            if (user.getPassword().equals(password)) {
                                // Correct login
                                System.out.println("Correct login!");
                                Intent homeActivity = new Intent(MainActivity.this, Home.class);
                                startActivity(homeActivity);
                                finish();
                            } else {
                                // Wrong login
                                System.out.println("Wrong password :(");
                                Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } else {
                            // User does not exist
                            System.out.println("User does not exist");
                            Toast.makeText(MainActivity.this, "User does not exist!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });
            }
        });

    }





    private void showSignUpDialog() {

        // Setting up alerts so users know what to do when they reach the sign up pop up
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Sign Up");
        alertDialog.setMessage("Please fill in the full information");

        //Layout inflater is used to make the sign up pop up

        LayoutInflater inflater = this.getLayoutInflater();
        View signup_layout = inflater.inflate(R.layout.signup_layout, null);

        //setting up the variables

        edtNewUserName = signup_layout.findViewById(R.id.edtNewUserName);
        edtNewEmail = signup_layout.findViewById(R.id.edtNewEmail);
        edtNewPassword = signup_layout.findViewById(R.id.edtNewPassword);

        alertDialog.setView(signup_layout);
        alertDialog.setIcon(R.drawable.ic_account_circle_black_24dp);

        //Perform Click on event for No and Yes

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                final User user = new User(edtNewUserName.getText().toString(), edtNewPassword.getText().toString(), edtNewEmail.getText().toString());

                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(user.getUser_name()).exists())
                            Toast.makeText(MainActivity.this, "User already exists!", Toast.LENGTH_SHORT).show();
                        else {
                            users.child(user.getUser_name())
                                    .setValue(user);
                            Toast.makeText(MainActivity.this, "User registration success", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                dialogInterface.dismiss();

            }
        });

        alertDialog.show();


    }
}





