package com.integraloftan.justin.puzzlegame;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Justin on 3/13/2015.
 */
public class SharedPrefs {
    public class SharedKeys {
        final static String count = "count";
        final static String five = "five";
        final static String six = "six";
        final static String seven = "seven";
        final static String eight = "eight";
        final static String nine = "nine";
        final static String easy = "easy";
        final static String medium = "medium";
        final static String hard = "hard";
        final static String first = "first";
    }

    public void storeInt(Context context, String key, int data) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, data);
        editor.commit();
    }

    public int getInt(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(key, 0);
    }

    public void storeBoolean(Context context, String key, boolean data) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, data);
        editor.commit();
    }

    public boolean getBoolean(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(key, false);
    }
}
