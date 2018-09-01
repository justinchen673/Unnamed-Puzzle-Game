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

public class SelectSeven extends ActionBarActivity implements View.OnClickListener {

    private ImageView l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35, l36, l37, l38, l39, l40, l41, l42, l43, l44, l45, l46, l47, l48, l49, l50, l51, l52, l53, l54, l55, l56, l57, l58, l59, l60, l61, l62, l63, l64, l65, l66, l67, l68, l69, l70, l71, l72, l73, l74, l75, l76, l77, l78, l79, l80, l81, l82, l83, l84, l85, l86, l87, l88, l89, l90, l91, l92, l93, l94, l95, l96, l97, l98, l99, l100;
    private SharedPrefs prefs;
    ArrayList<ImageView> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seven);
        initialize();
        prefs = new SharedPrefs();
        int levelNum = prefs.getInt(getApplicationContext(), SharedPrefs.SharedKeys.seven);
        for (int i = 0; i < levelNum; i++) {
            views.get(i).setImageResource(R.drawable.check);
        }
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, InGameSeven.class);
        int level = 10000;
        if (view.getId() == R.id.l71) {
            i.putExtra("levelNum", 1);
            level = 1;
        } else if (view.getId() == R.id.l72) {
            i.putExtra("levelNum", 2);
            level = 2;
        } else if (view.getId() == R.id.l73) {
            i.putExtra("levelNum", 3);
            level = 3;
        } else if (view.getId() == R.id.l74) {
            i.putExtra("levelNum", 4);
            level = 4;
        } else if (view.getId() == R.id.l75) {
            i.putExtra("levelNum", 5);
            level = 5;
        } else if (view.getId() == R.id.l76) {
            i.putExtra("levelNum", 6);
            level = 6;
        } else if (view.getId() == R.id.l77) {
            i.putExtra("levelNum", 7);
            level = 7;
        } else if (view.getId() == R.id.l78) {
            i.putExtra("levelNum", 8);
            level = 8;
        } else if (view.getId() == R.id.l79) {
            i.putExtra("levelNum", 9);
            level = 9;
        } else if (view.getId() == R.id.l710) {
            i.putExtra("levelNum", 10);
            level = 10;
        } else if (view.getId() == R.id.l711) {
            i.putExtra("levelNum", 11);
            level = 11;
        } else if (view.getId() == R.id.l712) {
            i.putExtra("levelNum", 12);
            level = 12;
        } else if (view.getId() == R.id.l713) {
            i.putExtra("levelNum", 13);
            level = 13;
        } else if (view.getId() == R.id.l714) {
            i.putExtra("levelNum", 14);
            level = 14;
        } else if (view.getId() == R.id.l715) {
            i.putExtra("levelNum", 15);
            level = 15;
        } else if (view.getId() == R.id.l716) {
            i.putExtra("levelNum", 16);
            level = 16;
        } else if (view.getId() == R.id.l717) {
            i.putExtra("levelNum", 17);
            level = 17;
        } else if (view.getId() == R.id.l718) {
            i.putExtra("levelNum", 18);
            level = 18;
        } else if (view.getId() == R.id.l719) {
            i.putExtra("levelNum", 19);
            level = 19;
        } else if (view.getId() == R.id.l720) {
            i.putExtra("levelNum", 20);
            level = 20;
        } else if (view.getId() == R.id.l721) {
            i.putExtra("levelNum", 21);
            level = 21;
        } else if (view.getId() == R.id.l722) {
            i.putExtra("levelNum", 22);
            level = 22;
        } else if (view.getId() == R.id.l723) {
            i.putExtra("levelNum", 23);
            level = 23;
        } else if (view.getId() == R.id.l724) {
            i.putExtra("levelNum", 24);
            level = 24;
        } else if (view.getId() == R.id.l725) {
            i.putExtra("levelNum", 25);
            level = 25;
        } else if (view.getId() == R.id.l726) {
            i.putExtra("levelNum", 26);
            level = 26;
        } else if (view.getId() == R.id.l727) {
            i.putExtra("levelNum", 27);
            level = 27;
        } else if (view.getId() == R.id.l728) {
            i.putExtra("levelNum", 28);
            level = 28;
        } else if (view.getId() == R.id.l729) {
            i.putExtra("levelNum", 29);
            level = 29;
        } else if (view.getId() == R.id.l730) {
            i.putExtra("levelNum", 30);
            level = 30;
        } else if (view.getId() == R.id.l731) {
            i.putExtra("levelNum", 31);
            level = 31;
        } else if (view.getId() == R.id.l732) {
            i.putExtra("levelNum", 32);
            level = 32;
        } else if (view.getId() == R.id.l733) {
            i.putExtra("levelNum", 33);
            level = 33;
        } else if (view.getId() == R.id.l734) {
            i.putExtra("levelNum", 34);
            level = 34;
        } else if (view.getId() == R.id.l735) {
            i.putExtra("levelNum", 35);
            level = 35;
        } else if (view.getId() == R.id.l736) {
            i.putExtra("levelNum", 36);
            level = 36;
        } else if (view.getId() == R.id.l737) {
            i.putExtra("levelNum", 37);
            level = 37;
        } else if (view.getId() == R.id.l738) {
            i.putExtra("levelNum", 38);
            level = 38;
        } else if (view.getId() == R.id.l739) {
            i.putExtra("levelNum", 39);
            level = 39;
        } else if (view.getId() == R.id.l740) {
            i.putExtra("levelNum", 40);
            level = 40;
        } else if (view.getId() == R.id.l741) {
            i.putExtra("levelNum", 41);
            level = 41;
        } else if (view.getId() == R.id.l742) {
            i.putExtra("levelNum", 42);
            level = 42;
        } else if (view.getId() == R.id.l743) {
            i.putExtra("levelNum", 43);
            level = 43;
        } else if (view.getId() == R.id.l744) {
            i.putExtra("levelNum", 44);
            level = 44;
        } else if (view.getId() == R.id.l745) {
            i.putExtra("levelNum", 45);
            level = 45;
        } else if (view.getId() == R.id.l746) {
            i.putExtra("levelNum", 46);
            level = 46;
        } else if (view.getId() == R.id.l747) {
            i.putExtra("levelNum", 47);
            level = 47;
        } else if (view.getId() == R.id.l748) {
            i.putExtra("levelNum", 48);
            level = 48;
        } else if (view.getId() == R.id.l749) {
            i.putExtra("levelNum", 49);
            level = 49;
        } else if (view.getId() == R.id.l750) {
            i.putExtra("levelNum", 50);
            level = 50;
        } else if (view.getId() == R.id.l751) {
            i.putExtra("levelNum", 51);
            level = 51;
        } else if (view.getId() == R.id.l752) {
            i.putExtra("levelNum", 52);
            level = 52;
        } else if (view.getId() == R.id.l753) {
            i.putExtra("levelNum", 53);
            level = 53;
        } else if (view.getId() == R.id.l754) {
            i.putExtra("levelNum", 54);
            level = 54;
        } else if (view.getId() == R.id.l755) {
            i.putExtra("levelNum", 55);
            level = 55;
        } else if (view.getId() == R.id.l756) {
            i.putExtra("levelNum", 56);
            level = 56;
        } else if (view.getId() == R.id.l757) {
            i.putExtra("levelNum", 57);
            level = 57;
        } else if (view.getId() == R.id.l758) {
            i.putExtra("levelNum", 58);
            level = 58;
        } else if (view.getId() == R.id.l759) {
            i.putExtra("levelNum", 59);
            level = 59;
        } else if (view.getId() == R.id.l760) {
            i.putExtra("levelNum", 60);
            level = 60;
        } else if (view.getId() == R.id.l761) {
            i.putExtra("levelNum", 61);
            level = 61;
        } else if (view.getId() == R.id.l762) {
            i.putExtra("levelNum", 62);
            level = 62;
        } else if (view.getId() == R.id.l763) {
            i.putExtra("levelNum", 63);
            level = 63;
        } else if (view.getId() == R.id.l764) {
            i.putExtra("levelNum", 64);
            level = 64;
        } else if (view.getId() == R.id.l765) {
            i.putExtra("levelNum", 65);
            level = 65;
        } else if (view.getId() == R.id.l766) {
            i.putExtra("levelNum", 66);
            level = 66;
        } else if (view.getId() == R.id.l767) {
            i.putExtra("levelNum", 67);
            level = 67;
        } else if (view.getId() == R.id.l768) {
            i.putExtra("levelNum", 68);
            level = 68;
        } else if (view.getId() == R.id.l769) {
            i.putExtra("levelNum", 69);
            level = 69;
        } else if (view.getId() == R.id.l770) {
            i.putExtra("levelNum", 70);
            level = 70;
        } else if (view.getId() == R.id.l771) {
            i.putExtra("levelNum", 71);
            level = 71;
        } else if (view.getId() == R.id.l772) {
            i.putExtra("levelNum", 72);
            level = 72;
        } else if (view.getId() == R.id.l773) {
            i.putExtra("levelNum", 73);
            level = 73;
        } else if (view.getId() == R.id.l774) {
            i.putExtra("levelNum", 74);
            level = 74;
        } else if (view.getId() == R.id.l775) {
            i.putExtra("levelNum", 75);
            level = 75;
        } else if (view.getId() == R.id.l776) {
            i.putExtra("levelNum", 76);
            level = 76;
        } else if (view.getId() == R.id.l777) {
            i.putExtra("levelNum", 77);
            level = 77;
        } else if (view.getId() == R.id.l778) {
            i.putExtra("levelNum", 78);
            level = 78;
        } else if (view.getId() == R.id.l779) {
            i.putExtra("levelNum", 79);
            level = 79;
        } else if (view.getId() == R.id.l780) {
            i.putExtra("levelNum", 80);
            level = 80;
        } else if (view.getId() == R.id.l781) {
            i.putExtra("levelNum", 81);
            level = 81;
        } else if (view.getId() == R.id.l782) {
            i.putExtra("levelNum", 82);
            level = 82;
        } else if (view.getId() == R.id.l783) {
            i.putExtra("levelNum", 83);
            level = 83;
        } else if (view.getId() == R.id.l784) {
            i.putExtra("levelNum", 84);
            level = 84;
        } else if (view.getId() == R.id.l785) {
            i.putExtra("levelNum", 85);
            level = 85;
        } else if (view.getId() == R.id.l786) {
            i.putExtra("levelNum", 86);
            level = 86;
        } else if (view.getId() == R.id.l787) {
            i.putExtra("levelNum", 87);
            level = 87;
        } else if (view.getId() == R.id.l788) {
            i.putExtra("levelNum", 88);
            level = 88;
        } else if (view.getId() == R.id.l789) {
            i.putExtra("levelNum", 89);
            level = 89;
        } else if (view.getId() == R.id.l790) {
            i.putExtra("levelNum", 90);
            level = 90;
        } else if (view.getId() == R.id.l791) {
            i.putExtra("levelNum", 91);
            level = 91;
        } else if (view.getId() == R.id.l792) {
            i.putExtra("levelNum", 92);
            level = 92;
        } else if (view.getId() == R.id.l793) {
            i.putExtra("levelNum", 93);
            level = 93;
        } else if (view.getId() == R.id.l794) {
            i.putExtra("levelNum", 94);
            level = 94;
        } else if (view.getId() == R.id.l795) {
            i.putExtra("levelNum", 95);
            level = 95;
        } else if (view.getId() == R.id.l796) {
            i.putExtra("levelNum", 96);
            level = 96;
        } else if (view.getId() == R.id.l797) {
            i.putExtra("levelNum", 97);
            level = 97;
        } else if (view.getId() == R.id.l798) {
            i.putExtra("levelNum", 98);
            level = 98;
        } else if (view.getId() == R.id.l799) {
            i.putExtra("levelNum", 99);
            level = 99;
        } else if (view.getId() == R.id.l7100) {
            i.putExtra("levelNum", 100);
            level = 100;
        }
        int maxLevel = prefs.getInt(getApplicationContext(), SharedPrefs.SharedKeys.seven);
        maxLevel++;
        if (level <= maxLevel) {
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Level locked!", Toast.LENGTH_LONG).show();
        }
    }

    private void initialize() {
        l1 = (ImageView) findViewById(R.id.l71);
        l2 = (ImageView) findViewById(R.id.l72);
        l3 = (ImageView) findViewById(R.id.l73);
        l4 = (ImageView) findViewById(R.id.l74);
        l5 = (ImageView) findViewById(R.id.l75);
        l6 = (ImageView) findViewById(R.id.l76);
        l7 = (ImageView) findViewById(R.id.l77);
        l8 = (ImageView) findViewById(R.id.l78);
        l9 = (ImageView) findViewById(R.id.l79);
        l10 = (ImageView) findViewById(R.id.l710);
        l11 = (ImageView) findViewById(R.id.l711);
        l12 = (ImageView) findViewById(R.id.l712);
        l13 = (ImageView) findViewById(R.id.l713);
        l14 = (ImageView) findViewById(R.id.l714);
        l15 = (ImageView) findViewById(R.id.l715);
        l16 = (ImageView) findViewById(R.id.l716);
        l17 = (ImageView) findViewById(R.id.l717);
        l18 = (ImageView) findViewById(R.id.l718);
        l19 = (ImageView) findViewById(R.id.l719);
        l20 = (ImageView) findViewById(R.id.l720);
        l21 = (ImageView) findViewById(R.id.l721);
        l22 = (ImageView) findViewById(R.id.l722);
        l23 = (ImageView) findViewById(R.id.l723);
        l24 = (ImageView) findViewById(R.id.l724);
        l25 = (ImageView) findViewById(R.id.l725);
        l26 = (ImageView) findViewById(R.id.l726);
        l27 = (ImageView) findViewById(R.id.l727);
        l28 = (ImageView) findViewById(R.id.l728);
        l29 = (ImageView) findViewById(R.id.l729);
        l30 = (ImageView) findViewById(R.id.l730);
        l31 = (ImageView) findViewById(R.id.l731);
        l32 = (ImageView) findViewById(R.id.l732);
        l33 = (ImageView) findViewById(R.id.l733);
        l34 = (ImageView) findViewById(R.id.l734);
        l35 = (ImageView) findViewById(R.id.l735);
        l36 = (ImageView) findViewById(R.id.l736);
        l37 = (ImageView) findViewById(R.id.l737);
        l38 = (ImageView) findViewById(R.id.l738);
        l39 = (ImageView) findViewById(R.id.l739);
        l40 = (ImageView) findViewById(R.id.l740);
        l41 = (ImageView) findViewById(R.id.l741);
        l42 = (ImageView) findViewById(R.id.l742);
        l43 = (ImageView) findViewById(R.id.l743);
        l44 = (ImageView) findViewById(R.id.l744);
        l45 = (ImageView) findViewById(R.id.l745);
        l46 = (ImageView) findViewById(R.id.l746);
        l47 = (ImageView) findViewById(R.id.l747);
        l48 = (ImageView) findViewById(R.id.l748);
        l49 = (ImageView) findViewById(R.id.l749);
        l50 = (ImageView) findViewById(R.id.l750);
        l51 = (ImageView) findViewById(R.id.l751);
        l52 = (ImageView) findViewById(R.id.l752);
        l53 = (ImageView) findViewById(R.id.l753);
        l54 = (ImageView) findViewById(R.id.l754);
        l55 = (ImageView) findViewById(R.id.l755);
        l56 = (ImageView) findViewById(R.id.l756);
        l57 = (ImageView) findViewById(R.id.l757);
        l58 = (ImageView) findViewById(R.id.l758);
        l59 = (ImageView) findViewById(R.id.l759);
        l60 = (ImageView) findViewById(R.id.l760);
        l61 = (ImageView) findViewById(R.id.l761);
        l62 = (ImageView) findViewById(R.id.l762);
        l63 = (ImageView) findViewById(R.id.l763);
        l64 = (ImageView) findViewById(R.id.l764);
        l65 = (ImageView) findViewById(R.id.l765);
        l66 = (ImageView) findViewById(R.id.l766);
        l67 = (ImageView) findViewById(R.id.l767);
        l68 = (ImageView) findViewById(R.id.l768);
        l69 = (ImageView) findViewById(R.id.l769);
        l70 = (ImageView) findViewById(R.id.l770);
        l71 = (ImageView) findViewById(R.id.l771);
        l72 = (ImageView) findViewById(R.id.l772);
        l73 = (ImageView) findViewById(R.id.l773);
        l74 = (ImageView) findViewById(R.id.l774);
        l75 = (ImageView) findViewById(R.id.l775);
        l76 = (ImageView) findViewById(R.id.l776);
        l77 = (ImageView) findViewById(R.id.l777);
        l78 = (ImageView) findViewById(R.id.l778);
        l79 = (ImageView) findViewById(R.id.l779);
        l80 = (ImageView) findViewById(R.id.l780);
        l81 = (ImageView) findViewById(R.id.l781);
        l82 = (ImageView) findViewById(R.id.l782);
        l83 = (ImageView) findViewById(R.id.l783);
        l84 = (ImageView) findViewById(R.id.l784);
        l85 = (ImageView) findViewById(R.id.l785);
        l86 = (ImageView) findViewById(R.id.l786);
        l87 = (ImageView) findViewById(R.id.l787);
        l88 = (ImageView) findViewById(R.id.l788);
        l89 = (ImageView) findViewById(R.id.l789);
        l90 = (ImageView) findViewById(R.id.l790);
        l91 = (ImageView) findViewById(R.id.l791);
        l92 = (ImageView) findViewById(R.id.l792);
        l93 = (ImageView) findViewById(R.id.l793);
        l94 = (ImageView) findViewById(R.id.l794);
        l95 = (ImageView) findViewById(R.id.l795);
        l96 = (ImageView) findViewById(R.id.l796);
        l97 = (ImageView) findViewById(R.id.l797);
        l98 = (ImageView) findViewById(R.id.l798);
        l99 = (ImageView) findViewById(R.id.l799);
        l100 = (ImageView) findViewById(R.id.l7100);
        ImageView[] arrayViews = {l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35, l36, l37, l38, l39, l40, l41, l42, l43, l44, l45, l46, l47, l48, l49, l50, l51, l52, l53, l54, l55, l56, l57, l58, l59, l60, l61, l62, l63, l64, l65, l66, l67, l68, l69, l70, l71, l72, l73, l74, l75, l76, l77, l78, l79, l80, l81, l82, l83, l84, l85, l86, l87, l88, l89, l90, l91, l92, l93, l94, l95, l96, l97, l98, l99, l100};
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
        l51.setOnClickListener(this);
        l52.setOnClickListener(this);
        l53.setOnClickListener(this);
        l54.setOnClickListener(this);
        l55.setOnClickListener(this);
        l56.setOnClickListener(this);
        l57.setOnClickListener(this);
        l58.setOnClickListener(this);
        l59.setOnClickListener(this);
        l60.setOnClickListener(this);
        l61.setOnClickListener(this);
        l62.setOnClickListener(this);
        l63.setOnClickListener(this);
        l64.setOnClickListener(this);
        l65.setOnClickListener(this);
        l66.setOnClickListener(this);
        l67.setOnClickListener(this);
        l68.setOnClickListener(this);
        l69.setOnClickListener(this);
        l70.setOnClickListener(this);
        l71.setOnClickListener(this);
        l72.setOnClickListener(this);
        l73.setOnClickListener(this);
        l74.setOnClickListener(this);
        l75.setOnClickListener(this);
        l76.setOnClickListener(this);
        l77.setOnClickListener(this);
        l78.setOnClickListener(this);
        l79.setOnClickListener(this);
        l80.setOnClickListener(this);
        l81.setOnClickListener(this);
        l82.setOnClickListener(this);
        l83.setOnClickListener(this);
        l84.setOnClickListener(this);
        l85.setOnClickListener(this);
        l86.setOnClickListener(this);
        l87.setOnClickListener(this);
        l88.setOnClickListener(this);
        l89.setOnClickListener(this);
        l90.setOnClickListener(this);
        l91.setOnClickListener(this);
        l92.setOnClickListener(this);
        l93.setOnClickListener(this);
        l94.setOnClickListener(this);
        l95.setOnClickListener(this);
        l96.setOnClickListener(this);
        l97.setOnClickListener(this);
        l98.setOnClickListener(this);
        l99.setOnClickListener(this);
        l100.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent newIntent = new Intent(this, MainMenu.class);
        newIntent.putExtra("startPage", 4);
        startActivity(newIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_select_seven, menu);
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
