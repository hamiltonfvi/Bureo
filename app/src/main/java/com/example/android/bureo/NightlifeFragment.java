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
 * A simple {@link NightlifeFragment} subclass.
 */
public class NightlifeFragment extends Fragment {

    public NightlifeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create an ArrayList using the public class Places
        final ArrayList<Places> places = new ArrayList<>();

        // Create a list of places
        places.add(new Places(R.drawable.angry_chair, R.string.angry_chair_name, R.string.angry_chair_short_description, R.string.angry_chair_description, R.string.angry_chair_address, R.string.angry_chair_phone_number, R.string.angry_chair_website));
        places.add(new Places(R.drawable.bahama_breeze, R.string.bahama_breeze_name, R.string.bahama_breeze_short_description, R.string.bahama_breeze_description, R.string.bahama_breeze_address, R.string.bahama_breeze_phone_number, R.string.bahama_breeze_website));
        places.add(new Places(R.drawable.brew_bus, R.string.brew_bus_name, R.string.brew_bus_short_description, R.string.brew_bus_description, R.string.brew_bus_address, R.string.brew_bus_phone_number, R.string.brew_bus_website));
        places.add(new Places(R.drawable.cigar_city, R.string.cigar_city_name, R.string.cigar_city_short_description, R.string.cigar_city_description, R.string.cigar_city_address, R.string.cigar_city_phone_number, R.string.cigar_city_website));
        places.add(new Places(R.drawable.coppertail, R.string.coppertail_name, R.string.coppertail_short_description, R.string.coppertail_description, R.string.coppertail_address, R.string.coppertail_phone_number, R.string.coppertail_website));
        places.add(new Places(R.drawable.hyde_park, R.string.hyde_park_village_name, R.string.hyde_park_village_short_description, R.string.hyde_park_village_description, R.string.hyde_park_village_address, R.string.hyde_park_village_phone_number, R.string.hyde_park_village_website));
        places.add(new Places(R.drawable.jannus_live, R.string.jannus_live_name, R.string.jannus_live_short_description, R.string.jannus_live_description, R.string.jannus_live_address, R.string.jannus_live_phone_number, R.string.jannus_live_website));
        places.add(new Places(R.drawable.ulele, R.string.ulele_name, R.string.ulele_short_description, R.string.ulele_description, R.string.ulele_address, R.string.ulele_phone_number, R.string.ulele_website));
        places.add(new Places(R.drawable.whiskey_north, R.string.whiskey_north_name, R.string.whiskey_north_short_description, R.string.whiskey_north_description, R.string.whiskey_north_address, R.string.whiskey_north_phone_number, R.string.whiskey_north_website));
        places.add(new Places(R.drawable.ybor_city, R.string.ybor_city_name, R.string.ybor_city_short_description, R.string.ybor_city_description, R.string.ybor_city_address, R.string.ybor_city_phone_number, R.string.ybor_city_website));

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