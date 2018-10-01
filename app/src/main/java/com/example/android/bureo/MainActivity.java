package com.example.android.bureo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initiate UI components
        final TextView explore = findViewById(R.id.explore);

        //Set OnClickListeners on clickable TextViews
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer click = MediaPlayer.create(getApplicationContext(), R.raw.click);
                click.start();
                Intent i = new Intent(getApplicationContext(), PagerActivity.class);
                startActivity(i);
            }
        });
    }
}

