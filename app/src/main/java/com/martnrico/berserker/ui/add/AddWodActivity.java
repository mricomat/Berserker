package com.martnrico.berserker.ui.add;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.network.model.UserModel;
import com.martnrico.berserker.ui.add.news.NewWodTypeListFragment;
import com.martnrico.berserker.ui.add.previous.PreviousWodFragment;
import com.martnrico.berserker.ui.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public class AddWodActivity extends BaseActivity {

    public static final String ADD_WOD_DATA_KEY = "add_wod_data_key";

    public static final String BOX_WODS = "box_wods";
    public static final String OLD_WODS = "old_wods";
    public static final String FAV_WODS = "fav_wods";

    @BindView(R.id.left_arrow)
    ImageView mReturnArrow;

    @BindView(R.id.box_wod_button)
    Button mBoxButton;

    @BindView(R.id.old_wod_button)
    Button mOldWodButton;

    @BindView(R.id.fav_button)
    Button mFavButton;

    @BindView(R.id.new_wod_button)
    Button mNewWodButton;

    @BindView(R.id.buttons_container)
    RelativeLayout mButtonsContainer;

    @BindView(R.id.cancel_button)
    TextView mCancelButton;

    @BindView(R.id.title_screen)
    TextView mTittleBar;

    private UserModel mUserModel;

    @Override
    protected int layoutRes() {
        return R.layout.add_wod_activity;
    }

    public static Intent getStartIntent(Context context, UserModel userModel) {
        Intent intent = new Intent(context, AddWodActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(ADD_WOD_DATA_KEY, userModel);
        intent.putExtras(extras);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mUserModel = bundle.getParcelable(ADD_WOD_DATA_KEY);
        }

        mCancelButton.setVisibility(View.GONE);

        setListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void setListeners() {
        mReturnArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                int count = getSupportFragmentManager().getBackStackEntryCount();
                if (count == 0) {
                    if (mButtonsContainer.getVisibility() != View.VISIBLE) {
                        setTitleBar();
                        setButtonsVisibilityVisible();
                    }
                }
            }
        });

        mNewWodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonsVisibilityGone();

                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                        .replace(R.id.add_wod_container, NewWodTypeListFragment.newInstance(mUserModel),
                                NewWodTypeListFragment.ADD_WOD_DATA_KEY)
                        .addToBackStack(null)
                        .commit();
                mCancelButton.setVisibility(View.VISIBLE);
            }
        });

        mBoxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigatePreviousFragment(BOX_WODS);
            }
        });

        mOldWodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigatePreviousFragment(OLD_WODS);
            }
        });

        mFavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigatePreviousFragment(FAV_WODS);
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setButtonsVisibilityGone() {
        Animation animation_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        Animation animation_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        mButtonsContainer.startAnimation(animation_in);
        mButtonsContainer.startAnimation(animation_out);
        mButtonsContainer.setVisibility(View.GONE);
    }

    private void setButtonsVisibilityVisible() {
        Animation animation_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        Animation animation_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        mButtonsContainer.startAnimation(animation_out);
        mButtonsContainer.startAnimation(animation_in);
        mButtonsContainer.setVisibility(View.VISIBLE);
    }

    private void setTitleBar() {
        if (!mTittleBar.getText().toString().equals("WOD")) {
            Animation animation_out = AnimationUtils.loadAnimation(this, R.anim.fade_out);
            Animation animation_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            mTittleBar.startAnimation(animation_out);
            mTittleBar.setText("WOD");
            mTittleBar.setTextSize(30);
            mTittleBar.startAnimation(animation_in);
        }
    }

    private void navigatePreviousFragment(String previousPlace) {
        mButtonsContainer.setVisibility(View.GONE);
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.add_wod_container, PreviousWodFragment.newInstance(previousPlace),
                        PreviousWodFragment.PREVIOUS_WOD_KEY)
                .addToBackStack(null)
                .commit();
    }
}
