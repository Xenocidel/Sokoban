package com.xc.sokoban;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Aaron on 2016-04-22.
 */
public class SwipeListener extends GestureDetector.SimpleOnGestureListener {

    static final int SWIPE_DIS = 100;
    static final int SWIPE_VEL = 100;
    GameView gameView;

    public SwipeListener(GameView gameView) {
        this.gameView = gameView;
        Log.i("init", "SwipeListener received gameView");
    }



    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float deltaX = e1.getX() - e2.getX();
        float deltaY = e1.getY() - e2.getY();
        try {
            if ((deltaX > SWIPE_DIS) && (Math.abs(velocityX) > SWIPE_VEL)) {
                Log.i("Touch", "Left");
            } else if ((-deltaX > SWIPE_DIS) && (Math.abs(velocityX) > SWIPE_VEL)) {
                Log.i("Touch", "Right");
            } else if ((deltaY > SWIPE_DIS) && (Math.abs(velocityY) > SWIPE_VEL)) {
                Log.i("Touch", "Up");
            } else if ((-deltaY > SWIPE_DIS) && (Math.abs(velocityY) > SWIPE_VEL)) {
                Log.i("Touch", "Down");
            }
        } catch (Exception e) {
            //ignore
        }
        return true;
    }

}
