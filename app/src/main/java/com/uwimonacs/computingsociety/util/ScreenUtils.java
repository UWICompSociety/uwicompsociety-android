package com.uwimonacs.computingsociety.util;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 * @author sultanofcardio
 */

public class ScreenUtils {

    public static AlertDialog showDialog(Context context, String title, String message, String positive,
                                         String negative, DialogInterface.OnClickListener positiveButton,
                                         DialogInterface.OnClickListener negativeButton){

        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positive, positiveButton)
                .setNegativeButton(negative, negativeButton)
                .show();
    }

    @SuppressWarnings("unchecked")
    public static void makeSharedElementTransition(Context context, Class targetClass,
                                                   Bundle extras, boolean finish, View... views){
        Intent intent = new Intent(context, targetClass);
        if(extras != null)
            intent.putExtras(extras);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Pair<View, String>[] pairs = new Pair[views.length];
            for(int i=0; i< views.length; i++){
                pairs[i] = new Pair(views[i], views[i].getTransitionName());
            }
            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation((AppCompatActivity)context, pairs);
            context.startActivity(intent, options.toBundle());
            if(finish)
                ((AppCompatActivity)context).finish();
        } else {
            context.startActivity(intent);
            if(finish)
                ((AppCompatActivity)context).finish();
        }
    }

    public static void circularReveal(final View revealCenter, final View revealView, final int duration,
                                       final Animator.AnimatorListener listener){
        revealView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                revealView.removeOnLayoutChangeListener(this);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

                    int cx = (int) revealCenter.getX() + (revealCenter.getWidth()/2);
                    int cy = (int) revealCenter.getY() + (revealCenter.getHeight()/2);

                    float finalRadius = (float) Math.max(revealView.getWidth(),
                            revealView.getHeight());

                    Animator anim = ViewAnimationUtils
                            .createCircularReveal(revealView, cx, cy, 0, finalRadius)
                            .setDuration(duration);
                    anim.addListener(listener);
                    anim.start();
                }
            }
        });
    }
}
