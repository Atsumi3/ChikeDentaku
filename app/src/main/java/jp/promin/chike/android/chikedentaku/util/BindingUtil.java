package jp.promin.chike.android.chikedentaku.util;

import android.databinding.BindingAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public final class BindingUtil {
    @BindingAdapter({"calcValue"})
    public static void setCalcValue(final TextView textView, final long value) {
        ViewCompat.animate(textView)
                .alpha(0f)
                .rotationBy(360f)
                .rotation(0f)
                .setDuration(100)
                .scaleXBy(1f)
                .scaleX(2f)
                .scaleYBy(1f)
                .scaleY(2f)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {

                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        ViewCompat.animate(textView)
                                .alpha(1f)
                                .rotationBy(0f)
                                .rotation(360f)
                                .setDuration(100)
                                .scaleXBy(3f)
                                .scaleX(1f)
                                .scaleYBy(3f)
                                .scaleY(1f)
                                .setInterpolator(new FastOutLinearInInterpolator())
                                .setListener(new ViewPropertyAnimatorListener() {
                                    @Override
                                    public void onAnimationStart(View view) {
                                        textView.setText(String.format(Locale.getDefault(), "%,d", value));
                                    }

                                    @Override
                                    public void onAnimationEnd(View view) {

                                    }

                                    @Override
                                    public void onAnimationCancel(View view) {

                                    }
                                }).start();
                    }

                    @Override
                    public void onAnimationCancel(View view) {

                    }
                }).start();
    }
}
