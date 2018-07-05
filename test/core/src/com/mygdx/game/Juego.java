package com.mygdx.game;

public abstract class Juego extends MainGame {

    protected int x,y,width,height;

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setX(int a){
        x=a;
    }

    public void setY(int a){
        y=a;
    }

    public void setWidth(int a){
        width=a;
    }

    public void setHeight(int a){
        height=a;
    }
}
