package com.example.jennwong.smartup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1= (TextView) findViewById(R.id.textView4);
        t2= (TextView) findViewById(R.id.textView5);
        t3= (TextView) findViewById(R.id.textView6);


        Intent i=getIntent();

        String questions = i.getStringExtra("Total");
        String correct = i.getStringExtra("Correct");
        String wrong = i.getStringExtra("Incorrect");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);






    }
}


}
