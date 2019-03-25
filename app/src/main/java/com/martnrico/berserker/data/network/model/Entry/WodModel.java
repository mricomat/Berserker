package com.martnrico.berserker.data.network.model.Entry;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martín Rico Martínez on 05/12/2018.
 */
public class WodModel implements Parcelable {

    @SerializedName("id")
    private Long mId;

    @SerializedName("date")
    private Long mDate;

    @SerializedName("typeWod")
    private String mTypeWod; // TODO Change for a list of ints and use with that enums predefined

    @SerializedName("exerciseList")
    private List<String> mExerciseList = new ArrayList<>(); // TODO Change for a list of ints and use with that enums predefined

    @SerializedName("uriBackground")
    private String mUriBackground;

    public WodModel() {
        // Empty constructor needed
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getDate() {
        return mDate;
    }

    public void setDate(Long date) {
        mDate = date;
    }

    public String getTypeWod() {
        return mTypeWod;
    }

    public void setTypeWod(String typeWod) {
        mTypeWod = typeWod;
    }

    public List<String> getExerciseList() {
        return mExerciseList;
    }

    public void setExerciseList(List<String> exerciseList) {
        mExerciseList = exerciseList;
    }

    public String getUriBackground() {
        return mUriBackground;
    }

    public void setUriBackground(String uriBackground) {
        mUriBackground = uriBackground;
    }

    protected WodModel(Parcel in) {
        if (in.readByte() == 0) {
            mId = null;
        } else {
            mId = in.readLong();
        }
        if (in.readByte() == 0) {
            mDate = null;
        } else {
            mDate = in.readLong();
        }
        mTypeWod = in.readString();
        mExerciseList = in.createStringArrayList();
        mUriBackground = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mId);
        }
        if (mDate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mDate);
        }
        dest.writeString(mTypeWod);
        dest.writeStringList(mExerciseList);
        dest.writeString(mUriBackground);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WodModel> CREATOR = new Creator<WodModel>() {
        @Override
        public WodModel createFromParcel(Parcel in) {
            return new WodModel(in);
        }

        @Override
        public WodModel[] newArray(int size) {
            return new WodModel[size];
        }
    };
}
