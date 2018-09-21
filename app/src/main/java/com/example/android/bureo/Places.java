package com.example.android.bureo;

public class Places {

    //Item Image
    private int mItemImage;

    //Title of item
    private String mItemTitle;

    //Description of the item
    private String mItemDescription;

    /**
     * Create a new Place Object.
     *
     * @param itemImage       it's drawable resource id of the image asset
     * @param itemTitle       it's item title of the place
     * @param itemDescription it's the item description of the place
     */
    public Places(int itemImage, String itemTitle, String itemDescription) {
        mItemImage = itemImage;
        mItemTitle = itemTitle;
        mItemDescription = itemDescription;
    }

    /**
     *  Get the resource id of the image
     */
    public int getImageResourceId(){
        return mItemImage;
    }

    /**
     *  Get the Item's Title
     */
    public String getItemTitle(){
        return mItemTitle;
    }

    /**
     *  Get the Item's Description
     */
    public String getmItemDescription(){
        return mItemDescription;
    }
}
