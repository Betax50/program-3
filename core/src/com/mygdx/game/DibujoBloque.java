package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

public class DibujoBloque extends Actor {

    private int x, y;
    private boolean alive = false;
    private ArrayList<DibujoBloque> cuads = new ArrayList<DibujoBloque>();
    private DibujoBloque cuad;
    //private ShapeRenderer cuad;
    private int ancho=30;
    private int alto=30;
    private int i;
    private ShapeRenderer shapeRenderer;


    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void agregar(){
            if (Gdx.input.isTouched()) {
                x = Gdx.input.getX();
                y = Gdx.input.getY();
                cuad = new DibujoBloque();
                cuads.add(cuad);
                alive=true;
            }
    }

    public void dibujo(ShapeRenderer hola){
        hola.begin(ShapeRenderer.ShapeType.Filled);
        hola.setColor(Color.SCARLET);
        hola.rect(x - 10, Gdx.graphics.getHeight() - y - 10, ancho, alto);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.end();
        this.agregar();

        for (DibujoBloque i:cuads){
            i.dibujo(shapeRenderer);
        }



        //shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());


        //cuad.begin(ShapeRenderer.ShapeType.Filled);
        //cuad.setColor(Color.SCARLET);
        //if (alive) {
          //  cuad.rect(x - 10, Gdx.graphics.getHeight() - y - 10, ancho, alto);
            //alive=false;
        //}

        //cuad.rect(x - 100, Gdx.graphics.getHeight() - y - 100, ancho, alto);
        //cuad.end();
        batch.begin();
    }
}
