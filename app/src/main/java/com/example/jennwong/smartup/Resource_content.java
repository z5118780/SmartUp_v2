package com.example.jennwong.smartup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Resource_content extends AppCompatActivity {

    ImageButton networkbtn;
    ImageButton polybtn;
    ImageButton loopbtn;
    ImageButton securitybtn;
    ImageButton databasebtn;
    ImageButton serverbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_content);

       networkbtn =(ImageButton) findViewById(R.id.networking1);

        networkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cominsoon1 = new Intent(Resource_content.this, Notes.class);
                startActivity(cominsoon1);

            }
        });


        polybtn = (ImageButton) findViewById(R.id.polymorphism);

        polybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comingsoon2 = new Intent(Resource_content.this, comingsoon.class);
                startActivity(comingsoon2);

            }
        });

        loopbtn = (ImageButton) findViewById(R.id.loop);

        loopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loopcomingsoon = new Intent(Resource_content.this, comingsoon.class);
                startActivity(loopcomingsoon);

            }
        });

        securitybtn = (ImageButton) findViewById(R.id.security);
        securitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent securitycomingsoon = new Intent(Resource_content.this, comingsoon.class);
                startActivity(securitycomingsoon);

            }
        });

        databasebtn = (ImageButton) findViewById(R.id.database);
        databasebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent databasecomingsoon = new Intent(Resource_content.this, comingsoon.class);
                startActivity(databasecomingsoon);
            }
        });

        serverbtn = (ImageButton) findViewById(R.id.server);
        serverbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent servercomingsoon = new Intent(Resource_content.this, comingsoon.class);
                startActivity(servercomingsoon);
            }
        });



    }
}
