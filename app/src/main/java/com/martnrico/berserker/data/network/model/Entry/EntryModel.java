package com.martnrico.berserker.data.network.model.Entry;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.martnrico.berserker.data.network.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martín Rico Martínez on 05/12/2018.
 */
public class EntryModel implements Parcelable {

    @SerializedName("id")
    private Long mId;

    @SerializedName("date")
    private Long mDate;

    @SerializedName("place")
    private String mPlace;

    @SerializedName("userModel")
    private UserModel mUserModel; // TODO CAMBIR POR UN SUMARY DEL USER

    @SerializedName("wodModel")
    private WodModel mWodModel;

    @SerializedName("isLike")
    private boolean mIsLike;

    @SerializedName("isScaled")
    private boolean mIsScaled;

    @SerializedName("resultWod")
    private String mResultWod;

    @SerializedName("commentsList")
    private List<String> mCommentList = new ArrayList<>();

    @SerializedName("infoWod")
    private List<String> mInfoWod = new ArrayList<>();

    public EntryModel() {
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

    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        mPlace = place;
    }

    public UserModel getUserModel() {
        return mUserModel;
    }

    public void setUserModel(UserModel userModel) {
        mUserModel = userModel;
    }

    public WodModel getWodModel() {
        return mWodModel;
    }

    public void setWodModel(WodModel wodModel) {
        mWodModel = wodModel;
    }

    public String getResultWod() {
        return mResultWod;
    }

    public void setResultWod(String resultWod) {
        mResultWod = resultWod;
    }

    public boolean isLike() {
        return mIsLike;
    }

    public void setLike(boolean like) {
        mIsLike = like;
    }

    public boolean isScaled() {
        return mIsScaled;
    }

    public void setScaled(boolean scaled) {
        mIsScaled = scaled;
    }

    public List<String> getCommentList() {
        return mCommentList;
    }

    public void setCommentList(List<String> commentList) {
        mCommentList = commentList;
    }

    public List<String> getInfoWod() {
        return mInfoWod;
    }

    public void setInfoWod(List<String> infoWod) {
        mInfoWod = infoWod;
    }

    protected EntryModel(Parcel in) {
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
        mPlace = in.readString();
        mUserModel = in.readParcelable(UserModel.class.getClassLoader());
        mWodModel = in.readParcelable(WodModel.class.getClassLoader());
        mIsLike = in.readByte() != 0;
        mIsScaled = in.readByte() != 0;
        mResultWod = in.readString();
        mCommentList = in.createStringArrayList();
        mInfoWod = in.createStringArrayList();
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
        dest.writeString(mPlace);
        dest.writeParcelable(mUserModel, flags);
        dest.writeParcelable(mWodModel, flags);
        dest.writeByte((byte) (mIsLike ? 1 : 0));
        dest.writeByte((byte) (mIsScaled ? 1 : 0));
        dest.writeString(mResultWod);
        dest.writeStringList(mCommentList);
        dest.writeStringList(mInfoWod);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EntryModel> CREATOR = new Creator<EntryModel>() {
        @Override
        public EntryModel createFromParcel(Parcel in) {
            return new EntryModel(in);
        }

        @Override
        public EntryModel[] newArray(int size) {
            return new EntryModel[size];
        }
    };
}
