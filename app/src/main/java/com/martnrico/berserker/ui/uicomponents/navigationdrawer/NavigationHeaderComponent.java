package com.martnrico.berserker.ui.uicomponents.navigationdrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 17/12/2018.
 */
public class NavigationHeaderComponent extends RelativeLayout {

    @BindView(R.id.profile_circular_img)
    CircularImageView mProfileImage;

    @BindView(R.id.profile_level)
    TextView mProfileLevel;

    @BindView(R.id.user_name)
    TextView mUserName;

    @BindView(R.id.user_email)
    TextView mUserEmail;

    public NavigationHeaderComponent(Context context) {
        super(context);
        init(context);
    }

    public NavigationHeaderComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NavigationHeaderComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public NavigationHeaderComponent(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.header_nav_drawer, this);
        ButterKnife.bind(this);
    }

    public void setProfileImage(int resource) {
        mProfileImage.setImageResource(resource);
    }

    public void setProfileLevel(String profileLevel) {
        mProfileLevel.setText(profileLevel);
    }

    public void setUserName(String userName) {
        mUserName.setText(userName);
    }

    public void setUserEmail(String userEmail) {
        mUserEmail.setText(userEmail);
    }
}
