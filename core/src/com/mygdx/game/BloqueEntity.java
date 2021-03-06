package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import static com.mygdx.game.constantes.Constants.*;

public class BloqueEntity extends Actor {

    private Texture texture;

    private World world;

    private Body body;

    private Fixture fixture;

    private int x,y;

    public BloqueEntity (World world,Texture texture){
        this.world = world;
        this.texture = texture;

        BodyDef def = new BodyDef();
        def.position.set(3,3);
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);

        PolygonShape box = new PolygonShape();
        box.setAsBox(0.5f,0.5f);
        fixture = body.createFixture(box, 3);
        box.dispose();

        setSize(PIXELS_IN_METER,PIXELS_IN_METER);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //setPosition(body.getPosition().x*PIXELS_IN_METER,body.getPosition().y*PIXELS_IN_METER);
        setPosition(x*PIXELS_IN_METER,y*PIXELS_IN_METER);
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }

    public void detach(){
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }
}
