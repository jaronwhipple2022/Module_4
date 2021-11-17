package com.example.wanderingbear;

import java.util.Random;

public class TreeCollection {
    private int xTree; // this will hold the X coordinate
    private int upTreeCollection_Y;
    private Random rand;
    private int colorTree;
    public TreeCollection(int xTree, int upTreeCollection_Y){
        this.xTree = xTree;
        this.upTreeCollection_Y = upTreeCollection_Y;
        rand = new Random();
    }


    public void setColorTube(){
        colorTree = rand.nextInt(2);
    }
    public int getColorTree(){
        return colorTree;
    }
    public int getUpTreeCollection_Y(){
        return upTreeCollection_Y;
    }
    public int getXtree(){
        return xTree;
    }
    public int getUpTree_Y(){
        return upTreeCollection_Y - AppHolder.getBitmapControl().getTreeHeight();
    }
    public int getDownTree_Y(){
        return upTreeCollection_Y + AppHolder.treeGap;
    }
    public void setXtree(int x_Tree){
        this.xTree = x_Tree;
    }
    public void setUpTreeCollection_Y(int upTreeCollection_Y){
        this.upTreeCollection_Y = upTreeCollection_Y;
    }
}
