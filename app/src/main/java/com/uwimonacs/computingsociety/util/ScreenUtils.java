package com.uwimonacs.computingsociety.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

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
}
