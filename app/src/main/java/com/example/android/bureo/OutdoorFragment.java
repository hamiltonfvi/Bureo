package com.example.android.bureo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link OutdoorFragment} subclass.
 */
public class OutdoorFragment extends Fragment {

    public OutdoorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create an ArrayList using the public class Places
        final ArrayList<Places> places = new ArrayList<>();

        // Create a list of places
        places.add(new Places(R.drawable.adventure_island, R.string.adventure_island_name, R.string.adventure_island_short_description, R.string.adventure_island_description, R.string.adventure_island_address, R.string.adventure_island_phone_number, R.string.adventure_island_website));
        places.add(new Places(R.drawable.busch_gardens, R.string.busch_gardens_name, R.string.busch_gardens_short_description, R.string.busch_gardens_description, R.string.busch_gardens_address, R.string.busch_gardens_phone_number, R.string.busch_gardens_website));
        places.add(new Places(R.drawable.clearwater_beach, R.string.clearwater_beach_name, R.string.clearwater_beach_short_description, R.string.clearwater_beach_description, R.string.clearwater_beach_address, R.string.clearwater_beach_phone_number, R.string.clearwater_beach_website));
        places.add(new Places(R.drawable.clearwater_marine_aquarium, R.string.clearwater_marine_aquarium_name, R.string.clearwater_beach_short_description, R.string.clearwater_marine_aquarium_description, R.string.clearwater_marine_aquarium_address, R.string.clearwater_marine_aquarium_phone_number, R.string.clearwater_marine_aquarium_website));
        places.add(new Places(R.drawable.curtis_hixon_water_park, R.string.curtis_hixon_water_park_name, R.string.curtis_hixon_water_park_short_description, R.string.curtis_hixon_water_park_description, R.string.curtis_hixon_water_park_address, R.string.curtis_hixon_water_park_phone_number, R.string.curtis_hixon_water_park_website));
        places.add(new Places(R.drawable.florida_aquarium, R.string.florida_aquarium_name, R.string.florida_aquarium_short_description, R.string.florida_aquarium_description, R.string.florida_aquarium_address, R.string.florida_aquarium_phone_number, R.string.florida_aquarium_website));
        places.add(new Places(R.drawable.riverwalk, R.string.riverwalk_name, R.string.riverwalk_short_description, R.string.riverwalk_description, R.string.riverwalk_address, R.string.riverwalk_phone_number, R.string.riverwalk_website));

        // Create an {@link PlacesAdapter}, whose data source is a list of {@link Places}s. The
        // adapter knows how to create list items for each item in the list.
        PlacesAdapter adapter = new PlacesAdapter(getActivity(), places);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // places_list.xml layout file
        final ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlacesAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Places} in the list.
        listView.setAdapter(adapter);

        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to PlaceDetails Activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Places mplace = (Places) listView.getItemAtPosition(position);

                Intent i = new Intent(getActivity(), PlaceDetails.class);
                i.putExtra("image", mplace.getImageResourceId());
                i.putExtra("title",mplace.getItemTitle());
                i.putExtra("description", mplace.getItemDescription());
                i.putExtra("address",mplace.getItemAddress());
                i.putExtra("phonenumber",mplace.getItemPhoneNumber());
                i.putExtra("website",mplace.getItemWebSite());

                startActivity(i);
            }
        });

        return rootView;
    }
}