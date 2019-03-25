package com.martnrico.berserker.data.network.model.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martín Rico Martínez on 05/12/2018.
 */
public class FooterEntryModel {

    private boolean mIsLike;
    private List<String> mCommentsList = new ArrayList<>();
    private boolean mTypeResult;
    private String mResultWod;
    private List<String> mInfoWod = new ArrayList<>();

    public boolean isLike() {
        return mIsLike;
    }

    public void setLike(boolean like) {
        mIsLike = like;
    }

    public List<String> getCommentsList() {
        return mCommentsList;
    }

    public void setCommentsList(List<String> commentsList) {
        mCommentsList = commentsList;
    }

    public boolean getTypeResult() {
        return mTypeResult;
    }

    public void setTypeResult(boolean typeResult) {
        mTypeResult = typeResult;
    }

    public String getResultWod() {
        return mResultWod;
    }

    public void setResultWod(String resultWod) {
        mResultWod = resultWod;
    }

    public List<String> getInfoWod() {
        return mInfoWod;
    }

    public void setInfoWod(List<String> infoWod) {
        mInfoWod = infoWod;
    }
}
