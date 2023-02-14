package com.example.payvibe;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.core.view.animation.PathInterpolatorCompat;

import com.airbnb.lottie.model.CubicCurveData;

public class Utils_Anim {
    protected Context context;

    public static Interpolator interpolator_easeInOut = PathInterpolatorCompat.create(0.65f, 0f, 0.35f, 1f);
    public static Interpolator interpolator_easeOut = PathInterpolatorCompat.create(0.33f, 1f, 0.68f, 1f);
    public static Interpolator interpolator_easeIn = PathInterpolatorCompat.create(0.32f, 0f, 0.67f, 0f);
    public static Interpolator interpolator_spring = PathInterpolatorCompat.create(0.34f, 1.56f, 0.64f, 1f);
    public static Interpolator interpolator_bounce = PathInterpolatorCompat.create(0.34f, 1.56f, 0.64f, 1f);
    public static Interpolator interpolator_bounce2 = PathInterpolatorCompat.create(0.34f, 1.46f, 0.54f, 1f);

    public Utils_Anim(){
    }

    public static void TransAnim(View view, float startX, float endX, float startY, float endY, int duration) {
        TranslateAnimation anim = new TranslateAnimation(
                startX, endX,
                startY, endY );
        anim.setFillAfter(true);
        anim.setInterpolator(interpolator_easeOut);
        anim.setDuration(duration);
        view.startAnimation(anim);
    }


    public static void bgColorAnim(View view, Object startColor, Object endColor, int duration ){
        final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(view, "backgroundColor", new ArgbEvaluator(), startColor, endColor);
        backgroundColorAnimator.setDuration(duration);
        backgroundColorAnimator.start();
    }

