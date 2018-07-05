package com.mygdx.game;

public class Score extends Juego {
    public int marcador=0;

    public int getMarcador(){
        return marcador;
    }

    public void setMarcador(int x){
        marcador += x;
    }
}
