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
 * A simple {@link ArtFragment} subclass.
 */
public class ArtFragment extends Fragment {

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
        places.add(new Places(R.drawable.glazer_childrens_museum, R.string.glazer_childrens_museum_name, R.string.glazer_childrens_museum_short_description, R.string.glazer_childrens_museum_description, R.string.glazer_childrens_museum_address, R.string.glazer_childrens_museum_phone_number, R.string.glazer_childrens_museum_website));
        places.add(new Places(R.drawable.credit_union_amphitheatre, R.string.credit_union_amphitheatre_name, R.string.credit_union_amphitheatre_short_description, R.string.credit_union_amphitheatre_description, R.string.credit_union_amphitheatre_address, R.string.credit_union_amphitheatre_phone_number, R.string.credit_union_amphitheatre_website));
        places.add(new Places(R.drawable.ruck_eckerd_hall, R.string.ruck_eckerd_hall_name, R.string.ruck_eckerd_hall_short_description, R.string.ruck_eckerd_hall_description, R.string.ruck_eckerd_hall_address, R.string.ruck_eckerd_hall_phone_number, R.string.ruck_eckerd_hall_website));
        places.add(new Places(R.drawable.straz_center, R.string.straz_center_name, R.string.straz_center_short_description, R.string.straz_center_description, R.string.straz_center_address, R.string.straz_center_phone_number, R.string.straz_center_website));
        places.add(new Places(R.drawable.tampa_bay_automobile_museum, R.string.automobile_museum_name, R.string.automobile_museum_short_description, R.string.automobile_museum_description, R.string.automobile_museum_address, R.string.automobile_museum_phone_number, R.string.automobile_museum_website));
        places.add(new Places(R.drawable.tampa_bay_history_center, R.string.tampa_bay_history_center_name, R.string.tampa_bay_history_center_short_description, R.string.tampa_bay_history_center_description, R.string.tampa_bay_history_center_address, R.string.tampa_bay_history_center_phone_number, R.string.tampa_bay_history_center_website));
        places.add(new Places(R.drawable.tampa_museum_of_art, R.string.tampa_museum_of_art_name, R.string.tampa_museum_of_art_short_description, R.string.tampa_museum_of_art_description, R.string.tampa_museum_of_art_address, R.string.tampa_museum_of_art_phone_number, R.string.tampa_museum_of_art_website));
        places.add(new Places(R.drawable.the_dali_museum, R.string.the_dali_museum_name, R.string.the_dali_museum_short_description, R.string.the_dali_museum_description, R.string.the_dali_museum_address, R.string.the_dali_museum_phone_number, R.string.the_dali_museum_website));
        places.add(new Places(R.drawable.photographic_arts, R.string.photographic_arts_name, R.string.photographic_arts_short_description, R.string.photographic_arts_description, R.string.photographic_arts_address, R.string.photographic_arts_phone_number, R.string.photographic_arts_website));
        places.add(new Places(R.drawable.the_tampa_theatre, R.string.the_tampa_theatre_name, R.string.the_tampa_theatre_short_description, R.string.the_tampa_theatre_description, R.string.the_tampa_theatre_address, R.string.the_tampa_theatre_phone_number, R.string.the_tampa_theatre_website));

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
                i.putExtra("title", mplace.getItemTitle());
                i.putExtra("description", mplace.getItemDescription());
                i.putExtra("address", mplace.getItemAddress());
                i.putExtra("phonenumber", mplace.getItemPhoneNumber());
                i.putExtra("website", mplace.getItemWebSite());

                startActivity(i);
            }
        });

        return rootView;
    }
}
