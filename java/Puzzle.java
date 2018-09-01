package com.integraloftan.justin.puzzlegame;

import java.util.ArrayList;

/**
 * Created by Justin on 4/6/2015.
 */
public class Puzzle {

    private ArrayList<Integer> pieces, first, second;

    public Puzzle(ArrayList<Integer> pieces, ArrayList<Integer> first, ArrayList<Integer> second) {
        this.pieces = new ArrayList<>(pieces);
        this.first = new ArrayList<>(first);
        this.second = new ArrayList<>(second);
    }

    public ArrayList<Integer> getPieces(){return pieces;}
    public ArrayList<Integer> getFirst(){return first;}
    public ArrayList<Integer> getSecond(){return second;}
}
