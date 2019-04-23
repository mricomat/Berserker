package com.martnrico.berserker.data.network.form;

import com.martnrico.berserker.data.network.model.WodUserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martín Rico Martínez on 23/04/2019.
 */
public class AddWodForm {

    private Long mId;
    private Long mDate;
    private Long mUserId;
    private List<WodUserModel> mWodUserList = new ArrayList<>();

    public AddWodForm() {

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

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public List<WodUserModel> getWodUserList() {
        return mWodUserList;
    }

    public void setWodUserList(List<WodUserModel> wodUserList) {
        mWodUserList = wodUserList;
    }
}
