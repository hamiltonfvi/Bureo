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
 * A simple {@link LGBTFragment} subclass.
 */
public class LGBTFragment extends Fragment {

    public LGBTFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create an ArrayList using the public class Places
        final ArrayList<Places> places = new ArrayList<>();

        // Create a list of places
        places.add(new Places(R.drawable.bradleys, R.string.bradleys_name, R.string.bradleys_short_description, R.string.bradleys_description, R.string.bradleys_address, R.string.bradleys_phone_number, R.string.bradleys_website));
        places.add(new Places(R.drawable.city_side, R.string.city_side_name, R.string.city_side_short_description, R.string.city_side_description, R.string.city_side_address, R.string.city_side_phone_number, R.string.city_side_website));
        places.add(new Places(R.drawable.enigma, R.string.enigma_name, R.string.enigma_short_description, R.string.enigma_description, R.string.enigma_address, R.string.enigma_phone_number, R.string.enigma_website));
        places.add(new Places(R.drawable.flamingo_resort, R.string.flamingo_resort_name, R.string.flamingo_resort_short_description, R.string.flamingo_resort_description, R.string.flamingo_resort_address, R.string.flamingo_resort_phone_number, R.string.flamingo_resort_website));
        places.add(new Places(R.drawable.the_honey_pot, R.string.the_honey_pot_name, R.string.the_honey_pot_short_description, R.string.the_honey_pot_description, R.string.the_honey_pot_address, R.string.the_honey_pot_phone_number, R.string.the_honey_pot_website));

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