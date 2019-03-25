package com.martnrico.berserker.ui.uicomponents.navigationdrawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public class NavigationDrawerComponent extends NavigationView {

    private CircularImageView mProfileImage;
    private TextView mProfileLevel;
    private TextView mUserName;
    private TextView mUserEmail;
    private View mHeaderView;

    public NavigationDrawerComponent(Context context) {
        this(context, null);
    }

    public NavigationDrawerComponent(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationDrawerComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.custom_navigation_drawer, this);
        ButterKnife.bind(this);
        mHeaderView = getHeaderView(0);
        if (mHeaderView != null) {
            mProfileImage = mHeaderView.findViewById(R.id.profile_circular_img);
            mProfileLevel = mHeaderView.findViewById(R.id.profile_level);
            mUserName = mHeaderView.findViewById(R.id.user_name);
            mUserEmail = mHeaderView.findViewById(R.id.user_email);
            mUserEmail.setText("asdasda");
        }

        setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home_item_nav:
                        break;
                    case R.id.box_item_nav:
                        break;
                    case R.id.profile_item_nav:
                        break;
                    case R.id.ranking_item_nav:
                        break;
                    case R.id.exercises_item_nav:
                        break;
                    case R.id.wods_item_nav:
                        break;
                    case R.id.settings_item_nav:
                        break;
                    case R.id.about_item_nav:
                        break;
                }
                return false;
            }
        });
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
