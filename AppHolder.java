package com.example.wanderingbear;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppHolder {
    //declare bitmap control and game manager objects to reference
    static BitmapControl bitmapControl;
    static GameManager gameManager;
    static int SCRN_WIDTH_X;
    static int SCRN_HEIGHT_Y;
    static int gravityPull;
    static int JUMP_VELOCITY;
    static int treeGap;
    static int tree_numbers;
    static int treeVelocity;
    static int minimumTreeCollection_Y;
    static int maximumTreeCollection_Y;
    static int treeDistance;
    static Context gameActivityContext;

    public static void assign(Context context){
        // *** mapScreenSize method needs to be first
        mapScreenSize(context);
        bitmapControl = new BitmapControl(context.getResources());
        holdGameVariables();
        gameManager = new GameManager();
    }

    public static void holdGameVariables(){
        AppHolder.gravityPull = 5;
        AppHolder.JUMP_VELOCITY =-40;
        AppHolder.treeGap = 700;
        AppHolder.tree_numbers = 2;
        AppHolder.treeVelocity = 24;
        AppHolder.minimumTreeCollection_Y = (int)(AppHolder.treeGap / 2.0);
        AppHolder.maximumTreeCollection_Y = AppHolder.SCRN_HEIGHT_Y - AppHolder.minimumTreeCollection_Y - AppHolder.treeGap;
        AppHolder.treeDistance = AppHolder.SCRN_WIDTH_X * 2 / 3;
    }
    public static BitmapControl getBitmapControl(){
        return bitmapControl;
    }
    public static GameManager getGameManager(){
        return gameManager;
    }

    // this is responsible for organizing the layout of the screen
    private static void mapScreenSize(Context context){
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display dsp = manager.getDefaultDisplay();
        DisplayMetrics dMetrics = new DisplayMetrics();
        dsp.getMetrics(dMetrics);
        int width = dMetrics.widthPixels;
        int height = dMetrics.heightPixels;
        AppHolder.SCRN_WIDTH_X = width;
        AppHolder.SCRN_HEIGHT_Y = height;
    }
}
