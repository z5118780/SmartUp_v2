package com.example.jennwong.smartup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    ImageButton quizbtn;
    ImageButton resourcebtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //INITIATE VIEW'S

            resourcebtn=(ImageButton) findViewById(R.id.resource_icon);
            quizbtn = (ImageButton) findViewById(R.id.quiz_icon);


       //perform click event on button's

            resourcebtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent resource = new Intent(Home.this, Resource_content.class);
                    startActivity(resource);

                }
            });




            quizbtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                Intent quiz = new  Intent(Home.this, Quiz_mainactivity.class);
                startActivity(quiz);

                }
            });






    }
}
