package com.uwimonacs.computingsociety.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
                                                   Bundle extras, View... views){
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
        } else
            context.startActivity(intent);
    }
}
