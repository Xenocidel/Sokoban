package com.xc.sokoban;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Jimmy on 2016/4/19.
 */
public class Wall {

    private RectF rect;
    private boolean isWall;
    private int width;
    private  int height;
    private int x;
    private int y;
    private int space;
    public static int numOfWall;

    public Wall(int x, int y, int space){
        this.x = x;
        this.y = y;
        this.space = space;
        isWall = true;
        rect = new RectF(x, y, x+space, y+space);
        numOfWall++;
    }

    public void draw(Canvas c){
        Paint p = new Paint();
        p.setColor(Color.DKGRAY);
        c.drawRect(rect, p);
    }

    public boolean getIsWall(){return isWall;}


}
