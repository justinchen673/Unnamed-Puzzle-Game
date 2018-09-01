package com.integraloftan.justin.puzzlegame;

import java.util.ArrayList;

/**
 * Created by Justin on 3/12/2015.
 */
public class Shape {
    private ArrayList<Integer> values;
    private int drawable;
    private boolean filled;

    public Shape(ArrayList<Integer> values, int drawable, boolean filled) {
        this.values = values;
        this.drawable = drawable;
        this.filled = filled;
    }

    public ArrayList<Integer> getValues(){return values;}

    public int getDrawable(){return drawable;}

    public boolean getFilled(){return filled;}
}
