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

public class Activity_Payments_SPay extends Activity {

    private Activity mActivity;
    private boolean start = false;
    FrameLayout lottieview_payments_group;
    LottieAnimationView pay_anim_1loop;
    LottieAnimationView lottieview_payments;
    Vibrator vibrator;
    VibrationEffect vibrationEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_payment_spay);
        mActivity = this;

        LinearLayout conainll = (LinearLayout) findViewById(R.id.conainll);
        Button btn_play = (Button) findViewById(R.id.btn_play);
        ImageView pannel_ui = (ImageView) findViewById(R.id.pannel_ui);
        ImageView panel_spaysample_title = (ImageView) findViewById(R.id.pannel_ui_sample);
        TextView countView = (TextView) findViewById(R.id.countView);
        lottieview_payments_group = (FrameLayout) findViewById(R.id.lottieview_payments_group);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        vibrationEffect = VibrationEffect.createPredefined(VibrationEffect.EFFECT_HEAVY_CLICK);

        Glide.with(this)
                .load(R.drawable.panel_spay)
                .into(pannel_ui);

        Glide.with(this)
                .load(R.drawable.panel_spaysample_title)
                .into(panel_spaysample_title);

        pay_anim_1loop = findViewById(R.id.lottieview_loop);
        pay_anim_1loop.setAnimation("pay_anim_1loop.json");
        pay_anim_1loop.playAnimation();

        lottieview_payments = findViewById(R.id.lottieview_payments);
        lottieview_payments.setAnimation("payment-spay.json");
        lottieview_payments_group.bringToFront();
        Utils_Anim.AlphaAnim(lottieview_payments, 0, 0, 0);

        Utils_Anim.AlphaAnim(panel_spaysample_title, 0, 0, 0);

        Runnable runnable = new Runnable() {
            public void run() {
                Utils_Anim.TransAlphaAnim(panel_spaysample_title, 0, 0, 52, 0, 0, 1, 300);
            }
        };

        Handler setTimeOut = new android.os.Handler();


        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!start){
                    start = true;
//                    vibrator.vibrate(vibrationEffect);
                    conainll.performHapticFeedback(HapticFeedbackConstants.CONFIRM);
                    pay_anim_1loop.setVisibility(View.GONE);
                    lottieview_payments.playAnimation();
                    Utils_Anim.AlphaAnim(pannel_ui, 1, 0, 200);
                    Utils_Anim.AlphaAnim(countView, 1, 0, 0);
                    Utils_Anim.AlphaAnim(lottieview_payments, 0, 1, 0);
                    Utils_Anim.TransAnim(lottieview_payments_group, 0, 0, 0, 150, 300);
                    setTimeOut.postDelayed(runnable, 300);

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
