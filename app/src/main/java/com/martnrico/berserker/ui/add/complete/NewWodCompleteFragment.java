package com.martnrico.berserker.ui.add.complete;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.network.model.Entry.WodModel;
import com.martnrico.berserker.data.network.model.UserModel;
import com.martnrico.berserker.ui.add.news.NewWodTypeListFragment;
import com.martnrico.berserker.ui.base.BaseFragment;
import com.martnrico.berserker.ui.uicomponents.complete.CompleteNewWodAdapter;
import com.martnrico.berserker.ui.uicomponents.complete.CompleteNewWodListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.martnrico.berserker.ui.add.news.NewWodTypeListFragment.ADD_WOD_DATA_KEY;

/**
 * Created by Martín Rico Martínez on 08/04/2019.
 */
public class NewWodCompleteFragment extends BaseFragment implements NewWodCompleteView {

    public static final String COMPLETE_WOD_DATA_KEY = "complete_wod_data_key";
    public static final String COMPLETE_WOD_BOOl_KEY = "complete_wod_bool_key";

    @Inject
    NewWodCompletePresenter<NewWodCompleteView> mPresenter;

    @BindView(R.id.complete_new_recyclerView)
    RecyclerView mCompleteRecyclerView;

    @BindView(R.id.floating_more_wod)
    FloatingActionButton mMoreWodButton;

    @BindView(R.id.calendar_img)
    ImageView mCalendarImg;

    @BindView(R.id.date_text)
    TextView mDateText;

    private CompleteNewWodAdapter mCompleteAdapter;
    private List<WodModel> mWodList = new ArrayList<>();

    public static NewWodCompleteFragment newInstance(WodModel wodModel) {
        Bundle args = new Bundle();
        args.putParcelable(COMPLETE_WOD_DATA_KEY, wodModel);
        NewWodCompleteFragment fragment = new NewWodCompleteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.complete_new_wod_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onAttach(this);
        mPresenter.updateArguments(getArguments());
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void fillViews(View view) {
        setTitleBar();
        setRightButtonBar();

        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM");
        mDateText.setText(dateFormat.format(date));
        mCompleteAdapter = new CompleteNewWodAdapter(new ArrayList<WodModel>(), new CompleteNewWodListener() {
            @Override
            public void onOptionsButtonClicked() {

            }

            @Override
            public void onOptionsExerciseClicked(int position) {

            }
        });

        mCompleteRecyclerView.setAdapter(mCompleteAdapter);
        mCompleteRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mMoreWodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateNewWodTypeListFragment();
            }
        });
    }

    @Override
    public void showWodList(List<WodModel> wodList) {
        mCompleteAdapter.addWodList(wodList);
    }


    private void setTitleBar() {
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

    private void setRightButtonBar() {
        TextView titleBar = (TextView) getBaseActivity().findViewById(R.id.cancel_button);
        if (titleBar != null) {
            Animation animation_out = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
            Animation animation_in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
            titleBar.startAnimation(animation_out);
            titleBar.setText("Post");
            titleBar.setTextSize(20);
            titleBar.startAnimation(animation_in);
        }
    }

    private void navigateNewWodTypeListFragment() {
        FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.add_wod_container, NewWodTypeListFragment.newInstance(new UserModel()),
                        ADD_WOD_DATA_KEY)
                .addToBackStack(null)
                .commit();
    }
}
