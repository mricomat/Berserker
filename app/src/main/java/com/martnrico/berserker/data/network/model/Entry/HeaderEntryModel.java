package com.martnrico.berserker.data.network.model.Entry;

/**
 * Created by Martín Rico Martínez on 05/12/2018.
 */
public class HeaderEntryModel {

    private String mName;
    private String mDate;
    private String mPlaceName;
    private String mUrlImage;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getPlaceName() {
        return mPlaceName;
    }

    public void setPlaceName(String placeName) {
        mPlaceName = placeName;
    }

    public String getUrlImage() {
        return mUrlImage;
    }

    public void setUrlImage(String urlImage) {
        mUrlImage = urlImage;
    }
}
