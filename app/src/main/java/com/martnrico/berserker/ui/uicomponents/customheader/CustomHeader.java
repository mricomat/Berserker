package com.martnrico.berserker.ui.uicomponents.customheader;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.martnrico.berserker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 27/11/2018.
 */
public class CustomHeader extends LinearLayout implements CustomHeaderBehavior{

    @BindView(R.id.icon_center)
    ImageView mIconCenter;

    @BindView(R.id.icon_left)
    ImageView mIconLeft;

    @BindView(R.id.icon_right)
    ImageView mIconRight;

    @BindView(R.id.icon_top_left)
    ImageView mIconTopLeft;

    @BindView(R.id.icon_top_right)
    ImageView mIconTopRight;

    @BindView(R.id.text_left)
    TextView mTextLeft;

    @BindView(R.id.text_right)
    TextView mTextRight;

    public CustomHeader(Context context) {
        super(context);
        init(context);
    }

    public CustomHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.custom_header, this);
        ButterKnife.bind(this);
    }

    @Override
    public void setIconLeftText(String iconText) {
        mTextLeft.setText(iconText);
    }

    @Override
    public void setIconRightText(String iconText) {
        mTextRight.setText(iconText);
    }

    @Override
    public void setIconLeft(int resId) {
        mIconLeft.setImageResource(resId);
    }

    @Override
    public void setIconRight(int resId) {
        mIconRight.setImageResource(resId);
    }

    @Override
    public void setIconLeftTop(int resId) {
        mIconTopLeft.setImageResource(resId);
    }

    @Override
    public void setIconRightTop(int resId) {
        mIconTopRight.setImageResource(resId);
    }

    @Override
    public void setIconCenter(int resId) {
        mIconCenter.setImageResource(resId);
    }

    @Override
    public void setIconLeftListener(OnClickListener listener) {
        mIconLeft.setOnClickListener(listener);
    }

    @Override
    public void setIconRightListener(OnClickListener listener) {
        mIconRight.setOnClickListener(listener);
    }

    @Override
    public void setIconTopLeftListener(OnClickListener listener) {
        mIconTopLeft.setOnClickListener(listener);
    }

    @Override
    public void setIconTopRightListener(OnClickListener listener) {
        mIconTopRight.setOnClickListener(listener);
    }

    @Override
    public void setIconCenterListener(OnClickListener listener) {
        mIconCenter.setOnClickListener(listener);
    }
}
