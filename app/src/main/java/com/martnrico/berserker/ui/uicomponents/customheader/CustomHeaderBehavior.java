package com.martnrico.berserker.ui.uicomponents.customheader;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by Martín Rico Martínez on 27/11/2018.
 */
public interface CustomHeaderBehavior {

    void setIconLeftText(String iconText);

    void setIconRightText(String iconText);

    void setIconLeft(int resId);

    void setIconRight(int resId);

    void setIconLeftTop(int resId);

    void setIconRightTop(int resId);

    void setIconCenter(int resId);

    void setIconLeftListener(View.OnClickListener listener);

    void setIconRightListener(View.OnClickListener listener);

    void setIconTopLeftListener(View.OnClickListener listener);

    void setIconTopRightListener(View.OnClickListener listener);

    void setIconCenterListener(View.OnClickListener listener);

}
