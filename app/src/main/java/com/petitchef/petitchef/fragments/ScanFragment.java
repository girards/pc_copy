package com.petitchef.petitchef.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.BarcodeView;
import com.petitchef.petitchef.App;
import com.petitchef.petitchef.R;
import com.petitchef.petitchef.utils.Constants;

import java.util.List;

/**
 * Created by Nicolas Girardot on 17/09/2016 for petitchef-android
 */
public class ScanFragment extends Fragment {

    private static final String TAG = "ScanFragment";
    ImageView laserLoader;
    BarcodeView barcodeView;
    TranslateAnimation mAnimation;
    Tracker mTracker;

    public static ScanFragment newInstance() {
        ScanFragment fragment = new ScanFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mTracker = App.getInstance().getDefaultTracker();
        View view = inflater.inflate(R.layout.fragment_scan, container, false);

        laserLoader = (ImageView) view.findViewById(R.id.laser_loader);
        mAnimation = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.1f);
        mAnimation.setDuration(500);
        mAnimation.setRepeatCount(-1);
        mAnimation.setRepeatMode(Animation.REVERSE);
        mAnimation.setInterpolator(new LinearInterpolator());
        laserLoader.setAnimation(mAnimation);
        //TODO: Check for permission before displaying camera, if no permission display splash screen
        isCameraPermissionGranted();
        barcodeView = (BarcodeView) view.findViewById(R.id.barcode_scanner);
        return view;
    }

    private boolean isCameraPermissionGranted() {
        Log.d(TAG, String.valueOf(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) + " Value = " + PackageManager.PERMISSION_GRANTED));
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Passing in IF isCameraPerssionGranted");
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CAMERA},
                    Constants.MY_PERMISSIONS_REQUEST_CAMERA);
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Constants.MY_PERMISSIONS_REQUEST_CAMERA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    barcodeView.decodeSingle(new BarcodeCallback() {
                        @Override
                        public void barcodeResult(BarcodeResult result) {
                            Toast.makeText(getContext(), result.getText(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void possibleResultPoints(List<ResultPoint> resultPoints) {

                        }
                    });
                } else {
                    isCameraPermissionGranted();
                }
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        barcodeView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "Setting screen name: " +  TAG);
        mTracker.setScreenName("Image~" + TAG);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        barcodeView.resume();
    }
}
