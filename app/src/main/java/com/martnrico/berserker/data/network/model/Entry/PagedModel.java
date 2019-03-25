package com.martnrico.berserker.data.network.model.Entry;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 28/01/2019.
 */
public class PagedModel<T> {

    @SerializedName("content")
    private List<T> mContent;

    @SerializedName("page")
    private int mPage;

    @SerializedName("size")
    private int mSize;

    @SerializedName("totalElements")
    private long mTotalElements;

    @SerializedName("totalPages")
    private int mTotalPages;

    @SerializedName("last")
    private boolean mLast;

    public PagedModel() {

    }

    public PagedModel(List<T> content, int page, int size, long totalElements, int totalPages, boolean last) {
        this.mContent = content;
        this.mPage = page;
        this.mSize = size;
        this.mTotalElements = totalElements;
        this.mTotalPages = totalPages;
        this.mLast = last;
    }

    public List<T> getContent() {
        return mContent;
    }

    public void setContent(List<T> content) {
        mContent = content;
    }

    public int getPage() {
        return mPage;
    }

    public void setPage(int page) {
        mPage = page;
    }

    public int getSize() {
        return mSize;
    }

    public void setSize(int size) {
        mSize = size;
    }

    public long getTotalElements() {
        return mTotalElements;
    }

    public void setTotalElements(long totalElements) {
        mTotalElements = totalElements;
    }

    public int getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(int totalPages) {
        mTotalPages = totalPages;
    }

    public boolean isLast() {
        return mLast;
    }

    public void setLast(boolean last) {
        mLast = last;
    }
}
