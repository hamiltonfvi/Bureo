package com.example.android.bureo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class PlaceDetails extends AppCompatActivity {

    // UI Components
    ImageView mItemImage;
    TextView mItemDescription;
    Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        // Initialize UI Components
        mItemImage = findViewById(R.id.image_place);
        mItemDescription = findViewById(R.id.text_place_desc);
        mtoolbar = findViewById(R.id.toolbar);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            mtoolbar.setTitle(bundle.getString("title"));
        } else {
            return;
        }

        //get in the imageResourceId
        int imagesRes = bundle.getInt("image");

        //Assign the imageResourceId to a ImageView in the Activity Place Details
        mItemImage.setImageResource(imagesRes);

        //Assign the textResourceId to a TextView in the Activity Place Details
        mItemDescription.setText(bundle.getString("description"));

    }
}



