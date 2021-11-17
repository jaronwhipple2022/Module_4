package com.example.wanderingbear;

public class WalkingBear {
    // declare a few variables
    private int bearX;
    private int bearY;
    private int currentFrame;
    private int velocity;
    public static int maximumFrame;
    public WalkingBear() {
        bearX = AppHolder.SCRN_WIDTH_X/2 - AppHolder.getBitmapControl().getBearWidth()/2;
        bearY = AppHolder.SCRN_HEIGHT_Y/2 - AppHolder.getBitmapControl().getBearHeight()/2;
        currentFrame = 0;
        maximumFrame = 2;
    }
    // getter setter methods
    public int getCurrentFrame(){
        return currentFrame;
    }
    public void setCurrentFrame(int currentFrame){
        this.currentFrame = currentFrame;
    }
    public int getX(){
        return bearX;
    }
    public int getY(){
        return bearY;
    }
    public void setX(int birdX){
        this.bearX = birdX;
    }
    public void setY(int birdY){
        this.bearY = birdY;
    }
    public int getVelocity(){
        return velocity;
    }
    public void setVelocity(int velocity){
        this.velocity = velocity;
    }
}
