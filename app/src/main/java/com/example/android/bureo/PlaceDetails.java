package com.example.android.bureo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDetails extends AppCompatActivity {

    // UI Components
    private ImageView mImageArtwork;
    private TextView mTextContent;

    // Identifiers
    private String mPlace;
    private String mPictureResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        // Initialize UI Components
        mImageArtwork = (ImageView) findViewById(R.id.image_place);
        mTextContent = (TextView) findViewById(R.id.text_place_desc);

        // Display Media Details and Image
        displayMediaDetails();
    }

    /**
     * This method displays Guide details - name, neighborhood name, picture and detail information
     */
    public void displayMediaDetails() {
        //
        int resId = getResources().getIdentifier(mPictureResource, "drawable", getPackageName());
        mImageArtwork.setImageResource(resId);

        //Get specific String to display guide information
        //it get it by replace spaces for _ and putting all letters in lower case
        //Eg Estrela Garden -> estrela_garden -> R.string.estrela_garden
        int contentResource = getResources().getIdentifier(mPlace.replaceAll(" ", "_").replace("'", "").toLowerCase(),"string", getPackageName());
        mTextContent.setText(contentResource);
    }
}

