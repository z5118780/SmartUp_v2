package com.example.jennwong.smartup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;
public class YoutubeMainActivity extends YouTubeBaseActivity {


        private static final String TAG = "MainActivity";

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_youtube_main);
            Log.d(TAG, "onCreate: Startin,");
            Button BtnP =  findViewById(R.id.button);
            final YouTubePlayerView mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayerViewId);


            final OnInitializedListener mOnInitializedListener = new OnInitializedListener() {


                @Override
                public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    Log.d(TAG, "onClick, Done Initialising");
                    youTubePlayer.loadVideo ("S43CFcpOZSI");
                }

                @Override
                public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    Log.d(TAG, "onClick, Failed to Initialise");

                }


            };

            BtnP.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v)
                {
                    Log.d(TAG,"OnClick: Initialising YouTube Player");
                    mYoutubePlayerView.initialize(youtubeConfig.getApiKey(),mOnInitializedListener);


                }
            });








        }


    }