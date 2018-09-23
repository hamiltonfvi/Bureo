package com.example.android.bureo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtFragment extends Fragment implements ListView.OnItemClickListener {

    public ArtFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create an ArrayList using the public class Places
        final ArrayList<Places> places = new ArrayList<>();

        // Create a list of places
        places.add(new Places(R.drawable.travel, "Riverwalk", "RiverWalk RiverWalk RiverWalk RiverWalk"));
        places.add(new Places(R.drawable.travel, "StrazCenter", "StrazCenter StrazCenter StrazCenter StrazCenter"));
        places.add(new Places(R.drawable.travel, "Ybor City", "Ybor City Ybor City Ybor City Ybor City"));

        // Create an {@link PlacesAdapter}, whose data source is a list of {@link Places}s. The
        // adapter knows how to create list items for each item in the list.
        PlacesAdapter adapter = new PlacesAdapter(getActivity(), places, R.color.category_arts);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // places_list.xml layout file
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlacesAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Places} in the list.
        listView.setAdapter(adapter);

        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to PlaceContentDescriptionActivity
        listView.setOnItemClickListener(this);

        return rootView;

    }

    //Method to identify ListView item clicked

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        final Context context = getActivity();
        String iExtra = "";

        TextView placesDes = view.findViewById(R.id.text_place_desc);
        String description = placesDes.getText().toString();

        iExtra = description;
        Intent i = new Intent(context, PlaceDetails.class);
        i.putExtra("message",iExtra);
        startActivity(i);
    }
}
