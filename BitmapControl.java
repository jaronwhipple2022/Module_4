// This class is responsible for updating the background as the game plays
package com.example.wanderingbear;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapControl {
    Bitmap background;
    Bitmap[] WalkingBear;
    Bitmap upTree;
    Bitmap downTree;

    public BitmapControl(Resources res) {
        //get background image from resources
        background = BitmapFactory.decodeResource(res, R.drawable.scroll_background);
        background = imageScale(background);
        WalkingBear = new Bitmap[10];
        WalkingBear[0] = BitmapFactory.decodeResource(res, R.drawable.b11);
        WalkingBear[1] = BitmapFactory.decodeResource(res, R.drawable.b11);
        WalkingBear[2] = BitmapFactory.decodeResource(res, R.drawable.b12);
        WalkingBear[3] = BitmapFactory.decodeResource(res, R.drawable.b12);
        WalkingBear[4] = BitmapFactory.decodeResource(res, R.drawable.b13);
        WalkingBear[5] = BitmapFactory.decodeResource(res, R.drawable.b13);
        WalkingBear[6] = BitmapFactory.decodeResource(res, R.drawable.b14);
        WalkingBear[7] = BitmapFactory.decodeResource(res, R.drawable.b14);
        WalkingBear[8] = BitmapFactory.decodeResource(res, R.drawable.b15);
        WalkingBear[9] = BitmapFactory.decodeResource(res, R.drawable.b15);
        upTree = BitmapFactory.decodeResource(res, R.drawable.top);
        downTree = BitmapFactory.decodeResource(res, R.drawable.bottom);
    }

    // define getter setter methods
    public Bitmap getUpTree(){
        return upTree;
    }
    public Bitmap getDownTree(){
        return downTree;
    }
    public int getTreeWidth(){
        return upTree.getWidth();
    }
    public int getTreeHeight(){
        return upTree.getHeight();
    }
    public Bitmap getBear(int frame){
        return WalkingBear[frame];
    }
    public int getBearWidth() {
        return WalkingBear[0].getWidth();
    }
    public int getBearHeight() {
        return WalkingBear[0].getHeight();
    }

    public Bitmap getBackground(){
        return background;
    }
    public int getBackgroundWidth(){
        return background.getWidth();
    }
    public int getBackgroundHeight(){
        return background.getHeight();
    }
    public Bitmap imageScale(Bitmap bitmap){
        float width_heightRatio = getBackgroundWidth() / getBackgroundHeight();
        int bgScaleWidth = (int) width_heightRatio * AppHolder.SCRN_WIDTH_X;
        return Bitmap.createScaledBitmap(bitmap, bgScaleWidth, AppHolder.SCRN_HEIGHT_Y,false);
    }
}
