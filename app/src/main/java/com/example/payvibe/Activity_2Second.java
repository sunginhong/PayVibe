package com.example.payvibe;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.HapticFeedbackConstants;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.airbnb.lottie.LottieAnimationView;

public class Activity_2Second extends Activity {

    TextView countView;
    CountDownTimer timer;
    private static final int cnt = 50;
    int count = cnt;
    int cntF = cnt;
    private static final int MILLISINFUTURE = cnt*1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;
    LottieAnimationView lottieview;
    Vibrator vibrator;
    VibrationEffect vibrationEffect;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_pager);

        countView = (TextView) findViewById(R.id.countView);
        lottieview = findViewById(R.id.lottieview);
        lottieview.setAnimation("wav_nor2sec.json");
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        vibrationEffect = VibrationEffect.createPredefined(VibrationEffect.EFFECT_HEAVY_CLICK);
        lottieview.playAnimation();

        timer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (cntF >= 0){
                    cntF = count--;
                    vibrator.vibrate(vibrationEffect);
                }
                if (cntF >= 10){
                    countView.setText("00:"+String.valueOf(cntF));
                } else {
                    countView.setText("00:0"+String.valueOf(cntF));
                }
            }

            @Override
            public void onFinish() {
                timer.cancel();
                timer.start();
                count = cnt;
                cntF = cnt;
                vibrator.cancel();
            }
        };

        timer.start();
    }

    @Override
    public void onBackPressed() {
        finish();
        timer.cancel();
        vibrator.cancel();
    }

    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
        vibrator.cancel();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        timer.start();
        vibrator.vibrate(vibrationEffect);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
        vibrator.cancel();
    }

}