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
 * A simple {@link FoodFragment} subclass.
 */
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create an ArrayList using the public class Places
        final ArrayList<Places> places = new ArrayList<>();

        // Create a list of places
        places.add(new Places(R.drawable.columbia_restaurant, R.string.columbia_restaurant_name, R.string.columbia_restaurant_description, R.string.columbia_restaurant_address, R.string.columbia_restaurant_phone_number, R.string.columbia_restaurant_website));
        places.add(new Places(R.drawable.eddie_sam, R.string.eddie_sam_name, R.string.eddie_sam_description, R.string.eddie_sam_address, R.string.eddie_sam_phone_number, R.string.eddie_sam_website));
        places.add(new Places(R.drawable.green_lemon, R.string.green_lemon_name, R.string.green_lemon_description, R.string.green_lemon_address, R.string.green_lemon_phone_number, R.string.green_lemon_website));
        places.add(new Places(R.drawable.la_teresita_restaurant, R.string.la_teresita_restaurant_name, R.string.la_teresita_restaurant_description, R.string.la_teresita_restaurant_address, R.string.la_teresita_restaurant_phone_number, R.string.la_teresita_restaurant_website));
        places.add(new Places(R.drawable.la_terraza_restaurant, R.string.la_terraza_restaurant_name, R.string.la_terraza_restaurant_description, R.string.la_terraza_restaurant_address, R.string.la_terraza_restaurant_phone_number, R.string.la_terraza_restaurant_website));

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