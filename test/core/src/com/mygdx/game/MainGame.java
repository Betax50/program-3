package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainGame extends Game {

	private AssetManager manager;

	public AssetManager getManager(){
		return manager;
	}

	@Override
	public void create () {
		manager = new AssetManager();
		//manager.load("bloque.png",Texture.class);
		//manager.load("piso.png",Texture.class);
		// manager.finishLoading();

		setScreen(new Tower(this)); }

}
