package com.martnrico.berserker.ui.addwod.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.network.model.UserModel;
import com.martnrico.berserker.ui.base.BaseFragment;
import com.martnrico.berserker.ui.addwod.news.exercises.NewWodExercisesListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 07/03/2019.
 */
public class NewWodTypeWodListFragment extends BaseFragment {

    public static final String ADD_WOD_DATA_KEY = "add_wod_data_key";

    @BindView(R.id.open_strength_item)
    CardView mOpenStrengthItem;

    @BindView(R.id.for_time_item)
    CardView mForTimeItem;

    @BindView(R.id.reps_for_time_item)
    CardView mRepsForTimeItem;

    @BindView(R.id.amrap_item)
    CardView mAmrapItem;

    @BindView(R.id.emon_item)
    CardView mEmonItem;

    @BindView(R.id.tabata_item)
    CardView mTabataItem;

    private boolean mFirstInstance = true;

    public static NewWodTypeWodListFragment newInstance(UserModel userModel) {
        Bundle args = new Bundle();
        args.putParcelable(ADD_WOD_DATA_KEY, userModel);
        NewWodTypeWodListFragment fragment = new NewWodTypeWodListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_wod_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!mFirstInstance) {
            TextView titleBar = (TextView) getBaseActivity().findViewById(R.id.title_screen);
            if (titleBar != null) {
                Animation animation_out = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
                Animation animation_in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
                titleBar.startAnimation(animation_out);
                titleBar.setText("WOD");
                titleBar.setTextSize(30);
                titleBar.startAnimation(animation_in);
            }
        }
        mFirstInstance = false;
    }

    @Override
    protected void fillViews(View view) {
        setListeners();
    }

    private void setListeners() { // TODO REFACTOR
        mOpenStrengthItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateNewWodNextFragment(getString(R.string.open_strength_title));
            }
        });

        mForTimeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateNewWodNextFragment(getString(R.string.for_time_title));
            }
        });

        mRepsForTimeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateNewWodNextFragment(getString(R.string.reps_for_time_title));
            }
        });

        mAmrapItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateNewWodNextFragment(getString(R.string.amrap_title));
            }
        });

        mEmonItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateNewWodNextFragment(getString(R.string.emon_title));
            }
        });

        mTabataItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateNewWodNextFragment(getString(R.string.tabata_title));
            }
        });
    }

    private void navigateNewWodNextFragment(String typeWod) {
        getBaseActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.add_wod_container, NewWodExercisesListFragment.newInstance(typeWod),
                        NewWodExercisesListFragment.EXERCISES_LIST_KEY)
                .addToBackStack(null)
                .commit();
    }
}
