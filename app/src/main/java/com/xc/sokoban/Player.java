package com.xc.sokoban;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

/**
 * Created by Jimmy on 2016/4/19.
 */
public class Player extends Tile{

    public static int numOfSpot;



    public Player(Context context, int x, int y, int space){
        super(x, y, space);
        numOfSpot++;
        rect = new RectF(x+space*0.25f, y, x+space*0.75f, y+space);
        Bitmap tmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
        bitmap = Bitmap.createScaledBitmap(tmp, space, space, false);
        status = Status.STOP;

    }

    public void draw(Canvas c){
        c.drawBitmap(bitmap, null, rect, null);
    }

    public void update(){
        switch (status){
            case STOP:

                break;
            case UP:
                y -= space/10;
                break;
            case DOWN:
                y += space/10;
                break;
            case RIGHT:
                x += space/10;
                break;
            case LEFT:
                x -= space/10;
                break;
        }

        rect = new RectF(x+space*0.25f, y, x+space*0.75f, y+space);

    }

    public void setRect(int x, int y){
        this.x = x;
        this.y = y;
    }
}
