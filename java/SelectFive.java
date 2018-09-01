package com.integraloftan.justin.puzzlegame;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class SelectFive extends ActionBarActivity implements View.OnClickListener {

    private ImageView l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35, l36, l37, l38, l39, l40, l41, l42, l43, l44, l45, l46, l47, l48, l49, l50;
    private SharedPrefs prefs;
    ArrayList<ImageView> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_five);
        initialize();
        prefs = new SharedPrefs();
        int levelNum = prefs.getInt(getApplicationContext(), SharedPrefs.SharedKeys.five);
        for (int i = 0; i < levelNum; i++) {
            views.get(i).setImageResource(R.drawable.check);
        }
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, InGameFive.class);
        int level = 10000;
        if (view.getId() == R.id.l51) {
            i.putExtra("levelNum", 1);
            level = 1;
        } else if (view.getId() == R.id.l52) {
            i.putExtra("levelNum", 2);
            level = 2;
        } else if (view.getId() == R.id.l53) {
            i.putExtra("levelNum", 3);
            level = 3;
        } else if (view.getId() == R.id.l54) {
            i.putExtra("levelNum", 4);
            level = 4;
        } else if (view.getId() == R.id.l55) {
            i.putExtra("levelNum", 5);
            level = 5;
        } else if (view.getId() == R.id.l56) {
            i.putExtra("levelNum", 6);
            level = 6;
        } else if (view.getId() == R.id.l57) {
            i.putExtra("levelNum", 7);
            level = 7;
        } else if (view.getId() == R.id.l58) {
            i.putExtra("levelNum", 8);
            level = 8;
        } else if (view.getId() == R.id.l59) {
            i.putExtra("levelNum", 9);
            level = 9;
        } else if (view.getId() == R.id.l510) {
            i.putExtra("levelNum", 10);
            level = 10;
        } else if (view.getId() == R.id.l511) {
            i.putExtra("levelNum", 11);
            level = 11;
        } else if (view.getId() == R.id.l512) {
            i.putExtra("levelNum", 12);
            level = 12;
        } else if (view.getId() == R.id.l513) {
            i.putExtra("levelNum", 13);
            level = 13;
        } else if (view.getId() == R.id.l514) {
            i.putExtra("levelNum", 14);
            level = 14;
        } else if (view.getId() == R.id.l515) {
            i.putExtra("levelNum", 15);
            level = 15;
        } else if (view.getId() == R.id.l516) {
            i.putExtra("levelNum", 16);
            level = 16;
        } else if (view.getId() == R.id.l517) {
            i.putExtra("levelNum", 17);
            level = 17;
        } else if (view.getId() == R.id.l518) {
            i.putExtra("levelNum", 18);
            level = 18;
        } else if (view.getId() == R.id.l519) {
            i.putExtra("levelNum", 19);
            level = 19;
        } else if (view.getId() == R.id.l520) {
            i.putExtra("levelNum", 20);
            level = 20;
        } else if (view.getId() == R.id.l521) {
            i.putExtra("levelNum", 21);
            level = 21;
        } else if (view.getId() == R.id.l522) {
            i.putExtra("levelNum", 22);
            level = 22;
        } else if (view.getId() == R.id.l523) {
            i.putExtra("levelNum", 23);
            level = 23;
        } else if (view.getId() == R.id.l524) {
            i.putExtra("levelNum", 24);
            level = 24;
        } else if (view.getId() == R.id.l525) {
            i.putExtra("levelNum", 25);
            level = 25;
        } else if (view.getId() == R.id.l526) {
            i.putExtra("levelNum", 26);
            level = 26;
        } else if (view.getId() == R.id.l527) {
            i.putExtra("levelNum", 27);
            level = 27;
        } else if (view.getId() == R.id.l528) {
            i.putExtra("levelNum", 28);
            level = 28;
        } else if (view.getId() == R.id.l529) {
            i.putExtra("levelNum", 29);
            level = 29;
        } else if (view.getId() == R.id.l530) {
            i.putExtra("levelNum", 30);
            level = 30;
        } else if (view.getId() == R.id.l531) {
            i.putExtra("levelNum", 31);
            level = 31;
        } else if (view.getId() == R.id.l532) {
            i.putExtra("levelNum", 32);
            level = 32;
        } else if (view.getId() == R.id.l533) {
            i.putExtra("levelNum", 33);
            level = 33;
        } else if (view.getId() == R.id.l534) {
            i.putExtra("levelNum", 34);
            level = 34;
        } else if (view.getId() == R.id.l535) {
            i.putExtra("levelNum", 35);
            level = 35;
        } else if (view.getId() == R.id.l536) {
            i.putExtra("levelNum", 36);
            level = 36;
        } else if (view.getId() == R.id.l537) {
            i.putExtra("levelNum", 37);
            level = 37;
        } else if (view.getId() == R.id.l538) {
            i.putExtra("levelNum", 38);
            level = 38;
        } else if (view.getId() == R.id.l539) {
            i.putExtra("levelNum", 39);
            level = 39;
        } else if (view.getId() == R.id.l540) {
            i.putExtra("levelNum", 40);
            level = 40;
        } else if (view.getId() == R.id.l541) {
            i.putExtra("levelNum", 41);
            level = 41;
        } else if (view.getId() == R.id.l542) {
            i.putExtra("levelNum", 42);
            level = 42;
        } else if (view.getId() == R.id.l543) {
            i.putExtra("levelNum", 43);
            level = 43;
        } else if (view.getId() == R.id.l544) {
            i.putExtra("levelNum", 44);
            level = 44;
        } else if (view.getId() == R.id.l545) {
            i.putExtra("levelNum", 45);
            level = 45;
        } else if (view.getId() == R.id.l546) {
            i.putExtra("levelNum", 46);
            level = 46;
        } else if (view.getId() == R.id.l547) {
            i.putExtra("levelNum", 47);
            level = 47;
        } else if (view.getId() == R.id.l548) {
            i.putExtra("levelNum", 48);
            level = 48;
        } else if (view.getId() == R.id.l549) {
            i.putExtra("levelNum", 49);
            level = 49;
        } else if (view.getId() == R.id.l550) {
            i.putExtra("levelNum", 50);
            level = 50;
        }
        int maxLevel = prefs.getInt(getApplicationContext(), SharedPrefs.SharedKeys.five);
        maxLevel++;
        if (level <= maxLevel) {
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Level locked!", Toast.LENGTH_LONG).show();
        }
    }

    public void initialize() {
        l1 = (ImageView) findViewById(R.id.l51);
        l2 = (ImageView) findViewById(R.id.l52);
        l3 = (ImageView) findViewById(R.id.l53);
        l4 = (ImageView) findViewById(R.id.l54);
        l5 = (ImageView) findViewById(R.id.l55);
        l6 = (ImageView) findViewById(R.id.l56);
        l7 = (ImageView) findViewById(R.id.l57);
        l8 = (ImageView) findViewById(R.id.l58);
        l9 = (ImageView) findViewById(R.id.l59);
        l10 = (ImageView) findViewById(R.id.l510);
        l11 = (ImageView) findViewById(R.id.l511);
        l12 = (ImageView) findViewById(R.id.l512);
        l13 = (ImageView) findViewById(R.id.l513);
        l14 = (ImageView) findViewById(R.id.l514);
        l15 = (ImageView) findViewById(R.id.l515);
        l16 = (ImageView) findViewById(R.id.l516);
        l17 = (ImageView) findViewById(R.id.l517);
        l18 = (ImageView) findViewById(R.id.l518);
        l19 = (ImageView) findViewById(R.id.l519);
        l20 = (ImageView) findViewById(R.id.l520);
        l21 = (ImageView) findViewById(R.id.l521);
        l22 = (ImageView) findViewById(R.id.l522);
        l23 = (ImageView) findViewById(R.id.l523);
        l24 = (ImageView) findViewById(R.id.l524);
        l25 = (ImageView) findViewById(R.id.l525);
        l26 = (ImageView) findViewById(R.id.l526);
        l27 = (ImageView) findViewById(R.id.l527);
        l28 = (ImageView) findViewById(R.id.l528);
        l29 = (ImageView) findViewById(R.id.l529);
        l30 = (ImageView) findViewById(R.id.l530);
        l31 = (ImageView) findViewById(R.id.l531);
        l32 = (ImageView) findViewById(R.id.l532);
        l33 = (ImageView) findViewById(R.id.l533);
        l34 = (ImageView) findViewById(R.id.l534);
        l35 = (ImageView) findViewById(R.id.l535);
        l36 = (ImageView) findViewById(R.id.l536);
        l37 = (ImageView) findViewById(R.id.l537);
        l38 = (ImageView) findViewById(R.id.l538);
        l39 = (ImageView) findViewById(R.id.l539);
        l40 = (ImageView) findViewById(R.id.l540);
        l41 = (ImageView) findViewById(R.id.l541);
        l42 = (ImageView) findViewById(R.id.l542);
        l43 = (ImageView) findViewById(R.id.l543);
        l44 = (ImageView) findViewById(R.id.l544);
        l45 = (ImageView) findViewById(R.id.l545);
        l46 = (ImageView) findViewById(R.id.l546);
        l47 = (ImageView) findViewById(R.id.l547);
        l48 = (ImageView) findViewById(R.id.l548);
        l49 = (ImageView) findViewById(R.id.l549);
        l50 = (ImageView) findViewById(R.id.l550);
        ImageView[] arrayViews = {l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35, l36, l37, l38, l39, l40, l41, l42, l43, l44, l45, l46, l47, l48, l49, l50};
        views = new ArrayList<>();
        views.addAll(Arrays.asList(arrayViews));
        l1.setOnClickListener(this);
        l2.setOnClickListener(this);
        l3.setOnClickListener(this);
        l4.setOnClickListener(this);
        l5.setOnClickListener(this);
        l6.setOnClickListener(this);
        l7.setOnClickListener(this);
        l8.setOnClickListener(this);
        l9.setOnClickListener(this);
        l10.setOnClickListener(this);
        l11.setOnClickListener(this);
        l12.setOnClickListener(this);
        l13.setOnClickListener(this);
        l14.setOnClickListener(this);
        l15.setOnClickListener(this);
        l16.setOnClickListener(this);
        l17.setOnClickListener(this);
        l18.setOnClickListener(this);
        l19.setOnClickListener(this);
        l20.setOnClickListener(this);
        l21.setOnClickListener(this);
        l22.setOnClickListener(this);
        l23.setOnClickListener(this);
        l24.setOnClickListener(this);
        l25.setOnClickListener(this);
        l26.setOnClickListener(this);
        l27.setOnClickListener(this);
        l28.setOnClickListener(this);
        l29.setOnClickListener(this);
        l30.setOnClickListener(this);
        l31.setOnClickListener(this);
        l32.setOnClickListener(this);
        l33.setOnClickListener(this);
        l34.setOnClickListener(this);
        l35.setOnClickListener(this);
        l36.setOnClickListener(this);
        l37.setOnClickListener(this);
        l38.setOnClickListener(this);
        l39.setOnClickListener(this);
        l40.setOnClickListener(this);
        l41.setOnClickListener(this);
        l42.setOnClickListener(this);
        l43.setOnClickListener(this);
        l44.setOnClickListener(this);
        l45.setOnClickListener(this);
        l46.setOnClickListener(this);
        l47.setOnClickListener(this);
        l48.setOnClickListener(this);
        l49.setOnClickListener(this);
        l50.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent newIntent = new Intent(this, MainMenu.class);
        newIntent.putExtra("startPage", 2);
        startActivity(newIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_select_five, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
