package com.integraloftan.justin.puzzlegame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SixBySix extends Fragment implements View.OnClickListener {

    ImageView p, l, a, y, firstDigit, secondDigit, thirdDigit, d1, d2, d3;
    private SharedPrefs prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sixbysix_fragment, container, false);
        p = (ImageView) view.findViewById(R.id.p);
        l = (ImageView) view.findViewById(R.id.l);
        a = (ImageView) view.findViewById(R.id.a);
        y = (ImageView) view.findViewById(R.id.y);
        firstDigit = (ImageView) view.findViewById(R.id.firstDigit);
        secondDigit = (ImageView) view.findViewById(R.id.secondDigit);
        thirdDigit = (ImageView) view.findViewById(R.id.thirdDigit);
        d1 = (ImageView) view.findViewById(R.id.d1);
        d2 = (ImageView) view.findViewById(R.id.d2);
        d3 = (ImageView) view.findViewById(R.id.d3);
        p.setOnClickListener(this);
        l.setOnClickListener(this);
        a.setOnClickListener(this);
        y.setOnClickListener(this);
        prefs = new SharedPrefs();
        int intLevels = prefs.getInt(getActivity().getApplicationContext(), SharedPrefs.SharedKeys.six);
        String levels = "" + intLevels;
        if (levels.length() == 1) {
            thirdDigit.setImageResource(convert(levels.charAt(0)));
        } else if (levels.length() == 2) {
            secondDigit.setImageResource(convert(levels.charAt(0)));
            thirdDigit.setImageResource(convert(levels.charAt(1)));
        } else if (levels.length() == 3) {
            firstDigit.setImageResource(convert(levels.charAt(0)));
            secondDigit.setImageResource(convert(levels.charAt(1)));
            thirdDigit.setImageResource(convert(levels.charAt(2)));
        }
        d1.setImageResource(R.drawable.white1);
        d2.setImageResource(R.drawable.white0);
        d3.setImageResource(R.drawable.white0);
        return view;
    }

    public int convert(char val) {
        if (val == '0') {
            return R.drawable.white0;
        } else if (val == '1') {
            return R.drawable.white1;
        } else if (val == '2') {
            return R.drawable.white2;
        } else if (val == '3') {
            return R.drawable.white3;
        } else if (val == '4') {
            return R.drawable.white4;
        } else if (val == '5') {
            return R.drawable.white5;
        } else if (val == '6') {
            return R.drawable.white6;
        } else if (val == '7') {
            return R.drawable.white7;
        } else if (val == '8') {
            return R.drawable.white8;
        } else if (val == '9') {
            return R.drawable.white9;
        }
        return 0;
    }

    @Override
    public void onClick(View view) {
        int howManyCount = prefs.getInt(getActivity(), SharedPrefs.SharedKeys.count);
        if (howManyCount == 0 || howManyCount == 1) {
            new AlertDialog.Builder(getActivity())
                    .setTitle("How To")
                    .setMessage("If this is your first time, you may want to check the how to page, accessible from the first page. There are some more rules than you may think.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i2 = new Intent(getActivity(), SelectSix.class);
                            startActivity(i2);
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

            prefs.storeInt(getActivity(), SharedPrefs.SharedKeys.count, 6);
        } else {
            Intent i = new Intent(getActivity(), SelectSix.class);
            startActivity(i);
        }
    }
}
