package com.example.payvibe;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

public class Activity_Payments_NPay_Pos extends Activity {

    private Activity mActivity;
    private boolean start = false;
    FrameLayout lottieview_payments_group;
    FrameLayout payment_card_fl;
    LottieAnimationView lottieview_payments;

    Vibrator vibrator;
    VibrationEffect vibrationEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_payment_npay2);
        mActivity = this;

        LinearLayout conainll = (LinearLayout) findViewById(R.id.conainll);
        Button btn_play = (Button) findViewById(R.id.btn_play);
        FrameLayout paycard_parents_fl = (FrameLayout) findViewById(R.id.paycard_parents_fl);
        FrameLayout paycard_parents_origin = (FrameLayout) findViewById(R.id.paycard_parents_origin);
        FrameLayout paycard_parents_origin_card = (FrameLayout) findViewById(R.id.paycard_parents_origin_card);
//        ImageView paycard_parents_min = (ImageView) findViewById(R.id.paycard_parents_min);
        ImageView panel_npay_qr = (ImageView) findViewById(R.id.panel_npay_qr);
        ImageView payments_title = (ImageView) findViewById(R.id.payments_title);
        LottieAnimationView lottieview_payments = (LottieAnimationView) findViewById(R.id.lottieview_payments);
        ImageView payment_card_bundle_title = (ImageView) findViewById(R.id.payment_card_bundle_title);

        Utils_Anim.TransAlphaAnim(payments_title, 0, 0, 52, 52, 0, 0, 0);

        btn_play.bringToFront();
        lottieview_payments.setAnimation("payment-npay.json");
        float scaleN2 = 0.37f;
        float scaleN = 2.35f;

        Utils_Anim.AlphaAnim(lottieview_payments, 0, 0, 0);

//        Utils_Anim.SclaeAnimCusEase(payment_card_fl, scaleN, scaleN, scaleN, scaleN, 0.5f, 0.5f, 0, Utils_Anim.interpolator_easeOut );
//        Utils_Anim.SclaeAnimCusEase(paycard_parents_origin, 1, 1, 1, 1, 0.5f, 0.5f, 0, Utils_Anim.interpolator_easeOut );

        Runnable runnable = new Runnable() {
            public void run() {
                Utils_Anim.AlphaAnim(lottieview_payments, 0, 1, 0);
            }
        };

        Handler setTimeOut = new android.os.Handler();

        Runnable runnable2 = new Runnable() {
            public void run() {
                Utils_Anim.AlphaAnim(paycard_parents_origin_card, 1, 0, 0);
//                lottieview_payments.playAnimation();
//
            }
        };

        Handler setTimeOut2 = new android.os.Handler();

        Runnable runnable3 = new Runnable() {
            public void run() {
                lottieview_payments.playAnimation();
                Utils_Anim.TransAlphaAnim(payments_title, 0, 0, 52, 0, 0, 1, 400);
            }
        };

        Handler setTimeOut3 = new android.os.Handler();

        Runnable runnable4 = new Runnable() {
            public void run() {

            }
        };

        Handler setTimeOut4 = new android.os.Handler();

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!start){
                    start = true;
                    Utils_Anim.function_containYAnim(paycard_parents_fl, 0, -(421-85), 300, Utils_Anim.interpolator_easeOut);
//                    Utils_Anim.SclaeAnimCusEase(payment_card_fl, scaleN, 1, scaleN, 1, 0.5f, 0.5f, 400, Utils_Anim.interpolator_easeOut );
                    Utils_Anim.SclaeAnimCusEase(paycard_parents_origin, 1, scaleN2, 1, scaleN2, 0.5f, 0.5f, 300, Utils_Anim.interpolator_easeOut );
                    Utils_Anim.AlphaAnim(panel_npay_qr, 1, 0, 100);
                    Utils_Anim.AlphaAnim(payment_card_bundle_title, 1, 0, 300);
                    setTimeOut.postDelayed(runnable, 200);
                    setTimeOut2.postDelayed(runnable2, 300);
                    setTimeOut3.postDelayed(runnable3, 300);
                } else {
                    if (Build.VERSION.SDK_INT >= 11) {
                        mActivity.recreate();
                    } else {
                        mActivity.finish();
                        mActivity.startActivity(mActivity.getIntent());
                    }
                    lottieview_payments.setFrame(0);
                    lottieview_payments.pauseAnimation();
                }
            }
        });
    }

}