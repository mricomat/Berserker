package com.martnrico.berserker.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Martín Rico Martínez on 21/11/2018.
 */
public class UserModel implements Parcelable {

    @SerializedName("id")
    private Long mUserId;

    @SerializedName("userName")
    private String mUserName;

    @SerializedName("userEmail")
    private String mUserEmail;

    @SerializedName("profilePicUrl")
    private String mProfilePicUrl;

    private String mRank;
    private int mRate;

    public UserModel() {
        // empty constructor required
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        this.mUserId = userId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        this.mUserName = userName;
    }

    public String getUserEmail() {
        return mUserEmail;
    }

    public void setUserEmail(String userEmail) {
        this.mUserEmail = userEmail;
    }

    public String getProfilePicUrl() {
        return mProfilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.mProfilePicUrl = profilePicUrl;
    }

    public String getRank() {
        return mRank;
    }

    public void setRank(String rank) {
        this.mRank = rank;
    }

    public int getRate() {
        return mRate;
    }

    public void setRate(int rate) {
        this.mRate = rate;
    }

    protected UserModel(Parcel in) {
        if (in.readByte() == 0) {
            mUserId = null;
        } else {
            mUserId = in.readLong();
        }
        mUserName = in.readString();
        mUserEmail = in.readString();
        mProfilePicUrl = in.readString();
        mRank = in.readString();
        mRate = in.readInt();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (mUserId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(mUserId);
        }
        parcel.writeString(mUserName);
        parcel.writeString(mUserEmail);
        parcel.writeString(mProfilePicUrl);
        parcel.writeString(mRank);
        parcel.writeInt(mRate);
    }
}
