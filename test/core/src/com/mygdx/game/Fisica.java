package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Fisica extends Pantalla {
    public Fisica(MainGame game){
        super(game);
    }

    private World mundo;
    private Box2DDebugRenderer renderer;
    private OrthographicCamera camera;
    private Body sueloBody;
    private Fixture sueloFixture;
    private Body bloqueBody;
    private Fixture bloqueFixture;


    @Override
    public void show() {
        mundo = new World(new Vector2(0,10),true);
        renderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(26.6f,23);

        BodyDef sueloDef = createsueloDef();
        sueloBody = mundo.createBody(sueloDef);

        PolygonShape sueloShape = new PolygonShape();
        sueloShape.setAsBox(5,1);
        sueloFixture = sueloBody.createFixture(sueloShape,1);
        sueloShape.dispose();

        BodyDef bloquedef = createbloquedef(-3.75f, -10);
        bloqueBody = mundo.createBody(bloquedef);
        PolygonShape bloqueShape = new PolygonShape();
        bloqueShape.setAsBox(1,1);
        bloqueFixture = bloqueBody.createFixture(bloqueShape,1);
        bloqueShape.dispose();

    }

    private BodyDef createsueloDef(){
        BodyDef def = new BodyDef();
        def.position.set(0,10);
        def.type = BodyDef.BodyType.StaticBody;
        return def;
    }

    private BodyDef createbloquedef(float x,float y){
        BodyDef def = new BodyDef();
        def.position.set(x,y);
        def.type = BodyDef.BodyType.StaticBody;
        return def;
    }

    @Override
    public void dispose() {
        mundo.destroyBody(sueloBody);
        mundo.dispose();
        renderer.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mundo.step(delta,6,2);
        camera.update();
        renderer.render(mundo,camera.combined);
    }
}
