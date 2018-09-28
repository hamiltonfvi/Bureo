package com.example.android.bureo;

public class Places {

    //Item Image
    private int mItemImage;

    //Title of item
    private int mItemTitle;

    //Description of the item
    private int mItemDescription;

    //Item Address
    private int mItemAddress;

    //Item Phone Number
    private int mItemPhoneNumber;

    //Item WebSite
    private int mItemWebSite;

    /**
     * Create a new Place Object.
     *
     * @param itemImage       it's drawable resource id of the image asset
     * @param itemTitle       it's item title of the place
     * @param itemDescription it's the item description of the place
     * @param itemAddress it's the item website of the place
     * @param itemPhoneNumber it's the item phone number of the place
     * @param itemWebSite it's the item Website of the place
     */
    public Places(int itemImage, int itemTitle, int itemDescription, int itemAddress, int itemPhoneNumber, int itemWebSite) {
        mItemImage = itemImage;
        mItemTitle = itemTitle;
        mItemDescription = itemDescription;
        mItemAddress = itemAddress;
        mItemPhoneNumber = itemPhoneNumber;
        mItemWebSite = itemWebSite;
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
    public int getItemTitle(){
        return mItemTitle;
    }

    /**
     *  Get the Item's Description
     */
    public int getItemDescription(){
        return mItemDescription;
    }

    /**
     *  Get the Item's Address
     */
    public int getItemAddress(){
        return mItemAddress;
    }

    /**
     *  Get the Item's Phone Number
     */
    public int getItemPhoneNumber(){
        return mItemPhoneNumber;
    }

    /**
     *  Get the Item's Website
     */
    public int getItemWebSite(){
        return mItemWebSite;
    }
}
