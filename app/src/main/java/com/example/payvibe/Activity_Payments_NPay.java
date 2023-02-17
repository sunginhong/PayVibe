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

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

public class Activity_Payments_NPay extends Activity {

    private Activity mActivity;
    private boolean start = false;
    FrameLayout pannel_ui_contain;
    LottieAnimationView lottieview_end;
    Vibrator vibrator;
    VibrationEffect vibrationEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_payment_npay);
        mActivity = this;

        LinearLayout conainll = (LinearLayout) findViewById(R.id.conainll);
        ImageView panel_spaysample_title = (ImageView) findViewById(R.id.pannel_ui_sample);
        Button btn_play = (Button) findViewById(R.id.btn_play);
//        pannel_ui_contain = (FrameLayout) findViewById(R.id.pannel_ui_contain);
        ImageView pannel_ui = (ImageView) findViewById(R.id.pannel_ui);
        lottieview_end = (LottieAnimationView) findViewById(R.id.lottieview_payments_f);
        lottieview_end.setAnimation("payment-npay_fade.json");
        FrameLayout pannel_ui_sample_group = (FrameLayout) findViewById(R.id.pannel_ui_sample_group);

        Utils_Anim.AlphaAnim(lottieview_end, 0, 0, 0);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        vibrationEffect = VibrationEffect.createPredefined(VibrationEffect.EFFECT_HEAVY_CLICK);


        Glide.with(this)
                .load(R.drawable.qr_view_f)
                .into(pannel_ui);

        Glide.with(this)
                .load(R.drawable.panel_spaysample_title)
                .into(panel_spaysample_title);

        Utils_Anim.TransAlphaAnim(pannel_ui_sample_group, 0, 0, 104/2, 104/2, 0, 0, 0);

        Runnable runnable = new Runnable() {
            public void run() {
                Utils_Anim.AlphaAnim(lottieview_end, 0, 1, 0);
                lottieview_end.playAnimation();
//                Utils_Anim.TransAlphaAnim(pannel_ui_contain, 0, 0, 52, 0, 0, 1, 400);
            }
        };

        Handler setTimeOut = new android.os.Handler();

        Runnable runnable2 = new Runnable() {
            public void run() {
                Utils_Anim.TransAlphaAnim(pannel_ui_sample_group, 0, 0, 104/2, 0, 0, 1, 300);
            }
        };

        Handler setTimeOut2 = new android.os.Handler();



        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!start){
                    start = true;
//                    vibrator.vibrate(vibrationEffect);
                    conainll.performHapticFeedback(HapticFeedbackConstants.CONFIRM);
                    Utils_Anim.AlphaAnim(pannel_ui, 1, 0, 100);
                    setTimeOut.postDelayed(runnable, 100);
                    setTimeOut2.postDelayed(runnable2, 200);
                } else {
                    if (Build.VERSION.SDK_INT >= 11) {
                        mActivity.recreate();
                    } else {
                        mActivity.finish();
                        mActivity.startActivity(mActivity.getIntent());
                    }
                    lottieview_end.setFrame(0);
                    lottieview_end.pauseAnimation();
                }
            }
        });
    }

}