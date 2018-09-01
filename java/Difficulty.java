package com.integraloftan.justin.puzzlegame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Difficulty extends Fragment implements View.OnClickListener {

    private ImageView e, a, s, y, m, e2, d, i, u, m2, h, a2, r, d2;
    private SharedPrefs prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.difficulty_fragment, container, false);
        prefs = new SharedPrefs();
        e = (ImageView) view.findViewById(R.id.e);
        a = (ImageView) view.findViewById(R.id.a);
        s = (ImageView) view.findViewById(R.id.s);
        y = (ImageView) view.findViewById(R.id.y);
        m = (ImageView) view.findViewById(R.id.m);
        e2 = (ImageView) view.findViewById(R.id.e2);
        d = (ImageView) view.findViewById(R.id.d);
        i = (ImageView) view.findViewById(R.id.i);
        u = (ImageView) view.findViewById(R.id.u);
        m2 = (ImageView) view.findViewById(R.id.m2);
        h = (ImageView) view.findViewById(R.id.h);
        a2 = (ImageView) view.findViewById(R.id.a2);
        r = (ImageView) view.findViewById(R.id.r);
        d2 = (ImageView) view.findViewById(R.id.d2);
        e.setOnClickListener(this);
        a.setOnClickListener(this);
        y.setOnClickListener(this);
        s.setOnClickListener(this);
        m.setOnClickListener(this);
        e2.setOnClickListener(this);
        d.setOnClickListener(this);
        i.setOnClickListener(this);
        u.setOnClickListener(this);
        m2.setOnClickListener(this);
        h.setOnClickListener(this);
        a2.setOnClickListener(this);
        r.setOnClickListener(this);
        d2.setOnClickListener(this);
        boolean easy = prefs.getBoolean(getActivity(), "easy");
        boolean medium = prefs.getBoolean(getActivity(), "medium");
        boolean hard = prefs.getBoolean(getActivity(), "hard");
        if (easy) {
            e.setImageResource(R.drawable.eyellow);
            a.setImageResource(R.drawable.ayellow);
            s.setImageResource(R.drawable.syellow);
            y.setImageResource(R.drawable.yyellow);
        } else if (medium) {
            m.setImageResource(R.drawable.myellow);
            e2.setImageResource(R.drawable.eyellow);
            d.setImageResource(R.drawable.dyellow);
            i.setImageResource(R.drawable.iyellow);
            u.setImageResource(R.drawable.uyellow);
            m2.setImageResource(R.drawable.myellow);
        } else if (hard) {
            h.setImageResource(R.drawable.hyellow);
            a2.setImageResource(R.drawable.ayellow);
            r.setImageResource(R.drawable.rcharyellow);
            d2.setImageResource(R.drawable.dyellow);
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.e || v.getId() == R.id.a || v.getId() == R.id.y || v.getId() == R.id.s) {
            e.setImageResource(R.drawable.eyellow);
            a.setImageResource(R.drawable.ayellow);
            s.setImageResource(R.drawable.syellow);
            y.setImageResource(R.drawable.yyellow);
            prefs.storeBoolean(getActivity(), "easy", true);
            prefs.storeBoolean(getActivity(), "medium", false);
            prefs.storeBoolean(getActivity(), "hard", false);
            m.setImageResource(R.drawable.mwhite);
            e2.setImageResource(R.drawable.ewhite);
            d.setImageResource(R.drawable.dwhite);
            i.setImageResource(R.drawable.iwhite);
            u.setImageResource(R.drawable.uwhite);
            m2.setImageResource(R.drawable.mwhite);
            h.setImageResource(R.drawable.hwhite);
            a2.setImageResource(R.drawable.awhite);
            r.setImageResource(R.drawable.rwhite);
            d2.setImageResource(R.drawable.dwhite);
        } else if (v.getId() == R.id.m || v.getId() == R.id.e2 || v.getId() == R.id.d || v.getId() == R.id.i || v.getId() == R.id.u || v.getId() == R.id.m2) {
            m.setImageResource(R.drawable.myellow);
            e2.setImageResource(R.drawable.eyellow);
            d.setImageResource(R.drawable.dyellow);
            i.setImageResource(R.drawable.iyellow);
            u.setImageResource(R.drawable.uyellow);
            m2.setImageResource(R.drawable.myellow);
            prefs.storeBoolean(getActivity(), "easy", false);
            prefs.storeBoolean(getActivity(), "medium", true);
            prefs.storeBoolean(getActivity(), "hard", false);
            h.setImageResource(R.drawable.hwhite);
            a2.setImageResource(R.drawable.awhite);
            r.setImageResource(R.drawable.rwhite);
            d2.setImageResource(R.drawable.dwhite);
            e.setImageResource(R.drawable.ewhite);
            a.setImageResource(R.drawable.awhite);
            s.setImageResource(R.drawable.swhite);
            y.setImageResource(R.drawable.ywhite);
        } else if (v.getId() == R.id.h || v.getId() == R.id.a2 || v.getId() == R.id.r || v.getId() == R.id.d2) {
            h.setImageResource(R.drawable.hyellow);
            a2.setImageResource(R.drawable.ayellow);
            r.setImageResource(R.drawable.rcharyellow);
            d2.setImageResource(R.drawable.dyellow);
            prefs.storeBoolean(getActivity(), "easy", false);
            prefs.storeBoolean(getActivity(), "medium", false);
            prefs.storeBoolean(getActivity(), "hard", true);
            m.setImageResource(R.drawable.mwhite);
            e2.setImageResource(R.drawable.ewhite);
            d.setImageResource(R.drawable.dwhite);
            i.setImageResource(R.drawable.iwhite);
            u.setImageResource(R.drawable.uwhite);
            m2.setImageResource(R.drawable.mwhite);
            e.setImageResource(R.drawable.ewhite);
            a.setImageResource(R.drawable.awhite);
            s.setImageResource(R.drawable.swhite);
            y.setImageResource(R.drawable.ywhite);
        }
    }
}