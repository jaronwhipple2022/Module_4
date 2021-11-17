//This class is responsible for all the methods that control movement of all the objects on the screen
package com.example.wanderingbear;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.CaptivePortal;

import java.util.ArrayList;
import java.util.Random;

public class GameManager {
    BgImage bgImage;
    WalkingBear bear;
    static int gameState;
    ArrayList<TreeCollection>treeCollections;
    Random rand;
    int scoreCount; // will store the users score
    int winningTree; // updates according to next tree
    Paint designPaint;

    // constructor
    public GameManager() {
        bgImage = new BgImage();
        bear = new WalkingBear();
        gameState = 0;
        treeCollections = new ArrayList<>();
        rand = new Random();
        generateTreeObject();
        scoreCount = 0;
        winningTree = 0;
        // this will style the score counter
        designPaint = new Paint();
        designPaint.setColor(Color.BLUE);
        designPaint.setTextSize(250);
        designPaint.setStyle(Paint.Style.FILL);
        designPaint.setFakeBoldText(true);
        designPaint.setShadowLayer(5.0f, 20.0f, 20.0f, Color.BLACK);
        initScoreVariables();
    }

    public void initScoreVariables(){
        scoreCount = 0;
        winningTree = 0;
        designPaint = new Paint();
        designPaint.setColor(Color.BLUE);
        designPaint.setTextSize(250);
        designPaint.setStyle(Paint.Style.FILL);
        designPaint.setFakeBoldText(true);
        designPaint.setShadowLayer(5.0f, 20.0f, 20.0f, Color.BLACK);
    }

    /*
      gameState == 0 : not  runniing
      gameState == 1 : the game is running
      gameState == 2 : The game is over
   */

    public void generateTreeObject(){
        for (int j = 0; j < AppHolder.treeGap; j++) {
            int treeX = AppHolder.SCRN_WIDTH_X + j * AppHolder.treeDistance;
            int upTreeCollectionY = AppHolder.minimumTreeCollection_Y;
            rand.nextInt(AppHolder.maximumTreeCollection_Y - AppHolder.minimumTreeCollection_Y + 1);
            TreeCollection treeCollection = new TreeCollection(treeX,upTreeCollectionY);
            treeCollections.add(treeCollection);
        }
    }

    public void scrollingTree(Canvas canvas){
        if (gameState == 1){

            // function to detect collisions with trees
            if ((treeCollections.get(winningTree).getXtree() < bear.getX() + AppHolder.getBitmapControl().getBearWidth())
                && (treeCollections.get(winningTree).getUpTreeCollection_Y() > bear.getY()
                || treeCollections.get(winningTree).getDownTree_Y() < (bear.getY() +
                    AppHolder.getBitmapControl().getBearHeight()))){
                gameState = 2;
                Context mContext = AppHolder.gameActivityContext;
                Intent mIntent = new Intent(mContext,GameOver.class);
                mIntent.putExtra("score", scoreCount);
                mContext.startActivity(mIntent);
                ((Activity)mContext).finish();
            }

            if (treeCollections.get(winningTree).getXtree() < bear.getX() - AppHolder.getBitmapControl().getTreeWidth()){
                // update score and tree
                scoreCount ++;
                winningTree ++;
                if (winningTree > AppHolder.tree_numbers - 1){
                    winningTree = 0;
                }
            }
            for (int j = 0; j<AppHolder.tree_numbers; j++){
                if (treeCollections.get(j).getXtree()<-AppHolder.getBitmapControl().getTreeWidth()){
                    treeCollections.get(j).setXtree(treeCollections.get(j).getXtree()
                    + AppHolder.tree_numbers * AppHolder.treeDistance);
                    int upTreeCollectionY = AppHolder.minimumTreeCollection_Y +
                            rand.nextInt(AppHolder.maximumTreeCollection_Y - AppHolder.minimumTreeCollection_Y + 1);
                    treeCollections.get(j).setUpTreeCollection_Y(upTreeCollectionY);
                }
                treeCollections.get(j).setXtree(treeCollections.get(j).getXtree() - AppHolder.treeVelocity);
                canvas.drawBitmap(AppHolder.getBitmapControl().getUpTree(), treeCollections.get(j).getXtree(), treeCollections.get(j).getUpTree_Y(), null);
                canvas.drawBitmap(AppHolder.getBitmapControl().getDownTree(), treeCollections.get(j).getXtree(), treeCollections.get(j).getDownTree_Y(), null);
            }
            canvas.drawText("" + scoreCount, 620, 400, designPaint);
        }
    }

    //method responsible for walking bear animation
    public void bearAnimation(Canvas canvas){
        if (gameState == 1) {
            if (bear.getY() <(AppHolder.SCRN_HEIGHT_Y -AppHolder.getBitmapControl().getBearHeight()) || bear.getVelocity()<0 ){
                bear.setVelocity(bear.getVelocity() + AppHolder.gravityPull );
                bear.setY(bear.getY() + bear.getVelocity() );
            }
        }
        int currentFrame = bear.getCurrentFrame();
        canvas.drawBitmap(AppHolder.getBitmapControl().getBear(currentFrame), bear.getX(),bear.getY(),null);
        currentFrame++;
        if (currentFrame > bear.maximumFrame){
            currentFrame = 0;
        }
        bear.setCurrentFrame(currentFrame);
    }

    //method responsible for background scrolling animation
    public void backgroundAnimation(Canvas canvas) {
        bgImage.setX(bgImage.getX() - bgImage.getVelocity());
        if (bgImage.getX() < -AppHolder.getBitmapControl().getBackgroundWidth()) {
            bgImage.setX(0);
        }
        canvas.drawBitmap(AppHolder.getBitmapControl().getBackground(), bgImage.getX(), bgImage.getY(), null);
        // have consistent scrolling animation
        if (bgImage.getX() <-(AppHolder.getBitmapControl().getBackgroundWidth() - AppHolder.SCRN_WIDTH_X));
            canvas.drawBitmap(AppHolder.getBitmapControl().getBackground(), bgImage.getX() +
                    AppHolder.getBitmapControl().getBackgroundWidth(), bgImage.getY(), null);
    }
}
