package com.example.android.bureo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        places.add(new Places(R.drawable.travel,"Flamingos", "Talk Talk Talk Talk Talk Talk"));
        places.add(new Places(R.drawable.travel,"Bradleys", "Talk Talk Talk Talk Talk Talk"));
        places.add(new Places(R.drawable.travel,"City Side", "Talk Talk Talk Talk Talk Talk"));

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // places_list.xml layout file
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        return rootView;

    }
}
