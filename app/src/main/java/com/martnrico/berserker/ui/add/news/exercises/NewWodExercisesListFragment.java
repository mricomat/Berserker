package com.martnrico.berserker.ui.add.news.exercises;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.network.model.Entry.WodModel;
import com.martnrico.berserker.data.network.model.ExerciseModel;
import com.martnrico.berserker.ui.add.complete.NewWodCompleteFragment;
import com.martnrico.berserker.ui.base.BaseFragment;
import com.martnrico.berserker.ui.uicomponents.exercises.ExercisesAdapter;
import com.martnrico.berserker.utils.ItemClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.martnrico.berserker.ui.add.complete.NewWodCompleteFragment.COMPLETE_WOD_BOOl_KEY;
import static com.martnrico.berserker.ui.add.complete.NewWodCompleteFragment.COMPLETE_WOD_DATA_KEY;

/**
 * Created by Martín Rico Martínez on 11/03/2019.
 */
public class NewWodExercisesListFragment extends BaseFragment implements NewWodExercisesView, ItemClickListener {

    public static final String EXERCISES_LIST_KEY = "exercises_list_key";

    @Inject
    NewWodExercisesPresenter<NewWodExercisesView> mPresenter;

    private ExercisesAdapter mExercisesAdapter;

    @BindView(R.id.exercise_recycler)
    RecyclerView mExerciseRecycler;

    @BindView(R.id.floating_confirmation_button)
    FloatingActionButton mConfirmationButton;

    @BindView(R.id.change_layout_button)
    FloatingActionButton mChangeLayoutButton;

    public static NewWodExercisesListFragment newInstance(String typeWod) {
        Bundle args = new Bundle();
        args.putString(EXERCISES_LIST_KEY, typeWod);
        NewWodExercisesListFragment fragment = new NewWodExercisesListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exercises_list_fragment, container, false);
        ButterKnife.bind(this, view);

        mExercisesAdapter = new ExercisesAdapter(new ArrayList<ExerciseModel>(), this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onAttach(this);
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void fillViews(View view) {
        mExerciseRecycler.setAdapter(mExercisesAdapter);
        mExerciseRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        setListeners();
    }

    @Override
    public void showExercisesList(List<ExerciseModel> exerciseList) {
        mExercisesAdapter.setExerciseList(exerciseList);
    }

    @Override
    public void changeTitleBar(String typeWod) {
        TextView titleBar = (TextView) getBaseActivity().findViewById(R.id.title_screen);
        if (titleBar != null) {
            Animation animation_out = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
            Animation animation_in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
            titleBar.startAnimation(animation_out);
            titleBar.setText(typeWod);
            titleBar.setTextSize(20);
            titleBar.startAnimation(animation_in);
        }
    }

    @Override
    public void navigateToCompleteNewWodFragment(WodModel wodModel) {
        FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();

        fragmentManager.popBackStack();
        fragmentManager.popBackStack();

        if (fragmentManager.getBackStackEntryCount() != 3) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.add_wod_container, NewWodCompleteFragment.newInstance(wodModel),
                            COMPLETE_WOD_DATA_KEY)
                    .addToBackStack(null)
                    .commit();
        } else {
            Bundle args = new Bundle();
            args.putParcelable(COMPLETE_WOD_DATA_KEY, wodModel);
            args.putBoolean(COMPLETE_WOD_BOOl_KEY, true);

            Fragment fragment = fragmentManager.findFragmentByTag(NewWodCompleteFragment.COMPLETE_WOD_DATA_KEY);
            if (fragment != null) {
                fragment.setArguments(args);
            }
        }
    }

    private void setListeners() {
        mConfirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onConfirmationButtonClick();
            }
        });

        mChangeLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mExercisesAdapter.isSquareLayout()) {
                    mChangeLayoutButton.setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.cub_icon));
                    mExercisesAdapter.setSquareLayout(false);
                    mExerciseRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                } else {
                    mChangeLayoutButton.setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.menu));
                    mExercisesAdapter.setSquareLayout(true);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                    mExerciseRecycler.setLayoutManager(gridLayoutManager);
                }
                mPresenter.getExercisesList();
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        LinearLayout selectedContainer = view.findViewById(R.id.selected_container);

        if (selectedContainer.getVisibility() == View.GONE) {
            selectedContainer.setVisibility(View.VISIBLE);
        } else {
            selectedContainer.setVisibility(View.GONE);
        }

        mPresenter.exerciseSelected(position);
    }
}
