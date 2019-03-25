package com.martnrico.berserker.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.martnrico.berserker.data.network.model.Entry.EntryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martín Rico Martínez on 30/01/2019.
 */
public class HomeDataModel implements Parcelable {

    private UserModel mUserModel;
    private List<EntryModel> mEntriesList = new ArrayList<EntryModel>(); // TODO RECCURRENCIA DENTRO DE USER MODEL ELIMINAR

    public HomeDataModel() {
        // Empty constructor needed
    }

    public HomeDataModel(UserModel userModel) {
        this.mUserModel = userModel;
    }

    public HomeDataModel(UserModel userModel, List<EntryModel> entriesList) {
        mUserModel = userModel;
        mEntriesList = entriesList;
    }

    public UserModel getUserModel() {
        return mUserModel;
    }

    public void setUserModel(UserModel userModel) {
        mUserModel = userModel;
    }

    public List<EntryModel> getEntriesList() {
        return mEntriesList;
    }

    public void setEntriesList(List<EntryModel> entriesList) {
        mEntriesList = entriesList;
    }

    protected HomeDataModel(Parcel in) {
        mUserModel = in.readParcelable(UserModel.class.getClassLoader());
        mEntriesList = in.createTypedArrayList(EntryModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mUserModel, flags);
        dest.writeTypedList(mEntriesList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeDataModel> CREATOR = new Creator<HomeDataModel>() {
        @Override
        public HomeDataModel createFromParcel(Parcel in) {
            return new HomeDataModel(in);
        }

        @Override
        public HomeDataModel[] newArray(int size) {
            return new HomeDataModel[size];
        }
    };
}
