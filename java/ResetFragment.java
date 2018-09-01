package com.integraloftan.justin.puzzlegame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ResetFragment extends Fragment implements View.OnClickListener {

    private ImageView r, e, s, e2, t;
    private SharedPrefs prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.reset_fragment, container, false);
        prefs = new SharedPrefs();
        r = (ImageView) view.findViewById(R.id.r);
        e = (ImageView) view.findViewById(R.id.e);
        s = (ImageView) view.findViewById(R.id.s);
        e2 = (ImageView) view.findViewById(R.id.e2);
        t = (ImageView) view.findViewById(R.id.t);
        r.setOnClickListener(this);
        e.setOnClickListener(this);
        s.setOnClickListener(this);
        e2.setOnClickListener(this);
        t.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        new AlertDialog.Builder(getActivity())
                .setTitle("Reset Progress")
                .setMessage("Are you sure you want to reset all of your progress?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        prefs.storeInt(getActivity(), SharedPrefs.SharedKeys.five, 0);
                        prefs.storeInt(getActivity(), SharedPrefs.SharedKeys.six, 0);
                        prefs.storeInt(getActivity(), SharedPrefs.SharedKeys.seven, 0);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}