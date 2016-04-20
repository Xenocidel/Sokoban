package com.xc.sokoban;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * Created by Aaron on 2016-04-19.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    public GameView(Context context) { super(context) ;
        this.context = context;
        getHolder (). addCallback(this);
        setFocusable(true);
    }

    Context context;
    boolean gameLoaded = false;
    GameThread gt;

    private ArrayList<Wall> walls = new ArrayList();
    private ArrayList<Box> boxes = new ArrayList();
    private ArrayList<Target> targets = new ArrayList();
    Wall wall;
    Target target;
    Box box;
    Player player;
    private int SPACE;

    private String MAZE;


    public void loadGame(int level){
        switch (level){
            case 1:
                MAZE =
                         "########  \n"
                        +"#      ###\n"
                        +"###      #\n"
                        +"#  @     #\n"
                        +"#    @ ###\n"
                        +"##  $    #\n"
                        +"#  @     #\n"
                        +"#     P  ##\n"
                        +"##  ###  #\n"
                        +"#    $   #\n"
                        +"##  ##   #\n"
                        +"## $   $ #\n"
                        +"####     #\n"
                        +"#      @ #\n"
                        +"##########\n";
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        int x = 0;
        int y = 0;
        SPACE = getWidth()/10;
        for (int i = 0; i < MAZE.length(); i++) {
            char item = MAZE.charAt(i);

            if (item == '\n') {
                y += SPACE;
                x = 0;
            } else if(item == '#') {
                wall = new Wall(x, y, SPACE);
                walls.add(wall);
                x += SPACE;
            } else if(item == '@') {
                target = new Target(x, y, SPACE);
                targets.add(target);
                x += SPACE;
            }else if(item == ' '){
                x += SPACE;
            }else if(item == '$'){
                box = new Box(x, y, SPACE);
                boxes.add(box);
                x += SPACE;
            }else if(item == 'P'){
                player = new Player(x, y, SPACE);
            }
        }
    }

    @Override
    public void surfaceCreated ( SurfaceHolder holder ) {
        // Launch animator thread
        if (!gameLoaded) {
            gt = new GameThread(this);
            gt.start();
            gameLoaded = true;
        }
        Log.d("Load", "surfaceView/Thread");
    }

    @Override
    public void draw(Canvas c) {
        super.draw(c);
        c.drawColor(Color.BLACK);
        for(int i=0; i<walls.size(); i++){
            walls.get(i).draw(c);
        }
        for(int i=0; i<targets.size(); i++){
            targets.get(i).draw(c);
        }
        for(int i=0; i<boxes.size(); i++){
            boxes.get(i).draw(c);
        }
        player.draw(c);

    }

    public void update(){

    }

    @Override
    public void surfaceChanged ( SurfaceHolder holder,
                                 int format , int width , int height ) {

    }
    @Override
    public void surfaceDestroyed ( SurfaceHolder holder ) {

    }

}
