package com.example.jennwong.smartup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView t1,t2,t3;

    Button homebtn, resourcebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // the content below has been referenced from https://www.youtube.com/watch?v=3gSIJTHiAvI&fbclid=IwAR3HmikDnFo-rklVVeCsMC9MZrS3Vd8Yp0mLVx1eC0p2tGI2XOO26r3FuBU
        //Initiate View

        t1= (TextView) findViewById(R.id.textView4);
        t2= (TextView) findViewById(R.id.textView5);
        t3= (TextView) findViewById(R.id.textView6);
        homebtn  = (Button) findViewById(R.id.home);
        resourcebtn  = (Button) findViewById(R.id.resource2);


        Intent i=getIntent();

        String questions = i.getStringExtra("Total");
        String correct = i.getStringExtra("Correct");
        String wrong = i.getStringExtra("Incorrect");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);

    //buttons were implemented by the team 

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resource = new Intent(ResultActivity.this, Home.class);
                startActivity(resource);
            }
        });


        resourcebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resource = new Intent(ResultActivity.this, Resource_content.class);
                startActivity(resource);
            }
        });




    }
}



