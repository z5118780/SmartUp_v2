package com.example.jennwong.smartup;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import com.example.jennwong.smartup.Quiz.Question;

public class Quiz_mainactivity extends AppCompatActivity {


    // all the code written in this activity has been reference from www.youtube.com/watch?v=-4bZ_rfvBTk except for the designs part
  //for options, text for the questions, timer, database

    Button b1, b2, b3, b4;
    TextView quesTxt, timTxt;
    int total = 1;
    int correct = 0;
    int wrong = 0;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_mainactivity);

        //Initiate view for the buttons

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);

        quesTxt = findViewById(R.id.questionsTxt);
        timTxt = findViewById(R.id.timerTxt);

        updateQuestion();
        reverseTimer(30, timTxt);


    }

    //method to update the question once the user has clicked the option


    private void updateQuestion() {
        total++;
        if (total > 5) {

        } else {
            mDatabase = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
            mDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);


                    //Initate view
                    quesTxt.setText(question.getQuestion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());

                    //Perform click event on button

                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b1.getText().toString().equals(question.getAnswer())) {

                                b1.setBackgroundColor(Color.GREEN);


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {

                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundResource(R.drawable.roundbutton);

                                        updateQuestion();
                                    }
                                }, 1500);


                            } else {

                                wrong++;
                                b1.setBackgroundColor(Color.RED);

                                if (b2.getText().toString().equals(question.getAnswer())) {

                                    b2.setBackgroundColor(Color.GREEN);

                                } else if (b3.getText().toString().equals(question.getAnswer())) {

                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {

                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(() -> {
                                    b1.setBackgroundResource(R.drawable.roundbutton);
                                    b2.setBackgroundResource(R.drawable.roundbutton);
                                    b3.setBackgroundResource(R.drawable.roundbutton);
                                    b4.setBackgroundResource(R.drawable.roundbutton);
                                    updateQuestion();

                                }, 1500);
                            }
                        }

                    });

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b2.getText().toString().equals(question.getAnswer())) {

                                b2.setBackgroundColor(Color.GREEN);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {

                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackgroundResource(R.drawable.roundbutton);

                                        updateQuestion();
                                    }
                                }, 1500);


                            } else {

                                wrong++;
                                b2.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(question.getAnswer())) {

                                    b1.setBackgroundColor(Color.GREEN);

                                } else if (b3.getText().toString().equals(question.getAnswer())) {

                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {

                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(() -> {
                                    b1.setBackgroundResource(R.drawable.roundbutton);
                                    b2.setBackgroundResource(R.drawable.roundbutton);
                                    b3.setBackgroundResource(R.drawable.roundbutton);
                                    b4.setBackgroundResource(R.drawable.roundbutton);
                                    updateQuestion();

                                }, 1500);
                            }
                        }

                    });


                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b3.getText().toString().equals(question.getAnswer())) {

                                b3.setBackgroundColor(Color.GREEN);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {

                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackgroundResource(R.drawable.roundbutton);

                                        updateQuestion();
                                    }
                                }, 1500);


                            } else {

                                wrong++;
                                b3.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(question.getAnswer())) {

                                    b1.setBackgroundColor(Color.GREEN);

                                } else if (b2.getText().toString().equals(question.getAnswer())) {

                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {

                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(() -> {
                                    b1.setBackgroundResource(R.drawable.roundbutton);
                                    b2.setBackgroundResource(R.drawable.roundbutton);
                                    b3.setBackgroundResource(R.drawable.roundbutton);
                                    b4.setBackgroundResource(R.drawable.roundbutton);
                                    updateQuestion();

                                }, 1500);
                            }
                        }

                    });

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b4.getText().toString().equals(question.getAnswer())) {

                                b4.setBackgroundColor(Color.GREEN);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {

                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackgroundResource(R.drawable.roundbutton);

                                        updateQuestion();
                                    }
                                }, 1500);


                            } else {

                                wrong++;
                                b4.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(question.getAnswer())) {

                                    b1.setBackgroundColor(Color.GREEN);

                                } else if (b2.getText().toString().equals(question.getAnswer())) {

                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer())) {

                                    b3.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(() -> {
                                    b1.setBackgroundResource(R.drawable.roundbutton);
                                    b2.setBackgroundResource(R.drawable.roundbutton);
                                    b3.setBackgroundResource(R.drawable.roundbutton);
                                    b4.setBackgroundResource(R.drawable.roundbutton);
                                    updateQuestion();

                                }, 1500);
                            }
                        }

                    });

                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }


            });

        }

    }

    //method for reverse timer

    private void reverseTimer(int seconds, final TextView tv) {

        new CountDownTimer(seconds * 1000 + 1000, 1000) {


            public void onTick(long millisUntilFinished) {

                //initiate view and setting the int seconds variable by having it divide it by millis, likewise with minutes
                int seconds = (int) millisUntilFinished / 1000;
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format(getString(R.string.timer), minutes)
                        + ":" + String.format("%02d", seconds));
            }



            // Once the timer is finished, it goes to the results activit.
            @Override
            public void onFinish() {
                tv.setText("Completed");
                Intent myIntent = new Intent(Quiz_mainactivity.this, ResultActivity.class);

                // in the intent "put extra" the string is gathering the number of times the individual clicked the correct/incorrect and total number of questions.
                myIntent.putExtra("Total", String.valueOf("5"));
                myIntent.putExtra("Correct", String.valueOf(correct));
                myIntent.putExtra("Incorrect", String.valueOf(wrong));
                startActivity(myIntent);

            }
        }.start();
    }


}


