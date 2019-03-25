package com.martnrico.berserker.data.network.model;

/**
 * Created by Martín Rico Martínez on 11/03/2019.
 */

public class ExerciseModel {

    private String mName;
    private String mDescription;
    private String urlVideoExp;
    private String urlBackgroundImg;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getUrlVideoExp() {
        return urlVideoExp;
    }

    public void setUrlVideoExp(String urlVideoExp) {
        this.urlVideoExp = urlVideoExp;
    }

    public String getUrlBackgroundImg() {
        return urlBackgroundImg;
    }

    public void setUrlBackgroundImg(String urlBackgroundImg) {
        this.urlBackgroundImg = urlBackgroundImg;
    }
}
