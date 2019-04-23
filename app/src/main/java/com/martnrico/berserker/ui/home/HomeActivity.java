package com.martnrico.berserker.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.data.network.model.HomeDataModel;
import com.martnrico.berserker.data.network.model.UserModel;
import com.martnrico.berserker.ui.add.AddWodActivity;
import com.martnrico.berserker.ui.base.BaseActivity;
import com.martnrico.berserker.ui.uicomponents.customheader.CustomHeader;
import com.martnrico.berserker.ui.uicomponents.customheader.CustomHeaderBehavior;
import com.martnrico.berserker.ui.uicomponents.entryitem.EntryAdapter;
import com.martnrico.berserker.ui.uicomponents.entryitem.EntryItemListener;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public class HomeActivity extends BaseActivity implements HomeView, EntryItemListener {

    public static final String HOME_DATA_KEY = "home_data_key";

    @Inject
    HomePresenter<HomeView> mPresenter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.container_progressBar)
    RelativeLayout mListProgressBar;

    @BindView(R.id.floating_add_wod_button)
    FloatingActionButton mAddWodButton;

    @BindView(R.id.navigation_drawer)
    NavigationView mNavigationView;

    @BindView(R.id.drawer_container)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.custom_header)
    CustomHeader mCustomHeader;

    private EntryAdapter mAdapter;
    private CustomHeaderBehavior mCustomHeaderBehavior;
    private CircularImageView mProfileImage;
    private TextView mProfileLevel;
    private TextView mUserName;
    private TextView mUserEmail;
    private View mHeaderView;

    @Override
    protected int layoutRes() {
        return R.layout.home_activity;
    }

    public static Intent getStartIntent(Context context, HomeDataModel homeData) {
        Intent intent = new Intent(context, HomeActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(HOME_DATA_KEY, homeData);
        intent.putExtras(extras);
        return intent;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onAttach(this);
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void onViewBound() {
        mCustomHeaderBehavior = mCustomHeader;

        mHeaderView = mNavigationView.getHeaderView(0);
        if (mHeaderView != null) {
            mProfileImage = mHeaderView.findViewById(R.id.profile_circular_img);
            mProfileLevel = mHeaderView.findViewById(R.id.profile_level);
            mUserName = mHeaderView.findViewById(R.id.user_name);
            mUserEmail = mHeaderView.findViewById(R.id.user_email);
        }
        mAdapter = new EntryAdapter(new ArrayList<EntryModel>(), this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        setListeners();
    }

    @Override
    protected void setListeners() {
        super.setListeners();

        // Schedule listener
        mCustomHeaderBehavior.setIconLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "asd", Toast.LENGTH_SHORT).show();
            }
        });

        // Bookings listener
        mCustomHeaderBehavior.setIconRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "asd", Toast.LENGTH_SHORT).show();
            }
        });

        // Crossfit icon listener
        mCustomHeaderBehavior.setIconCenterListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "asd", Toast.LENGTH_SHORT).show();
            }
        });

        // Navigation Drawer listener
        mCustomHeaderBehavior.setIconTopLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // Settings listener
        mCustomHeaderBehavior.setIconTopRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.navigateToSettings();
            }
        });

        // Add new Entry listener
        mAddWodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onNewWodClick();
            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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

    @Override
    public void showEntryList(List<EntryModel> entryModelList) {
        mAdapter.setEntryModelList(entryModelList);
    }

    @Override
    public void fillView(HomeDataModel homeData) {
        // TODO mProfileImage.setImageResource();
        mUserName.setText(homeData.getUserModel().getUserName());
        mUserEmail.setText(homeData.getUserModel().getUserEmail());
        mProfileLevel.setText(homeData.getUserModel().getRank());

        mNavigationView.getMenu().findItem(R.id.home_item_nav).getIcon()
                .setColorFilter(getColor(R.color.red_theme), PorterDuff.Mode.SRC_ATOP);
    }

    @Override
    public void changeLikeState(boolean like, int position) {
        mAdapter.getItemByPosition(position).setLike(like);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoadingList() {
        mListProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingList() {
        mListProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void navigateAddWodActivity(UserModel userModel) {
        Intent intent = AddWodActivity.getStartIntent(HomeActivity.this, userModel);
        startActivity(intent);
        // TODO Animation
    }

    @Override
    public void onClickLikeButton(boolean like, int position) {
        mPresenter.updateLike(like, position);
    }

    @Override
    public void onClickBoardButton() {
        mPresenter.boardButtonAction();
    }

    @Override
    public void onClickCommentButton() {
       // TODO
    }

    @Override
    public void onClickEntry(int position) {
        // We do nothing here
    }
}
