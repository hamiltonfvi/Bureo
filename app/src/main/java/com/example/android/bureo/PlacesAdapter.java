package com.example.android.bureo;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

import java.util.ArrayList;

public class PlacesAdapter extends ArrayAdapter<Places> {

    /**
     * Resource ID for the background color for this list of places
     */
    private int mColorResourceId;

    public PlacesAdapter(Activity context, ArrayList<Places> places) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        final Places currentPlace = getItem(position);

        //Find the ImageView in the list_item.xml layout with the ID version_name
        ImageView placePhoto = listItemView.findViewById(R.id.image);

        // Get the version name from the current object and
        // set this text on the name ImageView
        placePhoto.setImageResource(currentPlace.getImageResourceId());

        //Find the TextView in the list_item.xml layout with the ID version_name
        TextView placeItemTitle = listItemView.findViewById(R.id.item_title);

        // Get the version number from the current object and
        // set this text on the name TextVie
        placeItemTitle.setText(currentPlace.getItemTitle());

        //Find the TextView in the list_item.xml layout with the ID version_name
        TextView placeItemDescription = listItemView.findViewById(R.id.item_description);

        // Get the version number from the current object and
        // set this text on the name TextView
        placeItemDescription.setText(currentPlace.getItemDescription());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