    public static void drawableAlphaAnim(final View view, float startAlpha, float endAlpha, int duration){
        ValueAnimator anim = ValueAnimator.ofFloat(startAlpha, endAlpha);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setAlpha((Float) animation.getAnimatedValue());
            }
        });
        anim.setInterpolator(new DecelerateInterpolator((float) 1.5));
        anim.setDuration(duration);
        anim.start();
    }

    public static void SclaeAnim(View view, float startScaleX, float endScaleX, float startScaleY,float endScaleY, float originX, float originY, int duration) {
        ScaleAnimation anim = new ScaleAnimation( startScaleX, endScaleX, startScaleY, endScaleY, Animation.RELATIVE_TO_SELF, originX, Animation.RELATIVE_TO_SELF, originY  );
        anim.setFillAfter(true);
        anim.setInterpolator(new DecelerateInterpolator((float) 1.5));
        anim.setDuration(duration);
        view.startAnimation(anim);
    }

    public static void SclaeTransAnim(View view, float startX, float endX, float startY, float endY, float startScaleX, float endScaleX, float startScaleY,float endScaleY, float originX, float originY, int duration) {
        TranslateAnimation anim1 = new TranslateAnimation(startX, endX, startY, endY );
        ScaleAnimation anim2 = new ScaleAnimation( startScaleX, endScaleX, startScaleY, endScaleY, Animation.RELATIVE_TO_SELF, originX, Animation.RELATIVE_TO_SELF, originY  );

        AnimationSet setAnim = new AnimationSet(true);
        setAnim.setFillAfter(true);
        setAnim.setInterpolator(new DecelerateInterpolator((float) 1.5));
        setAnim.setDuration(duration);
        setAnim.addAnimation(anim1);
        setAnim.addAnimation(anim2);
        view.startAnimation(setAnim);
    }

    public static void SclaeAlphaAnim(View view, float startScaleX, float endScaleX, float startScaleY,float endScaleY, float originX, float originY, float startAlpha, float endAlpha, int duration) {
        ScaleAnimation anim1 = new ScaleAnimation( startScaleX, endScaleX, startScaleY, endScaleY, Animation.RELATIVE_TO_SELF, originX, Animation.RELATIVE_TO_SELF, originY  );
        Animation anim2 = new AlphaAnimation( startAlpha, endAlpha );

        AnimationSet setAnim = new AnimationSet(true);
        setAnim.setFillAfter(true);
        setAnim.setInterpolator(new DecelerateInterpolator((float) 1.5));
        setAnim.setDuration(duration);
        setAnim.addAnimation(anim1);
        setAnim.addAnimation(anim2);
        view.startAnimation(setAnim);
    }

    public static void SclaeTransAlphaAnim(View view, float startX, float endX, float startY, float endY, float startScaleX, float endScaleX, float startScaleY,float endScaleY, float originX, float originY, float startAlpha, float endAlpha, int duration) {
        TranslateAnimation anim1 = new TranslateAnimation(startX, endX, startY, endY );
        ScaleAnimation anim2 = new ScaleAnimation( startScaleX, endScaleX, startScaleY, endScaleY, Animation.RELATIVE_TO_SELF, originX, Animation.RELATIVE_TO_SELF, originY  );
        Animation anim3 = new AlphaAnimation( startAlpha, endAlpha );

        AnimationSet setAnim = new AnimationSet(true);
        setAnim.setFillAfter(true);
        setAnim.setInterpolator(interpolator_easeOut);
        setAnim.setDuration(duration);
        setAnim.addAnimation(anim1);
        setAnim.addAnimation(anim2);
        setAnim.addAnimation(anim3);
        view.startAnimation(setAnim);
    }

    public static void TransAlphaAnim(View view, float startX, float endX, float startY, float endY, float startAlpha, float endAlpha, int duration) {
        TranslateAnimation anim1 = new TranslateAnimation(
                startX, endX,
                startY, endY );
        Animation anim2 = new AlphaAnimation( startAlpha, endAlpha );

        AnimationSet setAnim = new AnimationSet(true);
        setAnim.setFillAfter(true);
        setAnim.setInterpolator(interpolator_easeOut);
        setAnim.setDuration(duration);
        setAnim.addAnimation(anim1);
        setAnim.addAnimation(anim2);
        view.startAnimation(setAnim);
    }

    public static void AlphaAnim(View view, float startAlpha, float endAlpha, int duration) {
        Animation anim = new AlphaAnimation( startAlpha, endAlpha );
        anim.setFillAfter(true);
        anim.setInterpolator(new DecelerateInterpolator((float) 1.5));
        anim.setDuration(duration);
        view.startAnimation(anim);
    }

    public static void RotateAnim(View view, float startRotate, float endRotate, float originX, float originY, int duration) {
        RotateAnimation anim = new RotateAnimation(startRotate, endRotate, Animation.RELATIVE_TO_SELF, originX, Animation.RELATIVE_TO_SELF, originY);
        anim.setFillAfter(true);
        anim.setInterpolator(new DecelerateInterpolator((float) 1.5));
        anim.setDuration(duration);
        view.startAnimation(anim);
        view.setRotation(endRotate);
    }

    public static void ModulatetTransXAnim(View view, float value, float rangeA, float rangeB, float rangeC, float rangeD){
        float fromHigh = 0;
        float fromLow = 0;
        float toHigh = 0;
        float toLow = 0;
        float result = 0;
        Double resultF = 0.0;

        fromLow = rangeA;
        fromHigh = rangeB;
        toLow = rangeC;
        toHigh = rangeD;

        result = toLow + (((value - fromLow) / (fromHigh - fromLow)) * (toHigh - toLow));
        view.setTranslationX(result);
    }

    public static void ModulatetTransYAnim(View view, float value, float rangeA, float rangeB, float rangeC, float rangeD){
        float fromHigh = 0;
        float fromLow = 0;
        float toHigh = 0;
        float toLow = 0;
        float result = 0;
        Double resultF = 0.0;

        fromLow = rangeA;
        fromHigh = rangeB;
        toLow = rangeC;
        toHigh = rangeD;

        result = toLow + (((value - fromLow) / (fromHigh - fromLow)) * (toHigh - toLow));
        view.setTranslationY(result);
    }

    public static void AlphaAnimCusEase(View view, float startAlpha, float endAlpha, int duration, Interpolator interpolator) {
        Animation anim = new AlphaAnimation( startAlpha, endAlpha );
        anim.setFillAfter(true);
        anim.setInterpolator(interpolator);
        anim.setDuration(duration);
        view.startAnimation(anim);
    }

    public static void SclaeAnimCusEase(View view, float startScaleX, float endScaleX, float startScaleY,float endScaleY, float originX, float originY, int duration, Interpolator interpolator) {
        ScaleAnimation anim = new ScaleAnimation( startScaleX, endScaleX, startScaleY, endScaleY, Animation.RELATIVE_TO_SELF, originX, Animation.RELATIVE_TO_SELF, originY  );
        anim.setFillAfter(true);
        anim.setInterpolator(interpolator);
        anim.setDuration(duration);
        view.startAnimation(anim);
    }

    public static void function_containAnim_transX(View view, float n, int duration, Interpolator interpolator){
        ObjectAnimator containAnim = ObjectAnimator.ofFloat(view, "translationX", n);
        containAnim.setInterpolator(interpolator);
        containAnim.setDuration(duration);
        containAnim.start();
    }

    public static void function_containAnim_transY(View view, float n, int duration, Interpolator interpolator){
        ObjectAnimator containAnim = ObjectAnimator.ofFloat(view, "translationY", n);
        containAnim.setInterpolator(interpolator);
        containAnim.setDuration(duration);
        containAnim.start();
    }


    public static void function_scaleAnim(View view, float n){
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view, "scaleX", n);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "scaleY", n);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.setDuration(0);

        animatorSet.start();
    }

    public static void function_scaleAnimDuration(View view, float n, int dutation){
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view, "scaleX", n);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "scaleY", n);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.setDuration(dutation);

        animatorSet.start();
    }

    public static void function_scaleAlphaAnim(View view, float n, float o1, float o2, int duration, Interpolator interpolator){
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view, "scaleX", n);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "scaleY", n);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(view, "alpha", o1, o2);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2, objectAnimator3);
        animatorSet.setInterpolator(interpolator);
        animatorSet.setDuration(duration);
        animatorSet.start();
    }

    public static void function_scaleAnim_duration(View view, float n, int duration, Interpolator interpolator){
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view, "scaleX", n);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "scaleY", n);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.setInterpolator(interpolator);
        animatorSet.setDuration(duration);

        animatorSet.start();
    }

    public static void function_containXYAnim(View view, float x, float y){

        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view, "translationX", x);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "translationY", y);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.setDuration(0);

        animatorSet.start();
    }

    public static void function_containYAnim(View view, float x, float y, int duration, Interpolator interpolator){

        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view, "translationX", x);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "translationY", y);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.setDuration(duration);
        animatorSet.setInterpolator(interpolator);
        animatorSet.start();
    }

    public static void function_WidthAnim(View view, float n, int duration, Interpolator interpolator) {
        final int currentWidth = view.getWidth();
        ObjectAnimator animator = ObjectAnimator.ofInt(view, new WidthProperty(), currentWidth, (int) n);
        animator.setDuration(duration);
        animator.setInterpolator(interpolator);
        animator.start();
    }

    public static void function_HeightAnim(View view, float n, int duration, Interpolator interpolator) {
        final int currentHeight = view.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofInt(view, new HeightProperty(), currentHeight, (int) n);
        animator.setDuration(duration);
        animator.setInterpolator(interpolator);
        animator.start();
    }

    static class WidthProperty extends Property<View, Integer> {
        public WidthProperty() {
            super(Integer.class, "width");
        }
        @Override public Integer get(View view) {
            return view.getWidth();
        }
        @Override public void set(View view, Integer value) {
            view.getLayoutParams().width = value;
            view.setLayoutParams(view.getLayoutParams());
        }
    }

    static class HeightProperty extends Property<View, Integer> {
        public HeightProperty() {
            super(Integer.class, "height");
        }
        @Override public Integer get(View view) {
            return view.getHeight();
        }
        @Override public void set(View view, Integer value) {
            view.getLayoutParams().width = value;
            view.setLayoutParams(view.getLayoutParams());
        }
    }


}