package com.martnrico.berserker.ui.error;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.DataManager;
import com.martnrico.berserker.ui.base.BaseActivity;
import com.martnrico.berserker.ui.login.LoginActivity;

import java.io.IOException;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;

import butterknife.BindView;
import retrofit2.HttpException;

/**
 * Created by Martín Rico Martínez on 31/01/2019.
 */
public class ErrorActivity extends BaseActivity {

    public static final String ERROR_MODEL_KEY = "error_model_key";

    @BindView(R.id.cancel_button)
    Button mCancelButton;

    @BindView(R.id.error_detail)
    TextView mErrorDetail;

    @BindView(R.id.error_title)
    TextView mErrorTitle;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @Inject
    DataManager mDataManager;

    private Throwable mError;
    private boolean mIsTokenError = false;

    @Override
    protected int layoutRes() {
        return R.layout.error_activity;
    }

    public static Intent getStartIntent(Context context, Throwable error) {
        Intent intent = new Intent(context, ErrorActivity.class);
        Bundle extras = new Bundle();
        extras.putSerializable(ERROR_MODEL_KEY, error);
        intent.putExtras(extras);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillProgressBar();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        assert bundle != null;
        mError = (Throwable) bundle.getSerializable(ERROR_MODEL_KEY);

        fillTextError();
    }

    @Override
    protected void onViewBound() {
        super.onViewBound();
        setListeners();
    }

    private void fillTextError() {
        if (mError == null || mError.getMessage() == null) {
            mErrorTitle.setText(getString(R.string.unknown_error_title));
            mErrorDetail.setText(getString(R.string.unknown_error_detail));
        }

        if (mError.getMessage().equals("timeout")) {
            mErrorTitle.setText(getString(R.string.unknown_error_title));
            mErrorDetail.setText(getString(R.string.unknown_error_detail));
        }

        if (mError instanceof HttpException) {
            switch (((HttpException) mError).code()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                    mDataManager.setUserAsLoggedOut();
                    mCancelButton.setText(getString(R.string.continue_button));
                    mErrorTitle.setText(getString(R.string.token_error_title));
                    mErrorDetail.setText(getString(R.string.token_error_detail));
                    mIsTokenError = true;
                case HttpsURLConnection.HTTP_FORBIDDEN:
                    mDataManager.setUserAsLoggedOut();
                    mCancelButton.setText(getString(R.string.continue_button));
                    mErrorTitle.setText(getString(R.string.token_error_title));
                    mErrorDetail.setText(getString(R.string.token_error_detail));
                    mIsTokenError = true;
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                case HttpsURLConnection.HTTP_NOT_FOUND:
            }
        }

        if (mError instanceof IOException) {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected())) {
                mErrorTitle.setText(getString(R.string.connection_error_title));
                mErrorDetail.setText(getString(R.string.connection_error_detail));
            }
        }
    }

    private void fillProgressBar() {
        ObjectAnimator animation = ObjectAnimator.ofInt(mProgressBar, "progress", 100);
        animation.setDuration(1800);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
    }

    @Override
    protected void setListeners() {
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIsTokenError) {
                    startActivity(LoginActivity.getStartIntent(getApplicationContext()));
                }
                finish();
            }
        });
    }
}
