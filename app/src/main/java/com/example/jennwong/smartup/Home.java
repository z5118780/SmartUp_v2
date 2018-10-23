package com.example.jennwong.smartup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    ImageButton quizbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

            quizbtn = (ImageButton) findViewById(R.id.quiz_icon);


        quizbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz = new  Intent(Home.this, Quiz_mainactivity.class);
                startActivity(quiz);
            }
        });


       //INITIATE VIEW'S

      /* ImageButton quizbtn = (ImageButton) findViewById(R.id.quiz_icon);*/
      /* ImageButton resourcebtn = (ImageButton) findViewById(R.id.resource_icon);*/


       //perform click event on button's

      /* quizbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent quiz = new Intent(Home.this, Quiz_mainactivity.class);
               startActivity(quiz);
               finish();
           }
       });*/



       /*resourcebtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent resource = onNewIntent(MainActivity.this, resourceactivity.class);
               startActivity(resource);
           }
       });
*/



    }
}
