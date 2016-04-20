package com.xc.sokoban;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Jimmy on 2016/4/19.
 */
public class Box {
    private RectF rect;
    private int width;
    private  int height;
    private int x;
    private int y;
    private int space;
    public static int numOfSpot;

    public Box(int x, int y, int space){
        this.x = x;
        this.y = y;
        this.space = space;
        rect = new RectF(x, y, x+space, y+space);
        numOfSpot++;
    }


    public void draw(Canvas c){
        Paint p = new Paint();
        p.setColor(Color.GREEN);
        c.drawRect(rect, p);
    }

}
