package com.integraloftan.justin.puzzlegame;

/**
 * Created by Justin on 3/14/2015.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MenuFragment extends Fragment implements View.OnClickListener {

    ImageView h, o, w, dash, t, o2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment, container, false);
        h = (ImageView) view.findViewById(R.id.howto1);
        o = (ImageView) view.findViewById(R.id.howto2);
        w = (ImageView) view.findViewById(R.id.howto3);
        dash = (ImageView) view.findViewById(R.id.howto4);
        t = (ImageView) view.findViewById(R.id.howto5);
        o2 = (ImageView) view.findViewById(R.id.howto6);
        h.setOnClickListener(this);
        o.setOnClickListener(this);
        w.setOnClickListener(this);
        dash.setOnClickListener(this);
        t.setOnClickListener(this);
        o2.setOnClickListener(this);
        SharedPrefs prefs = new SharedPrefs();
        int temp = prefs.getInt(getActivity(), "first");
        if (temp == 1 || temp == 0) {
            prefs.storeInt(getActivity(), "first", 500);
            prefs.storeBoolean(getActivity(), "easy", true);
            prefs.storeBoolean(getActivity(), "medium", false);
            prefs.storeBoolean(getActivity(), "hard", false);
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getActivity(), HowTo.class);
        startActivity(i);
    }
}
