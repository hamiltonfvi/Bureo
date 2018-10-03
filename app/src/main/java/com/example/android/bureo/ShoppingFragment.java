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
 * A simple {@link ShoppingFragment} subclass.
 */
public class ShoppingFragment extends Fragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create an ArrayList using the public class Places
        final ArrayList<Places> places = new ArrayList<>();

        // Create a list of places
        places.add(new Places(R.drawable.armature_works, R.string.armature_works_name, R.string.armature_works_short_description, R.string.armature_works_description, R.string.armature_works_address, R.string.armature_works_phone_number, R.string.armature_works_website));
        places.add(new Places(R.drawable.international_plaza, R.string.international_plaza_name, R.string.international_plaza_short_description, R.string.international_plaza_description, R.string.international_plaza_address, R.string.international_plaza_phone_number, R.string.international_plaza_website));
        places.add(new Places(R.drawable.tampa_premium_outlets, R.string.tampa_premium_outlets_name, R.string.tampa_premium_outlets_short_description, R.string.tampa_premium_outlets_description, R.string.tampa_premium_outlets_address, R.string.tampa_premium_outlets_phone_number, R.string.tampa_premium_outlets_website));
        places.add(new Places(R.drawable.the_shops_at_wiregrass, R.string.the_shops_at_wiregrass_name, R.string.the_shops_at_wiregrass_short_description, R.string.the_shops_at_wiregrass_description, R.string.the_shops_at_wiregrass_address, R.string.the_shops_at_wiregrass_phone_number, R.string.the_shops_at_wiregrass_website));
        places.add(new Places(R.drawable.tyrone_square, R.string.tyrone_square_name, R.string.tyrone_square_short_description, R.string.tyrone_square_description, R.string.tyrone_square_address, R.string.tyrone_square_phone_number, R.string.tyrone_square_website));
        places.add(new Places(R.drawable.university_mall, R.string.university_mall_name, R.string.university_mall_short_description, R.string.university_mall_description, R.string.university_mall_address, R.string.university_mall_phone_number, R.string.university_mall_website));
        places.add(new Places(R.drawable.westfield_citrus_park, R.string.westfield_citrus_park_name, R.string.westfield_citrus_park_short_description,R.string.westfield_citrus_park_description, R.string.westfield_citrus_park_address, R.string.westfield_citrus_park_phone_number, R.string.westfield_citrus_park_website));
        places.add(new Places(R.drawable.westshore_plaza, R.string.westshore_plaza_name, R.string.westshore_plaza_short_description, R.string.westshore_plaza_description, R.string.westshore_plaza_address, R.string.westshore_plaza_phone_number, R.string.westshore_plaza_website));
        places.add(new Places(R.drawable.unlock_tampa_bay_visitors_center, R.string.unlock_tampa_bay_visitors_center_name, R.string.unlock_tampa_bay_visitors_center_short_description, R.string.unlock_tampa_bay_visitors_center_description, R.string.unlock_tampa_bay_visitors_center_address, R.string.unlock_tampa_bay_visitors_center_phone_number, R.string.unlock_tampa_bay_visitors_center_website));
        places.add(new Places(R.drawable.ybor_city_saturday_market, R.string.ybor_city_saturday_market_name, R.string.ybor_city_saturday_market_short_description, R.string.ybor_city_saturday_market_description, R.string.ybor_city_saturday_market_address, R.string.ybor_city_saturday_market_phone_number, R.string.ybor_city_saturday_market_website));

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
