package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Tower extends Pantalla {

    private Stage stage;
    private World world;
    private BloqueEntity bloque;
    private Texture texture;


    public Tower(MainGame game) {
        super(game);
        stage = new Stage();
        world = new World(new Vector2(0,10),true);

    }

    @Override
    public void show() {

        //Texture bloqueTexture = game.getManager().get("bloque.png");

            //bloque = new BloqueEntity(world,bloqueTexture);
            stage.addActor(bloque);

    }

    @Override
    public void hide() {
        bloque.detach();
        bloque.remove();
    }

    @Override
    public void dispose() {
        stage.dispose();
        world.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

}
