package com.xc.sokoban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Jimmy on 2016/4/19.
 */
public class Box extends Tile{

    public static int numOfSpot;

    public Box(Context context, int x, int y, int space){
        super(x, y, space);
        numOfSpot++;
        Bitmap tmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.box);
        bitmap = Bitmap.createScaledBitmap(tmp, space, space, false);
    }

    public void draw(Canvas c){
        c.drawBitmap(bitmap, null, rect, null);
    }
}
