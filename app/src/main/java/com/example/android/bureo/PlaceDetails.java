package com.example.android.bureo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDetails extends AppCompatActivity {

    // UI Components
    ImageView mItemImage;
    TextView mItemDescription;
    TextView mItemAddress;
    TextView mItemPhoneNumber;
    TextView mItemWebSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        //Enabling UP navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize UI Components
        mItemImage = findViewById(R.id.image_place);
        mItemDescription = findViewById(R.id.text_place_desc);
        mItemAddress = findViewById(R.id.text_place_address);
        mItemPhoneNumber = findViewById(R.id.text_place_phone_number);
        mItemWebSite = findViewById(R.id.text_place_website);

        // Get Resource ID from Intent Extras
        final Bundle bundle = getIntent().getExtras();

        //get in the imageResourceId
        int imagesRes = bundle.getInt("image");

        //Assign the imageResourceId to a ImageView in the Activity Place Details
        mItemImage.setImageResource(imagesRes);

        //Assign the textResourceId to a TextView in the Activity Place Details
        mItemDescription.setText(bundle.getInt("description"));

        //Assign the textResourceId to a TextView in the Activity Place Details
        mItemAddress.setText(bundle.getInt("address"));

        //Assign the textResourceId to a TextView in the Activity Place Details
        mItemPhoneNumber.setText(bundle.getInt("phonenumber"));

        //Assign the textResourceId to a TextView in the Activity Place Details
        mItemWebSite.setText(bundle.getInt("website"));

        //Set name of the item on the title bar
        getSupportActionBar().setTitle(bundle.getInt("title"));

        ////To go to the url with an intent
        mItemWebSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(bundle.getInt("website"));
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}



