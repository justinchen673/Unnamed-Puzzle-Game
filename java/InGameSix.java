package com.integraloftan.justin.puzzlegame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class InGameSix extends ActionBarActivity implements View.OnLongClickListener {

    private Runnable r;
    private Handler handler;
    private boolean arrowOnPoint, menuOnPoint;
    private int count, levelNumInteger, random;
    private int[] colorsDone;
    private ArrayList<Shape> shapes;
    private ArrayList<Integer> indexes, colors, piecesList, filled, piecesListOriginal;
    private ArrayList<ImageView> ivList, ivPieces;
    private ImageView piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8, piece9, piece10, piece11, piece12, piece13, piece14, piece15, clear, iv0, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11, iv12, iv13, iv14, iv15, iv16, iv17, iv18, iv19, iv20, iv21, iv22, iv23, iv24, iv25, iv26, iv27, iv28, iv29, iv30, iv31, iv32, iv33, iv34, iv35;
    private TextView levelTv;
    private boolean keepGoing, canPick, newColor;
    private ArrayList<Puzzle> puzzleList;
    private Puzzle current;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game_six);
        initialize();
        shapes = new ArrayList<>();
        arrowOnPoint = false;
        menuOnPoint = false;
        keepGoing = true;
        canPick = false;
        filled = new ArrayList<>();
        colors = new ArrayList<>();
        colors.add(R.drawable.rblue);
        colors.add(R.drawable.rcyan);
        colors.add(R.drawable.rgreen);
        colors.add(R.drawable.raqua);
        colors.add(R.drawable.rred);
        colors.add(R.drawable.rgrey);
        colors.add(R.drawable.ryellow);
        colors.add(R.drawable.rpink);
        colors.add(R.drawable.rorange);
        colors.add(R.drawable.rdarkgreen);
        colors.add(R.drawable.rpurple);
        colors.add(R.drawable.rdarkred);
        colors.add(R.drawable.rlightgreen);
        colors.add(R.drawable.rlightmurky);
        colors.add(R.drawable.rlightpurple);
        colors.add(R.drawable.rlightpink);
        colors.add(R.drawable.rlightred);
        colors.add(R.drawable.rmurky);
        colors.add(R.drawable.rnavy);
        SharedPrefs prefs2 = new SharedPrefs();
        boolean easy = prefs2.getBoolean(getApplicationContext(), "easy");
        boolean medium = prefs2.getBoolean(getApplicationContext(), "medium");
        boolean hard = prefs2.getBoolean(getApplicationContext(), "hard");
        indexes = new ArrayList<>();
        piecesListOriginal = new ArrayList<>();
        Intent i = getIntent();
        levelNumInteger = i.getIntExtra("levelNum", 0);
        levelTv.setText("Level " + levelNumInteger);
        ((Puzzles) this.getApplication()).createSixPuzzles();
        puzzleList = ((Puzzles) this.getApplication()).getSixPuzzle();
        current = puzzleList.get(levelNumInteger - 1);
        piecesList = new ArrayList<>();
        ArrayList<Integer> piece1;
        ArrayList<Integer> piece2;

        if (hard) {
            piecesList = current.getPieces();
            for (int j = 0; j < piecesList.size(); j++) {
                piecesListOriginal.add(piecesList.get(j));
            }
        } else if (medium) {
            for (int j = 1; j < current.getPieces().size(); j++) {
                piecesList.add(current.getPieces().get(j));
            }
            for (int j = 0; j < piecesList.size(); j++) {
                piecesListOriginal.add(piecesList.get(j));
            }
            piece1 = current.getFirst();
            for (int j = 0; j < piece1.size(); j++) {
                ivList.get(piece1.get(j)).setImageResource(R.drawable.whitesquarer);
                filled.add(piece1.get(j));
            }
        } else if (easy) {
            for (int j = 2; j < current.getPieces().size(); j++) {
                piecesList.add(current.getPieces().get(j));
            }
            for (int j = 0; j < piecesList.size(); j++) {
                piecesListOriginal.add(piecesList.get(j));
            }
            piece1 = current.getFirst();
            piece2 = current.getSecond();
            for (int j = 0; j < piece1.size(); j++) {
                ivList.get(piece1.get(j)).setImageResource(R.drawable.whitesquarer);
                filled.add(piece1.get(j));
            }
            for (int j = 0; j < piece2.size(); j++) {
                ivList.get(piece2.get(j)).setImageResource(R.drawable.whitesquarer);
                filled.add(piece2.get(j));
            }
        }

        for (int k = 0; k < piecesList.size(); k++) {
            shapes.add(new Shape(new ArrayList<Integer>(), 0, false));
        }
        resetPieces();
        clear = (ImageView) findViewById(R.id.clear6);
        clear.setOnLongClickListener(this);
        colorsDone = new int[21];
        Arrays.fill(colorsDone, -1);
        newColor = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int xPos=-1;
        int yPos=-1;
        int x = Math.round(event.getX());
        int y = Math.round(event.getY());
        double numX,numY;
        int index;

        int[] positionArr = new int[2];
        iv0.getLocationOnScreen(positionArr);
        int left =positionArr[0];
        int top = positionArr[1];
        iv35.getLocationOnScreen(positionArr);
        int right = positionArr[0] + iv35.getWidth();
        int bottom = positionArr[1] + iv35.getHeight();

        int width = right-left;
        int height = bottom-top;

        iv16.getLocationOnScreen(positionArr);
        int arrowLeft = positionArr[0];
        int arrowTop = positionArr[1];
        int arrowRight = iv16.getWidth() + arrowLeft;
        int arrowBottom = iv16.getWidth() + arrowTop;

        iv28.getLocationOnScreen(positionArr);
        int menuLeft = positionArr[0];
        int menuTop = positionArr[1];
        int menuRight = iv29.getWidth() + menuLeft;
        int menuBottom = iv29.getWidth() + menuTop;

        if (keepGoing) {
            if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE) {
                numX = ((double) (x - left)) / ((double) width);
                numY = ((double) (y - top)) / ((double) height);
                if (numX <= 0.16666666666) {
                    xPos = 0;
                } else if (numX <= 0.33333333333333) {
                    xPos = 1;
                } else if (numX <= 0.5) {
                    xPos = 2;
                } else if (numX <= 0.666666666666) {
                    xPos = 3;
                } else if (numX <= 0.83333333333333) {
                    xPos = 4;
                } else if (numX <= 1) {
                    xPos = 5;
                }

                if (numY <= 0.16666666666) {
                    yPos = 0;
                } else if (numY <= 0.33333333333333) {
                    yPos = 1;
                } else if (numY <= 0.5) {
                    yPos = 2;
                } else if (numY <= 0.666666666666) {
                    yPos = 3;
                } else if (numY <= 0.83333333333333) {
                    yPos = 4;
                } else if (numY <= 1) {
                    yPos = 5;
                }

                index = -1;

                if (xPos != -1 && yPos != -1) {
                    index = convertToIndex(xPos, yPos);
                }
                if (index != -1) {
                    for (int i = 0; i < filled.size(); i++) {
                        if (filled.get(i) == index) {
                            HashSet hs = new HashSet();
                            hs.addAll(indexes);
                            indexes.clear();
                            indexes.addAll(hs);
                            for (int j = 0; j < indexes.size(); j++) {
                                ivList.get(indexes.get(j)).setImageResource(R.drawable.blank6);
                            }
                            indexes.clear();
                            return true;
                        }
                    }
                    if (newColor) {
                        newColor = false;
                        while (true) {
                            random = (int) (Math.random() * (colors.size() - 1));
                            if ((colorsDone[random]) == -1) {
                                break;
                            }
                        }
                    }
                    ivList.get(index).setImageResource(colors.get(random));
                    indexes.add(index);
                }
            } else if (action == MotionEvent.ACTION_UP) {
                HashSet hs = new HashSet();
                newColor = true;
                hs.addAll(indexes);
                indexes.clear();
                indexes.addAll(hs);
                int tempCornerIndex = -1;
                for (int i = 0; i < indexes.size(); i++) {
                    if (indexes.get(i) > tempCornerIndex) {
                        tempCornerIndex = indexes.get(i);
                    }
                }
                boolean twoLpiece = check2l(tempCornerIndex);
                boolean cornerLeft = checkCornerLeft(tempCornerIndex);
                boolean cornerRight = checkCornerRight(tempCornerIndex);
                boolean flip2l = checkFlip2l(tempCornerIndex);
                boolean flipLongl = checkFlipLongL(tempCornerIndex);
                boolean flipLongU = checkFlipLongU(tempCornerIndex);
                boolean flipReverse2l = checkFlipReverse2l(tempCornerIndex);
                boolean flipReverseLongl = checkFlipReverseLongL(tempCornerIndex);
                boolean flipTallL = checkFlipTallL(tempCornerIndex);
                boolean flipU = checkFlipU(tempCornerIndex);
                boolean horizontalLine = checkHorizontalLine();
                boolean integral = checkIntegral(tempCornerIndex);
                boolean l = checkL(tempCornerIndex);
                boolean longL = checkLongL(tempCornerIndex);
                boolean longU = checkLongU(tempCornerIndex);
                boolean reverse2l = checkReverse2l(tempCornerIndex);
                boolean reverseFlipTallL = checkReverseFlipTallL(tempCornerIndex);
                boolean reverseIntegral = checkReverseIntegral(tempCornerIndex);
                boolean reverseL = checkReverseL(tempCornerIndex);
                boolean reverseLongL = checkReverseLongL(tempCornerIndex);
                boolean reverseSideIntegral = checkReverseSideIntegral(tempCornerIndex);
                boolean reverseSideLongU = checkReverseSideLongU(tempCornerIndex);
                boolean reverseSideU = checkReverseSideU(tempCornerIndex);
                boolean reverseTallL = checkReverseTallL(tempCornerIndex);
                boolean reverseVZigZag = checkReverseVZigZag(tempCornerIndex);
                boolean reverseZigZag = checkReverseZigZag(tempCornerIndex);
                boolean sideIntegral = checkSideIntegral(tempCornerIndex);
                boolean sideLongU = checkSideLongU(tempCornerIndex);
                boolean sideU = checkSideU(tempCornerIndex);
                boolean square = checkSquare(tempCornerIndex);
                boolean tallL = checkTallL(tempCornerIndex);
                boolean uPiece = checkUPiece(tempCornerIndex);
                boolean verticalLine = checkVerticalLine(tempCornerIndex);
                boolean vZigZag = checkVZigZag(tempCornerIndex);
                boolean zigzag = checkZigzag(tempCornerIndex);
                boolean foundOne = false;
                int resourceID = 0;
                if (twoLpiece) {
                    resourceID = R.drawable.twolpiecered;
                } else if (cornerLeft) {
                    resourceID = R.drawable.cornerleftred1;
                } else if (cornerRight) {
                    resourceID = R.drawable.cornerrightred;
                } else if (flip2l) {
                    resourceID = R.drawable.flip2lred;
                } else if (flipLongl) {
                    resourceID = R.drawable.fliplonglred;
                } else if (flipLongU) {
                    resourceID = R.drawable.fliplongured;
                } else if (flipReverse2l) {
                    resourceID = R.drawable.flipreverse2lred;
                } else if (flipReverseLongl) {
                    resourceID = R.drawable.flipreverselonglred;
                } else if (flipTallL) {
                    resourceID = R.drawable.fliptalllred;
                } else if (flipU) {
                    resourceID = R.drawable.flipured;
                } else if (horizontalLine) {
                    resourceID = R.drawable.horizontallinered;
                } else if (integral) {
                    resourceID = R.drawable.integralred;
                } else if (l) {
                    resourceID = R.drawable.lred;
                } else if (longL) {
                    resourceID = R.drawable.longlred;
                } else if (longU) {
                    resourceID = R.drawable.longured;
                } else if (reverse2l) {
                    resourceID = R.drawable.reverse2lred;
                } else if (reverseFlipTallL) {
                    resourceID = R.drawable.reversefliptalllred;
                } else if (reverseIntegral) {
                    resourceID = R.drawable.reverseintegralred;
                } else if (reverseL) {
                    resourceID = R.drawable.reverselred;
                } else if (reverseLongL) {
                    resourceID = R.drawable.reverselonglred;
                } else if (reverseSideIntegral) {
                    resourceID = R.drawable.reversesideintegralred;
                } else if (reverseSideLongU) {
                    resourceID = R.drawable.reversesidelongured;
                } else if (reverseSideU) {
                    resourceID = R.drawable.reversesideured;
                } else if (reverseTallL) {
                    resourceID = R.drawable.reversetalllred;
                } else if (reverseVZigZag) {
                    resourceID = R.drawable.reversevzigzagred;
                } else if (reverseZigZag) {
                    resourceID = R.drawable.reversezigzagred;
                } else if (sideIntegral) {
                    resourceID = R.drawable.sideintegralred;
                } else if (sideLongU) {
                    resourceID = R.drawable.sidelongured;
                } else if (sideU) {
                    resourceID = R.drawable.sideured;
                } else if (square) {
                    resourceID = R.drawable.squarered;
                } else if (tallL) {
                    resourceID = R.drawable.talllred;
                } else if (uPiece) {
                    resourceID = R.drawable.upiecered;
                } else if (verticalLine) {
                    resourceID = R.drawable.verticallinered;
                } else if (vZigZag) {
                    resourceID = R.drawable.vzigzagred;
                } else if (zigzag) {
                    resourceID = R.drawable.zigzagred;
                }
                if (resourceID != 0) {
                    for (int i = 0; i < piecesList.size(); i++) {
                        if ((piecesList.get(i) == R.drawable.twolpiece && twoLpiece) || (piecesList.get(i) == R.drawable.cornerleft1 && cornerLeft) || (piecesList.get(i) == R.drawable.cornerright && cornerRight) || (piecesList.get(i) == R.drawable.flip2l && flip2l) || (piecesList.get(i) == R.drawable.fliplongl && flipLongl) || (piecesList.get(i) == R.drawable.fliplongu && flipLongU) || (piecesList.get(i) == R.drawable.flipreverse2l && flipReverse2l) || (piecesList.get(i) == R.drawable.flipreverselongl && flipReverseLongl) || (piecesList.get(i) == R.drawable.fliptalll && flipTallL) || (piecesList.get(i) == R.drawable.flipu && flipU) || (piecesList.get(i) == R.drawable.horizontalline && horizontalLine) || (piecesList.get(i) == R.drawable.integral && integral) || (piecesList.get(i) == R.drawable.l && l) || (piecesList.get(i) == R.drawable.longl && longL) || (piecesList.get(i) == R.drawable.longu && longU) || (piecesList.get(i) == R.drawable.reverse2l && reverse2l) || (piecesList.get(i) == R.drawable.reversefliptalll && reverseFlipTallL) || (piecesList.get(i) == R.drawable.reverseintegral && reverseIntegral) || (piecesList.get(i) == R.drawable.reversel && reverseL) || (piecesList.get(i) == R.drawable.reverselongl && reverseLongL) || (piecesList.get(i) == R.drawable.reversesideintegral && reverseSideIntegral) || (piecesList.get(i) == R.drawable.reversesidelongu && reverseSideLongU) || (piecesList.get(i) == R.drawable.reversesideu && reverseSideU) || (piecesList.get(i) == R.drawable.reversetalll && reverseTallL) || (piecesList.get(i) == R.drawable.reversevzigzag && reverseVZigZag) || (piecesList.get(i) == R.drawable.reversezigzag && reverseZigZag) || (piecesList.get(i) == R.drawable.sideintegral && sideIntegral) || (piecesList.get(i) == R.drawable.sidelongu && sideLongU) || (piecesList.get(i) == R.drawable.sideu && sideU) || (piecesList.get(i) == R.drawable.square && square) || (piecesList.get(i) == R.drawable.talll && tallL) || (piecesList.get(i) == R.drawable.upiece && uPiece) || (piecesList.get(i) == R.drawable.verticalline && verticalLine) || (piecesList.get(i) == R.drawable.vzigzag && vZigZag) || (piecesList.get(i) == R.drawable.zigzag && zigzag)) {
                            foundOne = true;
                            colorsDone[random] = i;
                            piecesList.set(i, 0);
                            ArrayList<Integer> setShapeIndexes = new ArrayList<>();
                            for (int j = 0; j < indexes.size(); j++) {
                                setShapeIndexes.add(indexes.get(j));
                            }
                            Shape newShape = new Shape(setShapeIndexes, resourceID, true);
                            shapes.set(i, newShape);
                        }
                        if (foundOne) {
                            for (int k = 0; k < indexes.size(); k++) {
                                filled.add(indexes.get(k));
                            }
                            if (i == 0) {
                                piece1.setImageResource(resourceID);
                            } else if (i == 1) {
                                piece2.setImageResource(resourceID);
                            } else if (i == 2) {
                                piece3.setImageResource(resourceID);
                            } else if (i == 3) {
                                piece4.setImageResource(resourceID);
                            } else if (i == 4) {
                                piece5.setImageResource(resourceID);
                            } else if (i == 5) {
                                piece6.setImageResource(resourceID);
                            } else if (i == 6) {
                                piece7.setImageResource(resourceID);
                            } else if (i == 7) {
                                piece8.setImageResource(resourceID);
                            } else if (i == 8) {
                                piece9.setImageResource(resourceID);
                            } else if (i == 9) {
                                piece10.setImageResource(resourceID);
                            } else if (i == 10) {
                                piece11.setImageResource(resourceID);
                            } else if (i == 11) {
                                piece12.setImageResource(resourceID);
                            } else if (i == 12) {
                                piece13.setImageResource(resourceID);
                            } else if (i == 13) {
                                piece14.setImageResource(resourceID);
                            } else if (i == 14) {
                                piece15.setImageResource(resourceID);
                            }
                            break;
                        }
                    }
                    if (foundOne == false) {
                        colorsDone[random] = -1;
                        for (int j = 0; j < indexes.size(); j++) {
                            ivList.get(indexes.get(j)).setImageResource(R.drawable.blank6);
                        }
                    }
                } else {
                    colorsDone[random] = -1;
                    for (int i = 0; i < indexes.size(); i++) {
                        ivList.get(indexes.get(i)).setImageResource(R.drawable.blank6);
                    }
                }
                boolean done = true;
                for (int i = 0; i < piecesList.size(); i++) {
                    if (piecesList.get(i) != 0) {
                        done = false;
                    }
                }
                HashSet hsNew = new HashSet();
                hsNew.addAll(filled);
                filled.clear();
                filled.addAll(hsNew);
                if (filled.size() != 36) {
                    done = false;
                }
                if (done) {
                    keepGoing = false;
                    SharedPrefs prefs = new SharedPrefs();
                    int prefsLevel = prefs.getInt(getApplicationContext(), SharedPrefs.SharedKeys.six);
                    if (levelNumInteger > prefsLevel) {
                        prefs.storeInt(getApplicationContext(), SharedPrefs.SharedKeys.six, levelNumInteger);
                    }
                    for (int i = 0; i < ivList.size(); i++) {
                        ivList.get(i).setImageResource(R.drawable.blank6);
                    }
                    count = 0;
                    handler = new Handler();
                    r = new Runnable() {
                        @Override
                        public void run() {
                            if (count < 14) {
                                count++;
                                if (count == 1) {
                                    ivList.get(1).setImageResource(R.drawable.o);
                                } else if (count == 2) {
                                    ivList.get(2).setImageResource(R.drawable.n);
                                } else if (count == 3) {
                                    ivList.get(3).setImageResource(R.drawable.e);
                                } else if (count == 4) {
                                    ivList.get(4).setImageResource(R.drawable.exclamation);
                                } else if (count == 5) {
                                    ivList.get(12).setImageResource(R.drawable.n);
                                } else if (count == 6) {
                                    ivList.get(13).setImageResource(R.drawable.e);
                                } else if (count == 7) {
                                    ivList.get(14).setImageResource(R.drawable.x);
                                } else if (count == 8) {
                                    ivList.get(15).setImageResource(R.drawable.t);
                                } else if (count == 9) {
                                    ivList.get(16).setImageResource(R.drawable.arrow);
                                } else if (count == 10) {
                                    ivList.get(24).setImageResource(R.drawable.m);
                                } else if (count == 11) {
                                    ivList.get(25).setImageResource(R.drawable.e);
                                } else if (count == 12) {
                                    ivList.get(26).setImageResource(R.drawable.n);
                                } else if (count == 13) {
                                    ivList.get(27).setImageResource(R.drawable.u);
                                } else if (count == 14) {
                                    ivList.get(28).setImageResource(R.drawable.menu);
                                }
                            }
                            handler.postDelayed(r, 40);
                        }
                    };
                    ivList.get(0).setImageResource(R.drawable.d);
                    handler.postDelayed(r, 40);
                    canPick = true;
                }
                indexes.clear();
            }
        } else if (canPick) {
            if (action == MotionEvent.ACTION_DOWN) {
                if ((x >= arrowLeft && x <= arrowRight) && (y >= arrowTop && y <= arrowBottom)) {
                    arrowOnPoint = true;
                    ivList.get(16).setImageResource(R.drawable.arrowyellow);
                } else if ((x >= menuLeft && x <= menuRight) && (y >= menuTop && y <= menuBottom)) {
                    menuOnPoint = true;
                    ivList.get(28).setImageResource(R.drawable.menuyellow);
                }
            } else if (action == MotionEvent.ACTION_UP) {
                ivList.get(16).setImageResource(R.drawable.arrow);
                ivList.get(28).setImageResource(R.drawable.menu);
                if (arrowOnPoint) {
                    if ((x >= arrowLeft && x <= arrowRight) && (y >= arrowTop && y <= arrowBottom)) {
                        arrowOnPoint = false;
                        Intent intent = getIntent();
                        if (levelNumInteger < puzzleList.size()) {
                            intent.putExtra("levelNum", (levelNumInteger + 1));
                            startActivity(intent);
                        } else {
                            Intent newIntent2 = new Intent(this, MainMenu.class);
                            startActivity(newIntent2);
                        }
                    }
                } else if (menuOnPoint) {
                    if ((x >= menuLeft && x <= menuRight) && (y >= menuTop && y <= menuBottom)) {
                        menuOnPoint = false;
                        Intent newIntent = new Intent(this, MainMenu.class);
                        startActivity(newIntent);
                    }
                }
            }
        }

        return true;
    }

    public boolean check2l(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 8 && indexes.get(i) != cornerIndex - 14) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 8 && indexes.get(i) != cornerIndex - 14 && indexes.get(i) != cornerIndex - 15 && indexes.get(i) != cornerIndex - 16 && indexes.get(i) != cornerIndex - 22 && indexes.get(i) != cornerIndex - 28) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkCornerLeft(int cornerIndex) {
        if (indexes.size() == 3) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 5) {
                    return false;
                }
            }
        } else if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 10) {
                    return false;
                }
            }
        } else if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 17 && indexes.get(i) != cornerIndex - 16 && indexes.get(i) != cornerIndex - 15) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 23 && indexes.get(i) != cornerIndex - 22 && indexes.get(i) != cornerIndex - 21 && indexes.get(i) != cornerIndex - 20) {
                    return false;
                }
            }
        } else if (indexes.size() == 11) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 30 && indexes.get(i) != cornerIndex - 29 && indexes.get(i) != cornerIndex - 28 && indexes.get(i) != cornerIndex - 27 && indexes.get(i) != cornerIndex - 26 && indexes.get(i) != cornerIndex - 25) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkCornerRight(int cornerIndex) {
        if (indexes.size() == 3) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 7) {
                    return false;
                }
            }
        } else if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex - 14) {
                    return false;
                }
            }
        } else if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 19 && indexes.get(i) != cornerIndex - 20 && indexes.get(i) != cornerIndex - 21) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 25 && indexes.get(i) != cornerIndex - 26 && indexes.get(i) != cornerIndex - 27 && indexes.get(i) != cornerIndex - 28) {
                    return false;
                }
            }
        } else if (indexes.size() == 11) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 30 && indexes.get(i) != cornerIndex - 31 && indexes.get(i) != cornerIndex - 32 && indexes.get(i) != cornerIndex - 33 && indexes.get(i) != cornerIndex - 34 && indexes.get(i) != cornerIndex - 35) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkFlip2l(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 10) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 10 && indexes.get(i) != cornerIndex - 16 && indexes.get(i) != cornerIndex - 22 && indexes.get(i) != cornerIndex - 21 && indexes.get(i) != cornerIndex - 20) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkFlipLongL(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 4) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 17 && indexes.get(i) != cornerIndex - 16 && indexes.get(i) != cornerIndex - 15 && indexes.get(i) != cornerIndex - 14 && indexes.get(i) != cornerIndex - 13) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkFlipLongU(int cornerIndex) {
        if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex - 14 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 8) {
                    return false;
                }
            }
        } else if (indexes.size() == 16) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 30 && indexes.get(i) != cornerIndex - 31 && indexes.get(i) != cornerIndex - 32 && indexes.get(i) != cornerIndex - 33 && indexes.get(i) != cornerIndex - 34 && indexes.get(i) != cornerIndex - 35 && indexes.get(i) != cornerIndex - 29 && indexes.get(i) != cornerIndex - 23 && indexes.get(i) != cornerIndex - 17 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 5) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkFlipReverse2l(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex - 14) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 13  && indexes.get(i) != cornerIndex - 14  && indexes.get(i) != cornerIndex - 20  && indexes.get(i) != cornerIndex - 26 && indexes.get(i) != cornerIndex - 27 && indexes.get(i) != cornerIndex - 28) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkFlipReverseLongL(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 8) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 19 && indexes.get(i) != cornerIndex - 20 && indexes.get(i) != cornerIndex - 21 && indexes.get(i) != cornerIndex - 22 && indexes.get(i) != cornerIndex - 23) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkFlipTallL(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 11) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 30 && indexes.get(i) != cornerIndex - 29 && indexes.get(i) != cornerIndex - 28 && indexes.get(i) != cornerIndex - 27) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkFlipU(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 8 && indexes.get(i) != cornerIndex - 2) {
                    return false;
                }
            }
        } else if (indexes.size() == 12) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 19 && indexes.get(i) != cornerIndex - 20 && indexes.get(i) != cornerIndex - 21 && indexes.get(i) != cornerIndex - 22 && indexes.get(i) != cornerIndex - 23 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 17) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkHorizontalLine() {
        if (indexes.size() < 2 || indexes.size() > 6) {
            return false;
        }

        boolean inLine1 = true;
        boolean inLine2= true;
        boolean inLine3 = true;
        boolean inLine4 = true;
        boolean inLine5 = true;
        boolean inLine6 = true;
        for (int i = 0; i < indexes.size(); i++) {
            if (indexes.get(i) > 5) {
                inLine1 = false;
                break;
            }
        }
        if (!inLine1) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) > 11 || indexes.get(i) < 6) {
                    inLine2 = false;
                    break;
                }
            }
            if (!inLine2) {
                for (int i = 0; i < indexes.size(); i++) {
                    if (indexes.get(i) > 17 || indexes.get(i) < 12) {
                        inLine3 = false;
                        break;
                    }
                }
                if (!inLine3) {
                    for (int i = 0; i < indexes.size(); i++) {
                        if (indexes.get(i) > 23 || indexes.get(i) < 18) {
                            inLine4 = false;
                            break;
                        }
                    }
                    if (!inLine4) {
                        for (int i = 0; i < indexes.size(); i++) {
                            if (indexes.get(i) > 29 || indexes.get(i) < 24) {
                                inLine5 = false;
                                break;
                            }
                        }
                        if (!inLine5) {
                            for (int i = 0; i < indexes.size(); i++) {
                                if (indexes.get(i) > 35 || indexes.get(i) < 30) {
                                    inLine6 = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!inLine1 && !inLine2 && !inLine3 && !inLine4 && !inLine5 && !inLine6) {
            return false;
        }

        for (int i = 0; i < indexes.size(); i++) {
            for (int j = 0; j < indexes.size(); j++) {
                if (Math.abs(indexes.get(i) - indexes.get(j)) >= 6) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkIntegral(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 11) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkL(int cornerIndex) {
        if (indexes.size() == 3) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 7) {
                    return false;
                }
            }
        } else if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 8 && indexes.get(i) != cornerIndex - 14) {
                    return false;
                }
            }
        } else if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 21 && indexes.get(i) != cornerIndex - 15 && indexes.get(i) != cornerIndex - 9) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 10 && indexes.get(i) != cornerIndex - 16 && indexes.get(i) != cornerIndex - 22 && indexes.get(i) != cornerIndex - 28) {
                    return false;
                }
            }
        } else if (indexes.size() == 11) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 17 && indexes.get(i) != cornerIndex - 23 && indexes.get(i) != cornerIndex - 29 && indexes.get(i) != cornerIndex - 35) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkLongL(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 8) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 17 && indexes.get(i) != cornerIndex - 23) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkLongU(int cornerIndex) {
        if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 8 && indexes.get(i) != cornerIndex - 14 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12) {
                    return false;
                }
            }
        } else if (indexes.size() == 16) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 17 && indexes.get(i) != cornerIndex - 23 && indexes.get(i) != cornerIndex - 29 && indexes.get(i) != cornerIndex - 35 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 30) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkReverse2l(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 11) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 10 && indexes.get(i) != cornerIndex - 16 && indexes.get(i) != cornerIndex - 22) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkReverseFlipTallL(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 13) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 30 && indexes.get(i) != cornerIndex - 31 && indexes.get(i) != cornerIndex - 32 && indexes.get(i) != cornerIndex - 33) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkReverseIntegral(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex - 14) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkReverseL(int cornerIndex) {
        if (indexes.size() == 3) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6) {
                    return false;
                }
            }
        } else if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 12) {
                    return false;
                }
            }
        } else if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 18) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 24) {
                    return false;
                }
            }
        } else if (indexes.size() == 11) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 30) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    public boolean checkReverseLongL(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 6) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkReverseSideIntegral(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 8 && indexes.get(i) != cornerIndex - 14) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkReverseSideLongU(int cornerIndex) {
        if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 8 && indexes.get(i) != cornerIndex - 14 && indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex - 12) {
                    return false;
                }
            }
        } else if (indexes.size() == 16) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 17 && indexes.get(i) != cornerIndex - 23 && indexes.get(i) != cornerIndex - 29 && indexes.get(i) != cornerIndex - 35 && indexes.get(i) != cornerIndex - 34 && indexes.get(i) != cornerIndex - 33 && indexes.get(i) != cornerIndex - 32 && indexes.get(i) != cornerIndex - 31 && indexes.get(i) != cornerIndex - 30) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkReverseSideU(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex) {
                    return false;
                }
            }
        } else if (indexes.size() == 12) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 9 && indexes.get(i) != cornerIndex - 15 && indexes.get(i) != cornerIndex - 21 && indexes.get(i) != cornerIndex - 27 && indexes.get(i) != cornerIndex - 33 && indexes.get(i) != cornerIndex - 32 && indexes.get(i) != cornerIndex - 31 && indexes.get(i) != cornerIndex - 30) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkReverseTallL(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 1) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 30 && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkReverseVZigZag(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 11) {
                    return false;
                }
            }
        } else if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 10 && indexes.get(i) != cornerIndex - 16 && indexes.get(i) != cornerIndex - 22) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkReverseZigZag(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 8) {
                    return false;
                }
            }
        } else if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 8 && indexes.get(i) != cornerIndex - 14 && indexes.get(i) != cornerIndex - 15 && indexes.get(i) != cornerIndex - 16) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkSideIntegral(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 10) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkSideLongU(int cornerIndex) {
        if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 14 && indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex - 12) {
                    return false;
                }
            }
        } else if (indexes.size() == 16) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 30 && indexes.get(i) != cornerIndex - 31 && indexes.get(i) != cornerIndex - 32 && indexes.get(i) != cornerIndex - 33 && indexes.get(i) != cornerIndex - 34 && indexes.get(i) != cornerIndex - 35) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkSideU(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex) {
                    return false;
                }
            }
        } else if (indexes.size() == 12) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 30 && indexes.get(i) != cornerIndex - 31 && indexes.get(i) != cornerIndex - 32 && indexes.get(i) != cornerIndex - 33) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkSquare(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 7) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex -13 && indexes.get(i) != cornerIndex - 14 && indexes.get(i) != cornerIndex - 8) {
                    return false;
                }
            }
        } else if (indexes.size() == 16) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex - 14 && indexes.get(i) != cornerIndex - 8 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 9 && indexes.get(i) != cornerIndex - 15 && indexes.get(i) != cornerIndex - 21 && indexes.get(i) != cornerIndex - 20 && indexes.get(i) != cornerIndex - 19 && indexes.get(i) != cornerIndex - 18) {
                    return false;
                }
            }
        } else if (indexes.size() == 25) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex - 14 && indexes.get(i) != cornerIndex - 8 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 9 && indexes.get(i) != cornerIndex - 15 && indexes.get(i) != cornerIndex - 21 && indexes.get(i) != cornerIndex - 20 && indexes.get(i) != cornerIndex - 19 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 10 && indexes.get(i) != cornerIndex - 16 && indexes.get(i) != cornerIndex - 22 && indexes.get(i) != cornerIndex - 28 && indexes.get(i) != cornerIndex - 27 && indexes.get(i) != cornerIndex - 26 && indexes.get(i) != cornerIndex - 25 && indexes.get(i) != cornerIndex - 24) {
                    return false;
                }
            }
        } else if (indexes.size() == 36) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    public boolean checkTallL(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 1) {
                    return false;
                }
            }
        } else if (indexes.size() == 9) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 33 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 27 && indexes.get(i) != cornerIndex - 21 && indexes.get(i) != cornerIndex - 15 && indexes.get(i) != cornerIndex - 9 && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkUPiece(int cornerIndex) {
        if (indexes.size() == 5) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 8 && indexes.get(i) != cornerIndex - 2) {
                    return false;
                }
            }
        } else if (indexes.size() == 12) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 3 && indexes.get(i) != cornerIndex - 4 && indexes.get(i) != cornerIndex - 23 && indexes.get(i) != cornerIndex - 5 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 17) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkVZigZag(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 7 && indexes.get(i) != cornerIndex - 13) {
                    return false;
                }
            }
        } else if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 13 && indexes.get(i) != cornerIndex - 14 && indexes.get(i) != cornerIndex - 20 && indexes.get(i) != cornerIndex - 26) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean checkVerticalLine(int cornerIndex) {
        if (indexes.size() < 2 || indexes.size() > 6) {
            return false;
        }
        for (int i = 0; i < indexes.size(); i++) {
            if (indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 18 && indexes.get(i) != cornerIndex - 24 && indexes.get(i) != cornerIndex - 30) {
                return false;
            }
        }
        return true;
    }

    public boolean checkZigzag(int cornerIndex) {
        if (indexes.size() == 4) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 5) {
                    return false;
                }
            }
        } else if (indexes.size() == 7) {
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i) != cornerIndex - 1 && indexes.get(i) != cornerIndex && indexes.get(i) != cornerIndex - 6 && indexes.get(i) != cornerIndex - 2 && indexes.get(i) != cornerIndex - 12 && indexes.get(i) != cornerIndex - 11 && indexes.get(i) != cornerIndex - 10) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public int convertToIndex(int x, int y) {
        return (x) + (y * 6);
    }

    @Override
    public boolean onLongClick(View view) {
        Shape tempShape;
        if (view.getId() == R.id.piece1) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 0) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(0);
            remove(tempShape, 0);
            if (tempShape.getFilled()) {
                piece1.setImageResource(piecesListOriginal.get(0));
                shapes.set(0, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece2 && shapes.size() >= 2) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 1) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(1);
            remove(tempShape, 1);
            if (tempShape.getFilled()) {
                piece2.setImageResource(piecesListOriginal.get(1));
                shapes.set(1, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece3 && shapes.size() >= 3) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 2) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(2);
            remove(tempShape, 2);
            if (tempShape.getFilled()) {
                piece3.setImageResource(piecesListOriginal.get(2));
                shapes.set(2, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece4 && shapes.size() >= 4) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 3) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(3);
            remove(tempShape, 3);
            if (tempShape.getFilled()) {
                piece4.setImageResource(piecesListOriginal.get(3));
                shapes.set(3, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece5 && shapes.size() >= 5) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 4) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(4);
            remove(tempShape, 4);
            if (tempShape.getFilled()) {
                piece5.setImageResource(piecesListOriginal.get(4));
                shapes.set(4, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece6 && shapes.size() >= 6) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 5) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(5);
            remove(tempShape, 5);
            if (tempShape.getFilled()) {
                piece6.setImageResource(piecesListOriginal.get(5));
                shapes.set(5, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece7 && shapes.size() >= 7) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 6) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(6);
            remove(tempShape, 6);
            if (tempShape.getFilled()) {
                piece7.setImageResource(piecesListOriginal.get(6));
                shapes.set(6, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece8 && shapes.size() >= 8) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 7) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(7);
            remove(tempShape, 7);
            if (tempShape.getFilled()) {
                piece8.setImageResource(piecesListOriginal.get(7));
                shapes.set(7, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece9 && shapes.size() >= 9) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 8) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(8);
            remove(tempShape, 8);
            if (tempShape.getFilled()) {
                piece9.setImageResource(piecesListOriginal.get(8));
                shapes.set(8, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece10 && shapes.size() >= 10) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 9) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(9);
            remove(tempShape, 9);
            if (tempShape.getFilled()) {
                piece10.setImageResource(piecesListOriginal.get(9));
                shapes.set(9, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece11 && shapes.size() >= 11) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 10) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(10);
            remove(tempShape, 10);
            if (tempShape.getFilled()) {
                piece11.setImageResource(piecesListOriginal.get(10));
                shapes.set(10, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece12 && shapes.size() >= 12) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 11) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(11);
            remove(tempShape, 11);
            if (tempShape.getFilled()) {
                piece12.setImageResource(piecesListOriginal.get(11));
                shapes.set(11, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece13 && shapes.size() >= 13) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 12) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(12);
            remove(tempShape, 12);
            if (tempShape.getFilled()) {
                piece13.setImageResource(piecesListOriginal.get(12));
                shapes.set(12, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece14 && shapes.size() >= 14) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 13) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(13);
            remove(tempShape, 13);
            if (tempShape.getFilled()) {
                piece14.setImageResource(piecesListOriginal.get(13));
                shapes.set(13, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.piece15 && shapes.size() >= 15) {
            for (int i = 0; i < colorsDone.length; i++) {
                if (colorsDone[i] == 14) {
                    colorsDone[i] = -1;
                }
            }
            tempShape = shapes.get(14);
            remove(tempShape, 14);
            if (tempShape.getFilled()) {
                piece15.setImageResource(piecesListOriginal.get(14));
                shapes.set(14, new Shape(new ArrayList<Integer>(), 0, false));
            }
        } else if (view.getId() == R.id.clear6) {
            filled.clear();
            Arrays.fill(colorsDone, -1);
            for (int i = 0; i < ivList.size(); i++) {
                ivList.get(i).setImageResource(R.drawable.blank6);
            }
            resetPieces();
            piecesList = new ArrayList<>();
            for (int i = 0; i < piecesListOriginal.size(); i++) {
                piecesList.add(piecesListOriginal.get(i));
            }
            SharedPrefs prefs3 = new SharedPrefs();
            boolean easy = prefs3.getBoolean(getApplicationContext(), "easy");
            boolean medium = prefs3.getBoolean(getApplicationContext(), "medium");
            if (medium) {
                ArrayList<Integer> piece1 = current.getFirst();
                for (int j = 0; j < piece1.size(); j++) {
                    ivList.get(piece1.get(j)).setImageResource(R.drawable.whitesquarer);
                    filled.add(piece1.get(j));
                }
            } else if (easy) {
                ArrayList<Integer> piece1 = current.getFirst();
                ArrayList<Integer> piece2 = current.getSecond();
                for (int j = 0; j < piece1.size(); j++) {
                    ivList.get(piece1.get(j)).setImageResource(R.drawable.whitesquarer);
                    filled.add(piece1.get(j));
                }
                for (int j = 0; j < piece2.size(); j++) {
                    ivList.get(piece2.get(j)).setImageResource(R.drawable.whitesquarer);
                    filled.add(piece2.get(j));
                }
            }
        }
        return false;
    }

    public void remove(Shape tempShape, int referenceNum) {
        ArrayList<Integer> tempIndexes;
        if (tempShape.getFilled()) {
            tempIndexes = tempShape.getValues();

            for (int i = 0; i < tempIndexes.size(); i++) {
                ivList.get(tempIndexes.get(i)).setImageResource(R.drawable.blank6);
            }
            for (int j = 0; j < tempIndexes.size(); j++) {
                filled.remove(Integer.valueOf(tempIndexes.get(j)));
            }
            tempIndexes.clear();
            piecesList.set(referenceNum, piecesListOriginal.get(referenceNum));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_in_game_six, menu);
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

    private void initialize() {
        ivList = new ArrayList<>();
        levelTv = (TextView) findViewById(R.id.level);
        piece1 = (ImageView) findViewById(R.id.piece1);
        piece2 = (ImageView) findViewById(R.id.piece2);
        piece3 = (ImageView) findViewById(R.id.piece3);
        piece4 = (ImageView) findViewById(R.id.piece4);
        piece5 = (ImageView) findViewById(R.id.piece5);
        piece6 = (ImageView) findViewById(R.id.piece6);
        piece7 = (ImageView) findViewById(R.id.piece7);
        piece8 = (ImageView) findViewById(R.id.piece8);
        piece9 = (ImageView) findViewById(R.id.piece9);
        piece10 = (ImageView) findViewById(R.id.piece10);
        piece11 = (ImageView) findViewById(R.id.piece11);
        piece12 = (ImageView) findViewById(R.id.piece12);
        piece13 = (ImageView) findViewById(R.id.piece13);
        piece14 = (ImageView) findViewById(R.id.piece14);
        piece15 = (ImageView) findViewById(R.id.piece15);
        iv0 = (ImageView) findViewById(R.id.iv00);
        iv1 = (ImageView) findViewById(R.id.iv10);
        iv2 = (ImageView) findViewById(R.id.iv20);
        iv3 = (ImageView) findViewById(R.id.iv30);
        iv4 = (ImageView) findViewById(R.id.iv40);
        iv5 = (ImageView) findViewById(R.id.iv50);
        iv6 = (ImageView) findViewById(R.id.iv01);
        iv7 = (ImageView) findViewById(R.id.iv11);
        iv8 = (ImageView) findViewById(R.id.iv21);
        iv9 = (ImageView) findViewById(R.id.iv31);
        iv10 = (ImageView) findViewById(R.id.iv41);
        iv11 = (ImageView) findViewById(R.id.iv51);
        iv12 = (ImageView) findViewById(R.id.iv02);
        iv13 = (ImageView) findViewById(R.id.iv12);
        iv14 = (ImageView) findViewById(R.id.iv22);
        iv15 = (ImageView) findViewById(R.id.iv32);
        iv16 = (ImageView) findViewById(R.id.iv42);
        iv17 = (ImageView) findViewById(R.id.iv52);
        iv18 = (ImageView) findViewById(R.id.iv03);
        iv19 = (ImageView) findViewById(R.id.iv13);
        iv20 = (ImageView) findViewById(R.id.iv23);
        iv21 = (ImageView) findViewById(R.id.iv33);
        iv22 = (ImageView) findViewById(R.id.iv43);
        iv23 = (ImageView) findViewById(R.id.iv53);
        iv24 = (ImageView) findViewById(R.id.iv04);
        iv25 = (ImageView) findViewById(R.id.iv14);
        iv26 = (ImageView) findViewById(R.id.iv24);
        iv27 = (ImageView) findViewById(R.id.iv34);
        iv28 = (ImageView) findViewById(R.id.iv44);
        iv29 = (ImageView) findViewById(R.id.iv54);
        iv30 = (ImageView) findViewById(R.id.iv05);
        iv31 = (ImageView) findViewById(R.id.iv15);
        iv32 = (ImageView) findViewById(R.id.iv25);
        iv33 = (ImageView) findViewById(R.id.iv35);
        iv34 = (ImageView) findViewById(R.id.iv45);
        iv35 = (ImageView) findViewById(R.id.iv55);

        ImageView[] ivArray = {iv0, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11, iv12, iv13, iv14, iv15, iv16, iv17, iv18, iv19, iv20, iv21, iv22, iv23, iv24, iv25, iv26, iv27, iv28, iv29, iv30, iv31, iv32, iv33, iv34, iv35};
        ivList.addAll(Arrays.asList(ivArray));

        ivPieces = new ArrayList<>();
        ImageView[] ivPiecesArray = {piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8, piece9, piece10, piece11, piece12, piece13, piece14, piece15};
        ivPieces.addAll(Arrays.asList(ivPiecesArray));
    }

    public void resetPieces() {
        int numNotDone = 15;
        if (piecesList.size() > 0) {
            piece1.setImageResource(piecesListOriginal.get(0));
            piece1.setOnLongClickListener(this);
            numNotDone = 14;
        }
        if (piecesList.size() > 1) {
            piece2.setImageResource(piecesListOriginal.get(1));
            piece2.setOnLongClickListener(this);
            numNotDone = 13;
        }
        if (piecesList.size() > 2) {
            piece3.setImageResource(piecesListOriginal.get(2));
            piece3.setOnLongClickListener(this);
            numNotDone = 12;
        }
        if (piecesList.size() > 3) {
            piece4.setImageResource(piecesListOriginal.get(3));
            piece4.setOnLongClickListener(this);
            numNotDone = 11;
        }
        if (piecesList.size() > 4) {
            piece5.setImageResource(piecesListOriginal.get(4));
            piece5.setOnLongClickListener(this);
            numNotDone = 10;
        }
        if (piecesList.size() > 5) {
            piece6.setImageResource(piecesListOriginal.get(5));
            piece6.setOnLongClickListener(this);
            numNotDone = 9;
        }
        if (piecesList.size() > 6) {
            piece7.setImageResource(piecesListOriginal.get(6));
            piece7.setOnLongClickListener(this);
            numNotDone = 8;
        }
        if (piecesList.size() > 7) {
            piece8.setImageResource(piecesListOriginal.get(7));
            piece8.setOnLongClickListener(this);
            numNotDone = 7;
        }
        if (piecesList.size() > 8) {
            piece9.setImageResource(piecesListOriginal.get(8));
            piece9.setOnLongClickListener(this);
            numNotDone = 6;
        }
        if (piecesList.size() > 9) {
            piece10.setImageResource(piecesListOriginal.get(9));
            piece10.setOnLongClickListener(this);
            numNotDone = 5;
        }
        if (piecesList.size() > 10) {
            piece11.setImageResource(piecesListOriginal.get(10));
            piece11.setOnLongClickListener(this);
            numNotDone = 4;
        }
        if (piecesList.size() > 11) {
            piece12.setImageResource(piecesListOriginal.get(11));
            piece12.setOnLongClickListener(this);
            numNotDone = 3;
        }
        if (piecesList.size() > 12) {
            piece13.setImageResource(piecesListOriginal.get(12));
            piece13.setOnLongClickListener(this);
            numNotDone = 2;
        }
        if (piecesList.size() > 13) {
            piece14.setImageResource(piecesListOriginal.get(13));
            piece14.setOnLongClickListener(this);
            numNotDone = 1;
        }
        if (piecesList.size() > 14) {
            piece15.setImageResource(piecesListOriginal.get(14));
            piece15.setOnLongClickListener(this);
            numNotDone = 0;
        }
        for (int i = 0; i < numNotDone; i++) {
            ivPieces.get(14 - i).setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        Intent newIntent = new Intent(this, SelectSix.class);
        startActivity(newIntent);
    }
}


/*

red: #ff0000
orange: #ff7600
yellow: #ffe700
green: #2bff00
cyan: #00ccff
blue: #1500ff
pink: #ea00ff
purple: #50007b
dark red: #490000
aqua: #007e6d

 */