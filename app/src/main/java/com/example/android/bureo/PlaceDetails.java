package com.example.android.bureo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class PlaceDetails extends AppCompatActivity {

    // UI Components
    private ImageView mImageArtwork;
    private TextView mTextContent;

    // Identifiers
    private String mIntentMessage;
    private String mPlace;
    private String mPictureResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        // Initialize UI Components
        mImageArtwork = findViewById(R.id.home_image);
        mTextContent = findViewById(R.id.text_place_desc);

            }
        }

