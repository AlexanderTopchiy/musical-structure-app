package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);

        playing();
    }

    public void playing() {
        // Get extras from Intent.
        Intent opusIntent = getIntent();

        // Set the name of opus for playing.
        TextView opusTextView = findViewById(R.id.player_opus);
        String opusForPlaying = opusIntent.getStringExtra("opus");
        opusTextView.setText(opusForPlaying);

        // Set the name of composer for playing.
        TextView composerTextView = findViewById(R.id.player_composer);
        String composerForPlaying = opusIntent.getStringExtra("composer");
        composerTextView.setText(composerForPlaying);
    }
}
