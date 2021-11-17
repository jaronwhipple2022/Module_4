package com.example.wanderingbear;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePlay extends SurfaceView implements SurfaceHolder.Callback {
    MainThread mainThread;
    public GamePlay(Context context) {
        super(context);
        SurfaceHolder myHolder = getHolder();
        myHolder.addCallback(this);
        mainThread = new MainThread(myHolder);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mainThread.setIsRunning(true);
        mainThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry){
            try {
                mainThread.setIsRunning(false);
                mainThread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        AppHolder.getGameManager().gameState = 1;
        AppHolder.getGameManager().bear.setVelocity(AppHolder.JUMP_VELOCITY);
        return true;
    }
}
