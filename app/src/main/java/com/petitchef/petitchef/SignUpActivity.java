package com.petitchef.petitchef;

import android.animation.Animator;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.petitchef.petitchef.network.APIListener;
import com.petitchef.petitchef.network.APIManager;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "SignUpActivity";
    View sliderView;
    TextView switchToSignIn;
    TextView switchToSignUp;

    EditText usernameSignIn;
    EditText passwordSignIn;
    EditText usernameSignUp;
    EditText mailSignUp;
    EditText passwordSignUp;

    Button buttonSignUp;
    Button buttonSignIn;
    Button buttonFacebook;
    Button buttonConfirmSignIn;
    Button buttonConfirmSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login_signup);
        sliderView = findViewById(R.id.slider_layout);

        buttonSignUp = (Button) findViewById(R.id.button_sign_up);
        buttonSignIn = (Button) findViewById(R.id.button_sign_in);
        buttonFacebook = (Button) findViewById(R.id.button_facebook_sign_in);
        buttonConfirmSignIn = (Button) findViewById(R.id.button_confirm_sign_in);
        buttonConfirmSignUp = (Button) findViewById(R.id.button_confirm_sign_up);

        switchToSignIn = (TextView) findViewById(R.id.switch_to_login_text);
        switchToSignIn.setText(Html.fromHtml(getString(R.string.signup_switch_to_signin)));
        switchToSignUp = (TextView) findViewById(R.id.switch_to_signup_text);
        switchToSignUp.setText(Html.fromHtml(getString(R.string.signin_switch_to_signup)));

        switchToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.sign_up_form).setVisibility(View.INVISIBLE);
                findViewById(R.id.sign_in_form).setVisibility(View.VISIBLE);
            }
        });

        switchToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.sign_up_form).setVisibility(View.VISIBLE);
                findViewById(R.id.sign_in_form).setVisibility(View.INVISIBLE);
            }
        });

        usernameSignIn = (EditText) findViewById(R.id.username_sign_in);
        passwordSignIn = (EditText) findViewById(R.id.password_sign_in);
        usernameSignUp = (EditText) findViewById(R.id.username_sign_up);
        mailSignUp = (EditText) findViewById(R.id.mail_address_sign_up);
        passwordSignUp = (EditText) findViewById(R.id.password_sign_up);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources resources = SignUpActivity.this.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                sliderView.animate()
                        .translationY(-0.8f * displayMetrics.heightPixels / 2)
                        .setDuration(600)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                findViewById(R.id.sign_up_form).setVisibility(View.VISIBLE);
                                findViewById(R.id.sign_in_form).setVisibility(View.INVISIBLE);
                                buttonSignIn.animate().alpha(0.0f)
                                        .setDuration(300);
                                buttonSignIn.setEnabled(false);
                                buttonSignUp.animate().alpha(0.0f)
                                        .setDuration(300);
                                buttonSignUp.setEnabled(false);
                                buttonFacebook.animate().alpha(0.0f)
                                        .setDuration(300);
                                buttonFacebook.setEnabled(false);
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources resources = SignUpActivity.this.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                sliderView.animate()
                        .translationY(-0.8f * displayMetrics.heightPixels / 2)
                        .setDuration(600)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                findViewById(R.id.sign_up_form).setVisibility(View.INVISIBLE);
                                findViewById(R.id.sign_in_form).setVisibility(View.VISIBLE);
                                buttonSignIn.animate().alpha(0.0f)
                                        .setDuration(300);
                                buttonSignIn.setEnabled(false);
                                buttonSignUp.animate().alpha(0.0f)
                                        .setDuration(300);
                                buttonSignUp.setEnabled(false);
                                buttonFacebook.animate().alpha(0.0f)
                                        .setDuration(300);
                                buttonFacebook.setEnabled(false);
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
            }
        });

        buttonConfirmSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(usernameSignIn.getText()) || TextUtils.isEmpty(passwordSignIn.getText()))
                    Toast.makeText(SignUpActivity.this, getResources().getString(R.string.error_field_empty), Toast.LENGTH_SHORT).show();
                String username = usernameSignIn.getText().toString();
                String password = passwordSignIn.getText().toString();
                APIManager.getInstance().login(username, password, new APIListener<Boolean>() {
                    @Override
                    public void onResult(Boolean object) {
                        Log.d(TAG, "Result  = " + object);
                    }
                });
            }
        });

        buttonConfirmSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(usernameSignUp.getText()) || TextUtils.isEmpty(passwordSignUp.getText()) || TextUtils.isEmpty(mailSignUp.getText()))
                    Toast.makeText(SignUpActivity.this, getResources().getString(R.string.error_field_empty), Toast.LENGTH_SHORT).show();
                String username = usernameSignUp.getText().toString();
                String password = passwordSignUp.getText().toString();
                String mail = mailSignUp.getText().toString();
                APIManager.getInstance().register(username, password, mail, new APIListener<Boolean>() {
                    @Override
                    public void onResult(Boolean object) {
                        Log.d(TAG, "Result  = " + object);
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        usernameSignIn.setText("");
        usernameSignIn.clearFocus();
        passwordSignIn.setText("");
        passwordSignIn.clearFocus();
        usernameSignUp.setText("");
        usernameSignUp.clearFocus();
        mailSignUp.setText("");
        mailSignUp.clearFocus();
        passwordSignUp.setText("");
        passwordSignUp.clearFocus();
        sliderView.animate()
                .translationY(0)
                .setDuration(600)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        buttonSignIn.animate().alpha(1.0f)
                                .setDuration(300);
                        buttonSignIn.setEnabled(true);
                        buttonSignUp.animate().alpha(1.0f)
                                .setDuration(300);
                        buttonSignUp.setEnabled(true);
                        buttonFacebook.animate().alpha(1.0f)
                                .setDuration(300);
                        buttonFacebook.setEnabled(true);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }
}
