package com.martnrico.berserker.ui.login;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.martnrico.berserker.R;
import com.martnrico.berserker.data.network.model.HomeDataModel;
import com.martnrico.berserker.ui.base.BaseActivity;
import com.martnrico.berserker.ui.home.HomeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import io.rmiri.buttonloading.ButtonLoading;

/**
 * Created by Martín Rico Martínez on 19/11/2018.
 */
public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.email_ed)
    EditText mInputEmail;

    @BindView(R.id.password_ed)
    EditText mInputPassword;

    @BindView(R.id.sign_in_button)
    ButtonLoading mSignInButton;

    @BindView(R.id.forgot_text)
    TextView mForgotText;

    @Inject
    LoginPresenter<LoginView> mPresenter;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected int layoutRes() {
        return R.layout.login_activity;
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
        setListeners();
    }

    @Override
    protected void setListeners() {
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInputEmail.clearFocus();
                mInputPassword.clearFocus();
                mPresenter.onSignInClick(mInputEmail.getText().toString(),
                        mInputPassword.getText().toString());
            }
        });

        mForgotText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onForgotPassClick();
            }
        });
    }

    @Override
    public void showFadeIn() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        mInputEmail.startAnimation(animation);
        mInputPassword.startAnimation(animation);
        mSignInButton.startAnimation(animation);
        mForgotText.startAnimation(animation);
    }

    @Override
    public void showLoading() {
        mSignInButton.setProgress(true);
    }

    @Override
    public void hideLoading() {
        mSignInButton.setProgress(false);
    }

    @Override
    public void showForgotPassDialog() {
        new AlertDialog.Builder(LoginActivity.this)
                .setTitle("Forgot Password")
                .setMessage("We have sent an Email to recover your password")
                // A null listener allows the button to dismiss the dialog and take no further action.
                .setPositiveButton(android.R.string.no, null)
                .show();
    }

    @Override
    public void showEmailInputError(int error) {
        mInputEmail.setError(getString(error));
    }

    @Override
    public void showPasswordInputError(int error) {
        mInputPassword.setError(getString(error));
    }

    @Override
    public void navigateToHomeActivity(HomeDataModel homeData) {
        Intent intent = HomeActivity.getStartIntent(LoginActivity.this, homeData);
        startActivity(intent);
        finish();
    }
}
