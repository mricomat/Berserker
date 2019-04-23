package com.martnrico.berserker.ui.uicomponents.complete;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.ui.uicomponents.complete.exercises.CompleteExercisesAdapter;
import com.martnrico.berserker.utils.ItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 08/04/2019.
 */
public class CompleteNewWodComponent extends RelativeLayout {

    @BindView(R.id.type_wod_title)
    TextView mTypeWod;

    @BindView(R.id.rx_button)
    Button mRxButton;

    @BindView(R.id.scaled_button)
    Button mScaledButton;

    @BindView(R.id.options_button)
    ImageView mOptionsButton;

    @BindView(R.id.exercises_recycler_view)
    RecyclerView mExercisesRecycler;

    @BindView(R.id.add_round_button)
    Button mAddRoundButton;

    @BindView(R.id.time_ed)
    EditText mTimeEditText;

    @BindView(R.id.round_ed)
    EditText mRoundsEditText;

    @BindView(R.id.floating_wod_completed)
    FloatingActionButton mWodCompletedButton;

    @BindView(R.id.wod_completed_text)
    TextView mWodCompletedText;

    private ItemClickListener mOptionsExerciseListener;
    private CompleteExercisesAdapter mCompleteExercisesAdapter;

    public CompleteNewWodComponent(Context context) {
        super(context);
        init(context);
    }

    public CompleteNewWodComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CompleteNewWodComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.complete_new_wod_item, this);
        ButterKnife.bind(this);

        mWodCompletedButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mWodCompletedText.getText().toString().equals("Wod Not Completed")) {
                    mWodCompletedText.setText("Wod Completed");
                    mWodCompletedButton.setImageDrawable(getContext().getDrawable(R.drawable.tick_icon));
                    mWodCompletedButton.setBackgroundTintList(getContext().getColorStateList(R.color.red_theme));
                } else {
                    mWodCompletedText.setText("Wod Not Completed");
                    mWodCompletedButton.setImageDrawable(getContext().getDrawable(R.drawable.x_icon));
                    mWodCompletedButton.setBackgroundTintList(getContext().getColorStateList(R.color.orange_theme));
                }
            }
        });

        mScaledButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mRxButton.setBackground(getContext().getDrawable(R.drawable.circular_red_border));
                mScaledButton.setBackground(getContext().getDrawable(R.drawable.circular_orange_filled));
            }
        });

        mRxButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mRxButton.setBackground(getContext().getDrawable(R.drawable.circular_red_filled));
                mScaledButton.setBackground(getContext().getDrawable(R.drawable.circular_orange_border));
            }
        });

        mAddRoundButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCompleteExercisesAdapter.addNewRound();
            }
        });

    }

    public void setTypeWod(String name) {
        if (!name.isEmpty() && name.equals("AMRAP")) {
            setAddRoundButtonVisibility(false);
        } else {
            setAddRoundButtonVisibility(true);
        }
        mTypeWod.setText(name);
    }

    private void changeScaledButtonView(boolean press) {
        // TODO
    }

    private void changeRXButtonView(boolean press) {
        // TODO
    }

    public void setAddRoundButtonVisibility(boolean isVisible) {
        mAddRoundButton.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    public void setOptionsButtonListener(OnClickListener onClickListener) {
        mOptionsButton.setOnClickListener(onClickListener);
    }

    public void setOptionsExerciseListener(ItemClickListener itemClickListener) {
        mOptionsExerciseListener = itemClickListener;
    }

    public void setExerciseList(List<String> exerciseList) {
        mCompleteExercisesAdapter = new CompleteExercisesAdapter(exerciseList, new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mOptionsExerciseListener.onItemClick(view, position);
            }
        });
        mExercisesRecycler.setAdapter(mCompleteExercisesAdapter);
        mExercisesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
