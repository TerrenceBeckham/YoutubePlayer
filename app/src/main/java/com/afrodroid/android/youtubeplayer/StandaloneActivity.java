package com.afrodroid.android.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toast.makeText(this, "I am starting to get this", Toast.LENGTH_LONG).show();

        Button btnPlayVideo = findViewById(R.id.btnPlayVideo);
        Button btnPlaylist = findViewById(R.id.btnPlayList);


// this refers to the current object. I think this is the btnPlaylist
        btnPlaylist.setOnClickListener(this);
        btnPlayVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true, false);

                break;

            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST, 1, 0, true, false);
                break;
            default:
        }

        if (intent != null) {
            startActivity(intent);
        }


    }
}
