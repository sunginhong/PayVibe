package com.example.payvibe;

import android.animation.Animator;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class Activity_Sel extends AppCompatActivity {

    TextView countView;
    CountDownTimer timer;
    private static final int cnt = 50;
    int count = cnt;
    int cntF = cnt;
    boolean start = false;
    boolean pause = false;
    private static final int MILLISINFUTURE = cnt*1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;
    Button btn_play;
    Button btn_reset;
    LottieAnimationView lottieview_once;
    LottieAnimationView lottieview_loop;
    Vibrator vibrator;
    VibrationEffect vibrationEffect;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_pager_cus);

        countView = (TextView) findViewById(R.id.countView);
        lottieview_once = findViewById(R.id.lottieview_once);
        lottieview_once.setAnimation("pay_anim_0once.json");
        lottieview_loop = findViewById(R.id.lottieview_loop);
        lottieview_loop.setAnimation("pay_anim_1loop.json");

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        vibrationEffect = VibrationEffect.createPredefined(VibrationEffect.EFFECT_HEAVY_CLICK);

        lottieview_loop.setVisibility(View.GONE);

        btn_play = (Button) findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!start){
                    start = true;
                    lottieview_once.playAnimation();
                    timer.start();
                    btn_play.setVisibility(View.GONE);
                    btn_reset.setVisibility(View.VISIBLE);
                }
            }
        });

        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_reset.setVisibility(View.INVISIBLE);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieview_once.setVisibility(View.VISIBLE);
                lottieview_once.playAnimation();
                lottieview_once.setFrame(0);
                lottieview_loop.setVisibility(View.INVISIBLE);
                lottieview_loop.pauseAnimation();
                lottieview_loop.setFrame(0);

                timer.cancel();
                timer.start();
                count = cnt;
                cntF = cnt;
                vibrator.cancel();
            }
        });

        lottieview_once.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                lottieview_once.setVisibility(View.INVISIBLE);
                lottieview_once.pauseAnimation();
                lottieview_once.setFrame(0);
                lottieview_loop.setVisibility(View.VISIBLE);
                lottieview_loop.playAnimation();
                lottieview_loop.setFrame(0);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

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