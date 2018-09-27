package com.example.android.bureo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context         is the context of the app
     * @param fragmentManager is the fragment manager that will keep each fragment's state in the adapter
     *                        across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ArtFragment();
        } else if (position == 1) {
            return new AttractionsFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else if (position == 3) {
            return new LGBTFragment();
        } else if (position == 4) {
            return new NightlifeFragment();
        } else if (position == 5) {
            return new ShoppingFragment();
        } else {
            return new OutdoorFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 7;
    }

    /**
     * Return the tab titles.
     */

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_arts);
        } else if (position == 1) {
            return mContext.getString(R.string.category_attractions);
        } else if (position == 2) {
            return mContext.getString(R.string.category_food);
        } else if (position == 3) {
            return mContext.getString(R.string.category_lgbt);
        } else if (position == 4) {
            return mContext.getString(R.string.category_nightlife);
        } else if (position == 5) {
            return mContext.getString(R.string.category_shopping);
        } else {
            return mContext.getString(R.string.category_outdoor);
        }
    }
}