// This class is responsible for updating the background as the game plays
package com.example.wanderingbear;

public class BgImage {

    // create variables used to control background
    private int image_X_background;
    private int image_Y_background;
    private int background_speed;

    public BgImage() {
        //initialize variables
        image_X_background = 0;
        image_X_background = 0;
        background_speed = 4;
    }

    //define getter setter methods
    public int getX() {
        return image_X_background;
    }
    public int getY() {
        return image_Y_background;
    }
    public void setX(int BackgroundImageX){
        this.image_X_background = BackgroundImageX;
    }
    public void setY(int BackgroundImageY){
        this.image_Y_background = BackgroundImageY;
    }
    public int getVelocity() {
        return background_speed;
    }
}
